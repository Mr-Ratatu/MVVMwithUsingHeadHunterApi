
package com.headhunter.client.data.model.detail;

import android.view.View;
import android.widget.ImageView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;

public class DetailModelBody {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("relations")
    @Expose
    private List<Object> relations = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("insider_interview")
    @Expose
    private Object insiderInterview;
    @SerializedName("response_letter_required")
    @Expose
    private boolean responseLetterRequired;
    @SerializedName("area")
    @Expose
    private AreaDetail area;
    @SerializedName("salary")
    @Expose
    private Salary salary;
    @SerializedName("allow_messages")
    @Expose
    private boolean allowMessages;
    @SerializedName("department")
    @Expose
    private Object department;
    @SerializedName("contacts")
    @Expose
    private Object contacts;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("branded_description")
    @Expose
    private Object brandedDescription;
    @SerializedName("vacancy_constructor_template")
    @Expose
    private Object vacancyConstructorTemplate;
    @SerializedName("accept_handicapped")
    @Expose
    private boolean acceptHandicapped;
    @SerializedName("accept_kids")
    @Expose
    private boolean acceptKids;
    @SerializedName("archived")
    @Expose
    private boolean archived;
    @SerializedName("response_url")
    @Expose
    private Object responseUrl;
    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("hidden")
    @Expose
    private boolean hidden;
    @SerializedName("quick_responses_allowed")
    @Expose
    private boolean quickResponsesAllowed;
    @SerializedName("driver_license_types")
    @Expose
    private List<Object> driverLicenseTypes = null;
    @SerializedName("accept_incomplete_resumes")
    @Expose
    private boolean acceptIncompleteResumes;
    @SerializedName("employer")
    @Expose
    private EmployerDetail employer;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("negotiations_url")
    @Expose
    private Object negotiationsUrl;
    @SerializedName("suitable_resumes_url")
    @Expose
    private Object suitableResumesUrl;
    @SerializedName("apply_alternate_url")
    @Expose
    private String applyAlternateUrl;
    @SerializedName("has_test")
    @Expose
    private boolean hasTest;
    @SerializedName("test")
    @Expose
    private Object test;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("experience")
    @Expose
    private Experience experience;
    @SerializedName("key_skills")
    @Expose
    private List<KeySkill> keySkills = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getInsiderInterview() {
        return insiderInterview;
    }

    public void setInsiderInterview(Object insiderInterview) {
        this.insiderInterview = insiderInterview;
    }

    public boolean isResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
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

    public boolean isAllowMessages() {
        return allowMessages;
    }

    public void setAllowMessages(boolean allowMessages) {
        this.allowMessages = allowMessages;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
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

    public Object getBrandedDescription() {
        return brandedDescription;
    }

    public void setBrandedDescription(Object brandedDescription) {
        this.brandedDescription = brandedDescription;
    }

    public Object getVacancyConstructorTemplate() {
        return vacancyConstructorTemplate;
    }

    public void setVacancyConstructorTemplate(Object vacancyConstructorTemplate) {
        this.vacancyConstructorTemplate = vacancyConstructorTemplate;
    }

    public boolean isAcceptHandicapped() {
        return acceptHandicapped;
    }

    public void setAcceptHandicapped(boolean acceptHandicapped) {
        this.acceptHandicapped = acceptHandicapped;
    }

    public boolean isAcceptKids() {
        return acceptKids;
    }

    public void setAcceptKids(boolean acceptKids) {
        this.acceptKids = acceptKids;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Object getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(Object responseUrl) {
        this.responseUrl = responseUrl;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isQuickResponsesAllowed() {
        return quickResponsesAllowed;
    }

    public void setQuickResponsesAllowed(boolean quickResponsesAllowed) {
        this.quickResponsesAllowed = quickResponsesAllowed;
    }

    public List<Object> getDriverLicenseTypes() {
        return driverLicenseTypes;
    }

    public void setDriverLicenseTypes(List<Object> driverLicenseTypes) {
        this.driverLicenseTypes = driverLicenseTypes;
    }

    public boolean isAcceptIncompleteResumes() {
        return acceptIncompleteResumes;
    }

    public void setAcceptIncompleteResumes(boolean acceptIncompleteResumes) {
        this.acceptIncompleteResumes = acceptIncompleteResumes;
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

    public Object getNegotiationsUrl() {
        return negotiationsUrl;
    }

    public void setNegotiationsUrl(Object negotiationsUrl) {
        this.negotiationsUrl = negotiationsUrl;
    }

    public Object getSuitableResumesUrl() {
        return suitableResumesUrl;
    }

    public void setSuitableResumesUrl(Object suitableResumesUrl) {
        this.suitableResumesUrl = suitableResumesUrl;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public boolean isHasTest() {
        return hasTest;
    }

    public void setHasTest(boolean hasTest) {
        this.hasTest = hasTest;
    }

    public Object getTest() {
        return test;
    }

    public void setTest(Object test) {
        this.test = test;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
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

    @BindingAdapter("companyLogo")
    public static void logoCompany(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public int visibleTextSalary() {
        if (salary == null) {
            return View.GONE;
        } else {
            return View.VISIBLE;
        }
    }

    public int keySkillsVisible() {
        if (keySkills.isEmpty()) {
            return View.GONE;
        } else {
            return View.VISIBLE;
        }
    }

    public int cardViewVisible() {
        if (employer.getLogoUrls() == null) {
            return View.GONE;
        } else {
            return View.VISIBLE;
        }
    }

}
