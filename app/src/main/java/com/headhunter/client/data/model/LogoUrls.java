package com.headhunter.client.data.model;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.databinding.BindingAdapter;

public class LogoUrls {

    @SerializedName("original")
    @Expose
    private String original;
    @SerializedName("240")
    @Expose
    private String _240;
    @SerializedName("90")
    @Expose
    private String _90;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

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

    @BindingAdapter("logoCompany")
    public static void logoCompany(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

}
