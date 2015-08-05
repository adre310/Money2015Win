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
public class Account {

    public static final String COL_GUID = "r_guid";
    public static final String COL_MODIFIED = "modified";
    public static final String COL_DELETED = "deleted";
    public static final String COL_NOTES = "notes";
    public static final String COL_NAME = "name";
    public static final String COL_CURRENCY = "currency";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = COL_GUID,length = 50)
    private String guid;
    @Column(name = COL_MODIFIED)
    private boolean isModified;
    @Column(name = COL_DELETED)
    private boolean isDeleted;
    @Column(name = COL_NOTES,length = 2000)
    private String notes;
    
    @Column(name = COL_NAME,length = 255)
    private String name;
    @Column(name = COL_CURRENCY,length = 10)
    private String currency;

    public long getId() {
        return id;
    }

    public void setId(long mId) {
        this.id = mId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String mGuid) {
        this.guid = mGuid;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean mModified) {
        this.isModified = mModified;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean mDeleted) {
        this.isDeleted = mDeleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String mNotes) {
        this.notes = mNotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        this.name = mName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String mCurrency) {
        this.currency = mCurrency;
    }

    
}
