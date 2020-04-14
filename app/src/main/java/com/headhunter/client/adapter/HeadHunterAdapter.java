package com.headhunter.client.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.data.model.ItemHunter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HeadHunterAdapter extends PagedListAdapter<ItemHunter, HeadHunterAdapter.HeadHunterViewHolder> {


    public HeadHunterAdapter() {
        super(ItemHunter.CALLBACK);
    }

    @NonNull
    @Override
    public HeadHunterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_hunter_item, parent, false);
        return new HeadHunterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadHunterViewHolder holder, int position) {
        ItemHunter item = getItem(position);

        holder.bind(item);
    }

    class HeadHunterViewHolder extends RecyclerView.ViewHolder {

        private TextView titleVacancy;
        private TextView companyName;
        private TextView description;

        public HeadHunterViewHolder(@NonNull View itemView) {
            super(itemView);

            titleVacancy = itemView.findViewById(R.id.title_vacancy);
            companyName = itemView.findViewById(R.id.company_name);
            description = itemView.findViewById(R.id.description);
        }

        public void bind(ItemHunter item) {
            titleVacancy.setText(item.getName());
            companyName.setText(item.getEmployer().getName());
            description.setText(item.getSnippet().getResponsibility());
        }
    }
}
