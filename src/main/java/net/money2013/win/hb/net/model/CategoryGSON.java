/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.model;

import com.google.gson.annotations.SerializedName;
import net.money2013.win.hb.dal.CategoryDAL;

/**
 *
 * @author aisaev
 */
public class CategoryGSON {
    @SerializedName("uuid")
    private String mGuid;
    @SerializedName("is_deleted")
    private boolean mDeleted;
    @SerializedName("notes")
    private String mNotes;
    @SerializedName("name")
    private String mName;
    @SerializedName("is_default")
    private boolean mIsDefault;
    @SerializedName("style")
    private int mTheme;

    public CategoryGSON(CategoryDAL category) {
        this.mGuid=category.getGuid();
        this.mDeleted=category.isDeleted();
        this.mNotes=category.getNotes();
        this.mName=category.getName();
        this.mIsDefault=category.isIsDefault();
        this.mTheme=category.getTheme();
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

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public boolean isIsDefault() {
        return mIsDefault;
    }

    public void setIsDefault(boolean mIsDefault) {
        this.mIsDefault = mIsDefault;
    }

    public int getTheme() {
        return mTheme;
    }

    public void setTheme(int mTheme) {
        this.mTheme = mTheme;
    }
    
    
}
