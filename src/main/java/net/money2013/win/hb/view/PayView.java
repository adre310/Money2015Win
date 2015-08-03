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
import net.money2013.win.hb.util.CurrencyUtil;

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
    private SimpleStringProperty mValue;
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
        mValue=new SimpleStringProperty(CurrencyUtil.currencyToString(pay.getValue(),pay.getAccount()==null?"":pay.getAccount().getCurrency()));
        mCreated=new SimpleObjectProperty<LocalDate>(LocalDateTime.ofInstant(Instant.ofEpochMilli(pay.getCreated().getTime()), ZoneId.systemDefault()).toLocalDate());
    }
    
    public SimpleLongProperty getId() {
        return mId;
    }

    public SimpleStringProperty getGuid() {
        return mGuid;
    }

    public SimpleBooleanProperty getModified() {
        return mModified;
    }

    public SimpleBooleanProperty getDeleted() {
        return mDeleted;
    }

    public SimpleStringProperty getNotes() {
        return mNotes;
    }

    public SimpleStringProperty getValue() {
        return mValue;
    }

    public ObjectProperty<LocalDate> getCreated() {
        return mCreated;
    }

    public SimpleBooleanProperty getIsSystem() {
        return mIsSystem;
    }

    public ObjectProperty<AccountView> getAccount() {
        return mAccount;
    }

    public ObjectProperty<CategoryView> getCategory() {
        return mCategory;
    }
}
