package com.headhunter.client.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.headhunter.client.R;
import com.headhunter.client.binding.MainItemViewModel;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.databinding.HeadHunterItemBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class HeadHunterAdapter extends PagedListAdapter<ItemHunter, HeadHunterAdapter.HeadHunterViewHolder> {

    public HeadHunterAdapter() {
        super(ItemHunter.CALLBACK);
    }

    @NonNull
    @Override
    public HeadHunterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        HeadHunterItemBinding binding = DataBindingUtil.inflate(inflate, R.layout.head_hunter_item, parent, false);
        return new HeadHunterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadHunterViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class HeadHunterViewHolder extends RecyclerView.ViewHolder {

        private HeadHunterItemBinding binding;

        public HeadHunterViewHolder(HeadHunterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ItemHunter item) {
            binding.setMainViewModel(new MainItemViewModel(itemView.getContext(), item));
        }
    }
}
