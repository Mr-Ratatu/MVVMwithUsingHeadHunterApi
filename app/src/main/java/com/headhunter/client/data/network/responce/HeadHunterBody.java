
package com.headhunter.client.data.network.responce;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.headhunter.client.data.model.ItemHunter;

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
