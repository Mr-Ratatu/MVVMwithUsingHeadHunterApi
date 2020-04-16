package com.headhunter.client.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class HeadHunterAdapter extends PagedListAdapter<ItemHunter, HeadHunterAdapter.HeadHunterViewHolder> {

    private OnAdapterClickListener onAdapterClickListener;

    public HeadHunterAdapter(OnAdapterClickListener onAdapterClickListener) {
        super(ItemHunter.CALLBACK);
        this.onAdapterClickListener = onAdapterClickListener;
    }

    @NonNull
    @Override
    public HeadHunterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_hunter_item, parent, false);
        return new HeadHunterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadHunterViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class HeadHunterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleVacancy;
        private TextView companyName;
        private TextView description;
        private ImageView addToFavourite;

        public HeadHunterViewHolder(@NonNull View itemView) {
            super(itemView);

            titleVacancy = itemView.findViewById(R.id.title_vacancy);
            companyName = itemView.findViewById(R.id.company_name);
            description = itemView.findViewById(R.id.description);
            addToFavourite = itemView.findViewById(R.id.add_to_favourite);

            itemView.setOnClickListener(this);
        }

        void bind(ItemHunter item) {
            titleVacancy.setText(item.getName());
            companyName.setText(item.getEmployer().getName());
            description.setText(item.getSnippet().getResponsibility());
            addToFavourite.setOnClickListener(view -> onAdapterClickListener.onClickFavourite(item, addToFavourite));
        }

        @Override
        public void onClick(View view) {
            onAdapterClickListener.onClickAdapter(getAdapterPosition());
        }
    }

    public interface OnAdapterClickListener {
        void onClickAdapter(int position);
        void onClickFavourite(ItemHunter itemHunter, ImageView imageView);
    }
}
