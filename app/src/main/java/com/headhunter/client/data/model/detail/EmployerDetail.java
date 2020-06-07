
package com.headhunter.client.data.model.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EmployerDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("logo_urls")
    @Expose
    private LogoUrls logoUrls;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("trusted")
    @Expose
    private boolean trusted;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

}
