/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.dal;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aisaev
 */
@Entity
@Table(name = "pays")
public class PayDAL {
    public static final String COL_GUID = "r_guid";
    public static final String COL_MODIFIED = "modified";
    public static final String COL_DELETED = "deleted";
    public static final String COL_NOTES = "notes";
    public static final String COL_VALUE = "pay_value";
    public static final String COL_CREATED = "pay_date";
    public static final String COL_CREATEDYEAR = "pay_year";
    public static final String COL_CREATEDMONTH = "pay_month";
    public static final String COL_CREATEDDAY = "pay_day";
    public static final String COL_ACCOUNT = "account_id";
    public static final String COL_CATEGORY = "category_id";
    public static final String COL_ISSYSTEM = "is_system";

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
    @Column(name = COL_VALUE)
    private double mValue;
    @Column(name = COL_CREATED)
    private Date mCreated;
    @Column(name = COL_CREATEDYEAR)
    private int mCreatedYear;
    @Column(name = COL_CREATEDMONTH)
    private int mCreatedMonth;
    @Column(name = COL_CREATEDDAY)
    private int mCreatedDay;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_ACCOUNT)
    private AccountDAL mAccount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_CATEGORY)    
    private CategoryDAL mCategory;
    @Column(name = COL_ISSYSTEM)
    private boolean mIsSystem;

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

    public int getCreatedYear() {
        return mCreatedYear;
    }

    public void setCreatedYear(int mCreatedYear) {
        this.mCreatedYear = mCreatedYear;
    }

    public int getCreatedMonth() {
        return mCreatedMonth;
    }

    public void setCreatedMonth(int mCreatedMonth) {
        this.mCreatedMonth = mCreatedMonth;
    }

    public int getCreatedDay() {
        return mCreatedDay;
    }

    public void setCreatedDay(int mCreatedDay) {
        this.mCreatedDay = mCreatedDay;
    }

    public AccountDAL getAccount() {
        return mAccount;
    }

    public void setAccount(AccountDAL mAccount) {
        this.mAccount = mAccount;
    }

    public CategoryDAL getCategory() {
        return mCategory;
    }

    public void setCategory(CategoryDAL mCategory) {
        this.mCategory = mCategory;
    }

    public boolean isIsSystem() {
        return mIsSystem;
    }

    public void setIsSystem(boolean mIsSystem) {
        this.mIsSystem = mIsSystem;
    }
    
}
