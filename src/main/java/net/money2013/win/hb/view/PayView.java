/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.view;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import net.money2013.win.hb.dal.PayDAL;

/**
 *
 * @author aisaev
 */
public class PayView {
    private SimpleLongProperty mId;
    private SimpleStringProperty mGuid;
    private SimpleBooleanProperty mModified;
    private SimpleBooleanProperty mDeleted;
    private SimpleStringProperty mNotes;
    private SimpleDoubleProperty mValue;
    private ObjectProperty<LocalDate> mCreated;
    private ObjectProperty<AccountView> mAccount;
    private ObjectProperty<CategoryView> mCategory;
    private SimpleBooleanProperty mIsSystem;

    public PayView(PayDAL pay) {
        mId=new SimpleLongProperty(pay.getId());
        mGuid=new SimpleStringProperty(pay.getGuid());
        mModified=new SimpleBooleanProperty(pay.isModified());
        mDeleted=new SimpleBooleanProperty(pay.isDeleted());
        mNotes=new SimpleStringProperty(pay.getNotes());
        mValue=new SimpleDoubleProperty(pay.getValue());
        mCreated=new SimpleObjectProperty<LocalDate>(LocalDateTime.ofInstant(Instant.ofEpochMilli(pay.getCreated().getTime()), ZoneId.systemDefault()).toLocalDate());
    }
    
    public SimpleLongProperty getId() {
        return mId;
    }

    public void setId(SimpleLongProperty mId) {
        this.mId = mId;
    }

    public SimpleStringProperty getGuid() {
        return mGuid;
    }

    public void setGuid(SimpleStringProperty mGuid) {
        this.mGuid = mGuid;
    }

    public SimpleBooleanProperty getModified() {
        return mModified;
    }

    public void setModified(SimpleBooleanProperty mModified) {
        this.mModified = mModified;
    }

    public SimpleBooleanProperty getDeleted() {
        return mDeleted;
    }

    public void setDeleted(SimpleBooleanProperty mDeleted) {
        this.mDeleted = mDeleted;
    }

    public SimpleStringProperty getNotes() {
        return mNotes;
    }

    public void setNotes(SimpleStringProperty mNotes) {
        this.mNotes = mNotes;
    }

    public SimpleDoubleProperty getValue() {
        return mValue;
    }

    public void setValue(SimpleDoubleProperty mValue) {
        this.mValue = mValue;
    }

    public ObjectProperty<LocalDate> getCreated() {
        return mCreated;
    }

    public void setCreated(ObjectProperty<LocalDate> mCreated) {
        this.mCreated = mCreated;
    }

    public SimpleBooleanProperty getIsSystem() {
        return mIsSystem;
    }

    public void setIsSystem(SimpleBooleanProperty mIsSystem) {
        this.mIsSystem = mIsSystem;
    }

    public ObjectProperty<AccountView> getAccount() {
        return mAccount;
    }

    public void setAccount(ObjectProperty<AccountView> mAccount) {
        this.mAccount = mAccount;
    }

    public ObjectProperty<CategoryView> getCategory() {
        return mCategory;
    }

    public void setCategory(ObjectProperty<CategoryView> mCategory) {
        this.mCategory = mCategory;
    }
        
}
