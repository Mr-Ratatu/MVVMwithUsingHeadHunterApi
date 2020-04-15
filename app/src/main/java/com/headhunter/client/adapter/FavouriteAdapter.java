package com.headhunter.client.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {

    private List<ItemHunter> list;

    public FavouriteAdapter(List<ItemHunter> list) {
        this.list = list;
    }

    public void setList(List<ItemHunter> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, parent, false);
        return new FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        ItemHunter itemHunter = list.get(position);

        holder.bind(itemHunter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FavouriteViewHolder extends RecyclerView.ViewHolder {

        private TextView titleVacancy;
        private TextView companyName;
        private TextView description;

        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);

            titleVacancy = itemView.findViewById(R.id.title_vacancy_favourite);
            companyName = itemView.findViewById(R.id.company_name_favourite);
            description = itemView.findViewById(R.id.description_favourite);
        }

        public void bind(ItemHunter itemHunter) {
            titleVacancy.setText(itemHunter.getName());
            companyName.setText(itemHunter.getEmployer().getName());
            description.setText(itemHunter.getSnippet().getResponsibility());
        }
    }
}
