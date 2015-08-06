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
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import net.money2013.win.hb.dal.Pay;
import net.money2013.win.hb.util.CurrencyUtil;

/**
 *
 * @author aisaev
 */
public class PayView {
    private SimpleLongProperty mId;
    private SimpleStringProperty mNotes;
    private SimpleStringProperty mValue;
    private ObjectProperty<LocalDate> mCreated;
    private SimpleStringProperty mAccount;
    private SimpleStringProperty mCategory;
    private SimpleBooleanProperty mIsSystem;

    public PayView(long mId, String mNotes, double mValue, Date mCreated, String mAccount, String currency, String mCategory, boolean mIsSystem) {
        this.mId = new SimpleLongProperty( mId);
        this.mNotes = new SimpleStringProperty(mNotes);
        this.mValue=new SimpleStringProperty(CurrencyUtil.currencyToString(mValue,currency==null?"":currency));
        this.mCreated=new SimpleObjectProperty<>(LocalDateTime.ofInstant(Instant.ofEpochMilli(mCreated.getTime()), ZoneId.systemDefault()).toLocalDate());
        this.mAccount = new SimpleStringProperty(mAccount);
        this.mCategory = new SimpleStringProperty(mCategory);
        this.mIsSystem = new SimpleBooleanProperty(mIsSystem);
    }

    
    
    public PayView(Pay pay) {
        this.mId=new SimpleLongProperty(pay.getId());
        this.mNotes=new SimpleStringProperty(pay.getNotes());
        this.mValue=new SimpleStringProperty(CurrencyUtil.currencyToString(pay.getValue(),pay.getAccount()==null?"":pay.getAccount().getCurrency()));
        this.mCreated=new SimpleObjectProperty<LocalDate>(LocalDateTime.ofInstant(Instant.ofEpochMilli(pay.getCreated().getTime()), ZoneId.systemDefault()).toLocalDate());
    }
    
    public SimpleLongProperty getId() {
        return mId;
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

    public SimpleStringProperty getAccount() {
        return mAccount;
    }

    public SimpleStringProperty getCategory() {
        return mCategory;
    }
}
