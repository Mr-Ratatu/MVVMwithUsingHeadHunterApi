
package com.headhunter.client.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Embedded;

public class Employer {

    @SerializedName("id")
    @Expose
    private String ids;
    @SerializedName("name")
    @Expose
    private String _name;
    @SerializedName("logo_urls")
    @Embedded
    @Expose
    private LogoUrls logoUrls;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }
}
