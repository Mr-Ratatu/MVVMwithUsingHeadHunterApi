
package com.headhunter.client.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_db")
public class ItemHunter implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long _id;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("employer")
    @Embedded
    @Expose
    private Employer employer;
    @SerializedName("snippet")
    @Embedded
    @Expose
    private Snippet snippet;
    @SerializedName("area")
    @Embedded
    @Expose
    private Area area;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getResponsibility() {
        if (getSnippet().getResponsibility() == null) {
            return "";
        }

        return getSnippet().getResponsibility();
    }

    public static final DiffUtil.ItemCallback<ItemHunter> CALLBACK = new DiffUtil.ItemCallback<ItemHunter>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull ItemHunter oldItem, @NonNull ItemHunter newItem) {
            return false;
        }

    };

}
