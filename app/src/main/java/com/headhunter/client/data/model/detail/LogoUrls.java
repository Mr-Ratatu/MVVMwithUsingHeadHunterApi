
package com.headhunter.client.data.model.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoUrls {

    @SerializedName("240")
    @Expose
    private String _240;
    @SerializedName("90")
    @Expose
    private String _90;
    @SerializedName("original")
    @Expose
    private String original;

    public String get240() {
        return _240;
    }

    public void set240(String _240) {
        this._240 = _240;
    }

    public String get90() {
        return _90;
    }

    public void set90(String _90) {
        this._90 = _90;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

}
