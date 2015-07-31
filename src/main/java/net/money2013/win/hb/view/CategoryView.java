/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aisaev
 */
public class CategoryView {
    private SimpleLongProperty mId;
    private SimpleStringProperty mGuid;
    private SimpleBooleanProperty mModified;
    private SimpleBooleanProperty mDeleted;
    private SimpleStringProperty mNotes;
    private SimpleStringProperty mName;
    private SimpleBooleanProperty mIsDefault;
    private SimpleIntegerProperty mTheme;

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

    public SimpleStringProperty getName() {
        return mName;
    }

    public void setName(SimpleStringProperty mName) {
        this.mName = mName;
    }

    public SimpleBooleanProperty getIsDefault() {
        return mIsDefault;
    }

    public void setIsDefault(SimpleBooleanProperty mIsDefault) {
        this.mIsDefault = mIsDefault;
    }

    public SimpleIntegerProperty getTheme() {
        return mTheme;
    }

    public void setTheme(SimpleIntegerProperty mTheme) {
        this.mTheme = mTheme;
    }
    
    
}
