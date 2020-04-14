
package com.headhunter.client.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ItemHunter {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("salary")
    @Expose
    private Salary salary;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public static final DiffUtil.ItemCallback<ItemHunter> CALLBACK = new DiffUtil.ItemCallback<ItemHunter>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return false;
        }

    };
}
