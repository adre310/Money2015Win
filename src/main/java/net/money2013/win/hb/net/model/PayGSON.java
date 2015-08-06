/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import net.money2013.win.hb.dal.Pay;

/**
 *
 * @author aisaev
 */
public class PayGSON {
    @SerializedName("uuid")
    private String mGuid;
    @SerializedName("is_deleted")
    private boolean mDeleted;
    @SerializedName("notes")
    private String mNotes;
    @SerializedName("pay_value")
    private double mValue;
    @SerializedName("pay_date")
    private Date mCreated;
    @SerializedName("account_uuid")
    private String mAccountGuid;
    @SerializedName("category_uuid")
    private String mCategoryGuid;
    @SerializedName("is_system")
    private boolean mIsSystem;

    public PayGSON(String mGuid, boolean mDeleted, String mNotes, double mValue, Date mCreated, String mAccountGuid, String mCategoryGuid, boolean mIsSystem) {
        this.mGuid = mGuid;
        this.mDeleted = mDeleted;
        this.mNotes = mNotes;
        this.mValue = mValue;
        this.mCreated = mCreated;
        this.mAccountGuid = mAccountGuid;
        this.mCategoryGuid = mCategoryGuid;
        this.mIsSystem = mIsSystem;
    }
    
    public String getGuid() {
        return mGuid;
    }

    public void setGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public boolean isDeleted() {
        return mDeleted;
    }

    public void setDeleted(boolean mDeleted) {
        this.mDeleted = mDeleted;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String mNotes) {
        this.mNotes = mNotes;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double mValue) {
        this.mValue = mValue;
    }

    public Date getCreated() {
        return mCreated;
    }

    public void setCreated(Date mCreated) {
        this.mCreated = mCreated;
    }

    public String getAccountGuid() {
        return mAccountGuid;
    }

    public void setAccountGuid(String mAccountGuid) {
        this.mAccountGuid = mAccountGuid;
    }

    public String getCategoryGuid() {
        return mCategoryGuid;
    }

    public void setCategoryGuid(String mCategoryGuid) {
        this.mCategoryGuid = mCategoryGuid;
    }

    public boolean isSystem() {
        return mIsSystem;
    }

    public void setSystem(boolean mIsSystem) {
        this.mIsSystem = mIsSystem;
    }
        
}
