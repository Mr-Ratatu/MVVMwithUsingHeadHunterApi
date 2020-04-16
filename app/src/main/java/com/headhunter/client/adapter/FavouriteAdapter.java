package com.headhunter.client.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class FavouriteAdapter extends ListAdapter<ItemHunter, FavouriteAdapter.FavouriteViewHolder> {

    private OnFavouriteClickListener onFavouriteClickListener;

    public FavouriteAdapter(OnFavouriteClickListener onFavouriteClickListener) {
        super(DIFF_CALLBACK);
        this.onFavouriteClickListener = onFavouriteClickListener;
    }

    private static final DiffUtil.ItemCallback<ItemHunter> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemHunter>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return oldItem.get_id() == newItem.get_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getEmployer().getName().equals(newItem.getEmployer().getName()) &&
                    oldItem.getSnippet().getResponsibility().equals(newItem.getSnippet().getResponsibility());
        }
    };

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, parent, false);
        return new FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class FavouriteViewHolder extends RecyclerView.ViewHolder {

        private TextView titleVacancy;
        private TextView companyName;
        private TextView description;
        private ImageView settings;

        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);

            titleVacancy = itemView.findViewById(R.id.title_vacancy_favourite);
            companyName = itemView.findViewById(R.id.company_name_favourite);
            description = itemView.findViewById(R.id.description_favourite);
            settings = itemView.findViewById(R.id.settings_favourite);

        }

        void bind(@NonNull ItemHunter itemHunter) {
            titleVacancy.setText(itemHunter.getName());
            companyName.setText(itemHunter.getEmployer().getName());

            try {
                description.setText(itemHunter.getSnippet().getResponsibility());
            } catch (Exception e) {
                e.printStackTrace();
                description.setText("");
            }

            settings.setOnClickListener(view -> onFavouriteClickListener.onClickSettingsFavourite(itemHunter, view));
        }
    }

    public interface OnFavouriteClickListener {
        void onClickSettingsFavourite(ItemHunter itemHunter, View view);
    }
}
