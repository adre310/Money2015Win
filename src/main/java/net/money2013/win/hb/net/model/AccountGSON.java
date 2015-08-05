/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.model;

import com.google.gson.annotations.SerializedName;
import net.money2013.win.hb.dal.Account;

/**
 *
 * @author aisaev
 */
public class AccountGSON {
    @SerializedName("uuid")
    private String mGuid;
    @SerializedName("is_deleted")
    private boolean mDeleted;
    @SerializedName("notes")
    private String mNotes;
    @SerializedName("name")    
    private String mName;
    @SerializedName("currency")
    private String mCurrency;

    public AccountGSON(Account account) {
        this.mGuid=account.getGuid();
        this.mDeleted=account.isDeleted();
        this.mNotes=account.getNotes();
        this.mName=account.getName();
        this.mCurrency=account.getCurrency();
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

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String mCurrency) {
        this.mCurrency = mCurrency;
    }
    
    
}
