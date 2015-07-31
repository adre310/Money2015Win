/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author aisaev
 */
public class DeviceInfo {
    
    @SerializedName("package")
    private String mPackage;
    @SerializedName("version")
    private String mPackageVersion;
    @SerializedName("phone_id")
    private String mPhoneId;
    @SerializedName("phone_model")
    private String mPhoneModel;
    @SerializedName("phone_os")
    private String mPhoneOS;

    public DeviceInfo() {
        mPackage="net.money2013.win.hb";
        mPackageVersion="1.0.0";
        mPhoneId="java_8";
        mPhoneOS="java 1.8_51";
    }

    
    public String getPackage() {
        return mPackage;
    }

    public void setPackage(String mPackage) {
        this.mPackage = mPackage;
    }

    public String getPackageVersion() {
        return mPackageVersion;
    }

    public void setPackageVersion(String mPackageVersion) {
        this.mPackageVersion = mPackageVersion;
    }

    public String getPhoneId() {
        return mPhoneId;
    }

    public void setPhoneId(String mPhoneId) {
        this.mPhoneId = mPhoneId;
    }

    public String getPhoneModel() {
        return mPhoneModel;
    }

    public void setPhoneModel(String mPhoneModel) {
        this.mPhoneModel = mPhoneModel;
    }

    public String getPhoneOS() {
        return mPhoneOS;
    }

    public void setPhoneOS(String mPhoneOS) {
        this.mPhoneOS = mPhoneOS;
    }
        
}
