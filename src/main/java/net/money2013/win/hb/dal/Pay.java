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
public class Pay {
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
    private long id;
    @Column(name = COL_GUID,length = 50)
    private String guid;
    @Column(name = COL_MODIFIED)
    private boolean isModified;
    @Column(name = COL_DELETED)
    private boolean isDeleted;
    @Column(name = COL_NOTES,length = 2000)
    private String isNotes;
    @Column(name = COL_VALUE)
    private double payValue;
    @Column(name = COL_CREATED)
    private Date created;
    @Column(name = COL_CREATEDYEAR)
    private int createdYear;
    @Column(name = COL_CREATEDMONTH)
    private int createdMonth;
    @Column(name = COL_CREATEDDAY)
    private int createdDay;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_ACCOUNT)
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_CATEGORY)    
    private Category category;
    @Column(name = COL_ISSYSTEM)
    private boolean isSystem;

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
        return isNotes;
    }

    public void setNotes(String mNotes) {
        this.isNotes = mNotes;
    }

    public double getValue() {
        return payValue;
    }

    public void setValue(double mValue) {
        this.payValue = mValue;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date mCreated) {
        this.created = mCreated;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(int mCreatedYear) {
        this.createdYear = mCreatedYear;
    }

    public int getCreatedMonth() {
        return createdMonth;
    }

    public void setCreatedMonth(int mCreatedMonth) {
        this.createdMonth = mCreatedMonth;
    }

    public int getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(int mCreatedDay) {
        this.createdDay = mCreatedDay;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account mAccount) {
        this.account = mAccount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category mCategory) {
        this.category = mCategory;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean mIsSystem) {
        this.isSystem = mIsSystem;
    }
    
}
