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
@Table(name = "categories")
public class CategoryDAL {
    public static final String COL_GUID = "r_guid";
    public static final String COL_MODIFIED = "modified";
    public static final String COL_DELETED = "deleted";
    public static final String COL_NOTES = "notes";
    public static final String COL_NAME = "name";
    public static final String COL_ISDEFAULT = "is_default";
    public static final String COL_THEME = "theme_id";

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
    @Column(name = COL_ISDEFAULT)
    private boolean mIsDefault;
    @Column(name = COL_THEME)
    private int mTheme;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmGuid() {
        return mGuid;
    }

    public void setmGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public boolean ismModified() {
        return mModified;
    }

    public void setmModified(boolean mModified) {
        this.mModified = mModified;
    }

    public boolean ismDeleted() {
        return mDeleted;
    }

    public void setmDeleted(boolean mDeleted) {
        this.mDeleted = mDeleted;
    }

    public String getmNotes() {
        return mNotes;
    }

    public void setmNotes(String mNotes) {
        this.mNotes = mNotes;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean ismIsDefault() {
        return mIsDefault;
    }

    public void setmIsDefault(boolean mIsDefault) {
        this.mIsDefault = mIsDefault;
    }

    public int getmTheme() {
        return mTheme;
    }

    public void setmTheme(int mTheme) {
        this.mTheme = mTheme;
    }
    
    
}
