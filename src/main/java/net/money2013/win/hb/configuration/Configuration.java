/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import net.money2013.win.hb.dal.Settings;
import net.money2013.win.hb.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author aisaev
 */
public class Configuration {
    private static final String LAST_SYNC_DATE="last.sync.date";
    
    private static HashMap<String,Object> mItems=null;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.US);
    
    private static void load() {
        if(mItems==null) {
            Session session=HibernateUtil.getSessionFactory().openSession();
            List listItems=session.createQuery("from Settings").list();
            mItems=new HashMap<String,Object>();
            
            for(Object o : listItems) {
                Settings s=(Settings)o;
                if(s.getName().equals(LAST_SYNC_DATE)) {
                    try {
                        Date syncDate=dateFormat.parse(s.getValue());
                        mItems.put(LAST_SYNC_DATE, syncDate);
                    } catch(Exception e) {
                        
                    }
                }
            }
        }
    }
    
    public static Date getLastSync() {
        load();
        if(mItems.containsKey(LAST_SYNC_DATE)) {
            return (Date)(mItems.get(LAST_SYNC_DATE));
        } else {
            return new Date(100,1,1);
        }
    }
    
    public static void setLastSync(Date date) {
        load();
        if(mItems.containsKey(LAST_SYNC_DATE)) {
            mItems.remove(LAST_SYNC_DATE);
        }
        mItems.put(LAST_SYNC_DATE, date);
    }

    public static void save(Session session) {
        if(mItems!=null) {
            for(String key : mItems.keySet()) {
                if(key.equals(LAST_SYNC_DATE)) {
                    saveItem(session,new Settings(LAST_SYNC_DATE, dateFormat.format((Date)(mItems.get(LAST_SYNC_DATE)))));
                }
            }
        }
    }
    
    public static void save() {
        if(mItems!=null) {
            Session session=HibernateUtil.getSessionFactory().openSession();
            save(session);
            session.getTransaction().commit();
        }
    }
    
    private static void saveItem(Session session,Settings settings) {
        List list=session.createQuery("from Settings s WHERE s.name = :name")
                            .setParameter("name", settings.getName())
                            .list();
        if(list!=null && !list.isEmpty()) {
            Settings oldSettings=(Settings)list.get(0);
            oldSettings.setValue(settings.getValue());
            session.save(oldSettings);
        } else {
            session.save(settings);
        }
    }
}
