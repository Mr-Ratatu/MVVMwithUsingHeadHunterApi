package com.headhunter.client.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.data.model.detail.KeySkill;
import com.headhunter.client.databinding.KeySkillsItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class KeySkillsAdapter extends RecyclerView.Adapter<KeySkillsAdapter.KeySkillsViewHolder> {

    private List<KeySkill> list;

    public KeySkillsAdapter(List<KeySkill> list) {
        this.list = list;
    }

    public void setList(List<KeySkill> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KeySkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        KeySkillsItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.key_skills_item, parent, false);
        return new KeySkillsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KeySkillsViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class KeySkillsViewHolder extends RecyclerView.ViewHolder {

        private KeySkillsItemBinding binding;

        public KeySkillsViewHolder(@NonNull KeySkillsItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        private void bind(KeySkill keySkill) {
            binding.setKeySkills(keySkill);
            binding.executePendingBindings();
        }
    }

}
