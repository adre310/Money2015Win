/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aisaev
 */
public class SendData {
    @SerializedName("info")
    private DeviceInfo mInfo;
    @SerializedName("date")
    private Date mDate;
    @SerializedName("accounts")
    private List<AccountGSON> mAccounts;
    @SerializedName("categories")
    private List<CategoryGSON> mCategories;
    @SerializedName("pays")
    private List<PayGSON> mPays;

    public SendData() {
        mInfo=new DeviceInfo();
        mAccounts=new ArrayList<AccountGSON>();
        mCategories=new ArrayList<CategoryGSON>();
        mPays=new ArrayList<PayGSON>();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public List<AccountGSON> getAccounts() {
        return mAccounts;
    }

    public void setAccounts(List<AccountGSON> mAccounts) {
        this.mAccounts = mAccounts;
    }

    public List<CategoryGSON> getCategories() {
        return mCategories;
    }

    public void setCategories(List<CategoryGSON> mCategories) {
        this.mCategories = mCategories;
    }

    public List<PayGSON> getPays() {
        return mPays;
    }

    public void setPays(List<PayGSON> mPays) {
        this.mPays = mPays;
    }
            
}
