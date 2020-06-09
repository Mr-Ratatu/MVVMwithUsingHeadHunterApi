
package com.headhunter.client.data.model.detail;

import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.cardview.widget.CardView;
import androidx.core.text.HtmlCompat;
import androidx.databinding.BindingAdapter;

public class DetailModelBody {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("area")
    @Expose
    private AreaDetail area;
    @SerializedName("salary")
    @Expose
    private Salary salary;

    @SerializedName("contacts")
    @Expose
    private Object contacts;
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("employer")
    @Expose
    private EmployerDetail employer;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("experience")
    @Expose
    private Experience experience;
    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    @SerializedName("employment")
    @Expose
    private Employment employment;
    @SerializedName("key_skills")
    @Expose
    private List<KeySkill> keySkills = null;

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

    public AreaDetail getArea() {
        return area;
    }

    public void setArea(AreaDetail area) {
        this.area = area;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployerDetail getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerDetail employer) {
        this.employer = employer;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public List<KeySkill> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(List<KeySkill> keySkills) {
        this.keySkills = keySkills;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Employment getEmployment() {
        return employment;
    }

    public String getScheduleInfo() {
        return getSchedule().getName() + ", " + getEmployment().getName();
    }

    public Spanned getHtmlDescriptionText() {
        return Html.fromHtml(getDescription());
    }

    @BindingAdapter("companyLogo")
    public static void logoCompany(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public int visibleTextSalary() {
        return salary == null ? View.GONE : View.VISIBLE;
    }

    public int keySkillsVisible() {
        return keySkills.isEmpty() ? View.GONE : View.VISIBLE;
    }

    public int cardViewVisible() {
        return employer.getLogoUrls() == null ? View.GONE : View.VISIBLE;
    }

}
