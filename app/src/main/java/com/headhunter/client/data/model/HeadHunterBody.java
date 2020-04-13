
package com.headhunter.client.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeadHunterBody {

    @SerializedName("items")
    @Expose
    private List<ItemHunter> items = null;

    public List<ItemHunter> getItems() {
        return items;
    }

    public void setItems(List<ItemHunter> items) {
        this.items = items;
    }



}
