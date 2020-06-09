
package com.headhunter.client.data.model.company;

import android.text.Html;
import android.text.Spanned;
import android.view.View;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyInfoBody {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("trusted")
    @Expose
    private boolean trusted;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("site_url")
    @Expose
    private String siteUrl;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("logo_urls")
    @Expose
    private DetailCompanyLogoUrls logoUrls;
    @SerializedName("relations")
    @Expose
    private List<Object> relations = null;
    @SerializedName("area")
    @Expose
    private CompanyInfoArea area;
    @SerializedName("branded_description")
    @Expose
    private Object brandedDescription;
    @SerializedName("insider_interviews")
    @Expose
    private List<Object> insiderInterviews = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
    }

    public DetailCompanyLogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(DetailCompanyLogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public CompanyInfoArea getArea() {
        return area;
    }

    public void setArea(CompanyInfoArea area) {
        this.area = area;
    }

    public Object getBrandedDescription() {
        return brandedDescription;
    }

    public void setBrandedDescription(Object brandedDescription) {
        this.brandedDescription = brandedDescription;
    }

    public List<Object> getInsiderInterviews() {
        return insiderInterviews;
    }

    public void setInsiderInterviews(List<Object> insiderInterviews) {
        this.insiderInterviews = insiderInterviews;
    }

    public Spanned getHtmlDescriptionText() {
        return Html.fromHtml(getDescription());
    }

    public int logoVisible() {
        return getLogoUrls() == null ? View.GONE : View.VISIBLE;
    }

}
