/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aisaev
 */
@Entity
@Table(name = "accounts")
public class AccountDAL {

    public static final String COL_GUID = "r_guid";
    public static final String COL_MODIFIED = "modified";
    public static final String COL_DELETED = "deleted";
    public static final String COL_NOTES = "notes";
    public static final String COL_NAME = "name";
    public static final String COL_CURRENCY = "currency";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long mId;
    @Column(name = COL_GUID,length = 50)
    private String mGuid;
    @Column(name = COL_MODIFIED)
    private boolean mModified;
    @Column(name = COL_DELETED)
    private boolean mDeleted;
    @Column(name = COL_NOTES,length = 2000)
    private String mNotes;
    
    @Column(name = COL_NAME,length = 255)
    private String mName;
    @Column(name = COL_CURRENCY,length = 10)
    private String mCurrency;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getGuid() {
        return mGuid;
    }

    public void setGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public boolean isModified() {
        return mModified;
    }

    public void setModified(boolean mModified) {
        this.mModified = mModified;
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
