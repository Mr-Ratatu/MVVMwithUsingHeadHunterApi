package com.headhunter.client.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.viewmodel.item.FavouriteItemViewModel;
import com.headhunter.client.data.model.ItemHunter;
import com.headhunter.client.databinding.FavouriteItemBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class FavouriteAdapter extends ListAdapter<ItemHunter, FavouriteAdapter.FavouriteViewHolder> {

    public FavouriteAdapter() {
        super(DIFF_CALLBACK);
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
        FavouriteItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.favourite_item, parent, false);
        return new FavouriteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class FavouriteViewHolder extends RecyclerView.ViewHolder {

        private FavouriteItemBinding favouriteItemBinding;

        public FavouriteViewHolder(FavouriteItemBinding favouriteItemBinding) {
            super(favouriteItemBinding.getRoot());
            this.favouriteItemBinding = favouriteItemBinding;
        }

        void bind(@NonNull ItemHunter itemHunter) {
            if (favouriteItemBinding.getViewModel() == null) {
                favouriteItemBinding.setViewModel(
                        new FavouriteItemViewModel(itemHunter, itemView.getContext()));
            } else {
                favouriteItemBinding.getViewModel().setItemHunter(itemHunter);
            }
        }
    }

}
