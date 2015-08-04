/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import net.money2013.win.hb.dal.AccountDAL;
import net.money2013.win.hb.dal.CategoryDAL;
import net.money2013.win.hb.dal.PayDAL;
import net.money2013.win.hb.net.model.AccountGSON;
import net.money2013.win.hb.net.model.CategoryGSON;
import net.money2013.win.hb.net.model.PayGSON;
import net.money2013.win.hb.net.model.ResponseGSON;
import net.money2013.win.hb.net.model.SendData;
import net.money2013.win.hb.util.HibernateUtil;
import org.hibernate.Session;
import java.lang.reflect.Type;
import java.text.ParseException;

/**
 *
 * @author aisaev
 */
public class SerialDB {

  private static class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final DateFormat dateFormat;

    private DateTypeAdapter() {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000", Locale.US);
      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override public synchronized JsonElement serialize(Date date, Type type,
        JsonSerializationContext jsonSerializationContext) {
      return new JsonPrimitive(dateFormat.format(date));
    }

    @Override public synchronized Date deserialize(JsonElement jsonElement, Type type,
        JsonDeserializationContext jsonDeserializationContext) {
      try {
        return dateFormat.parse(jsonElement.getAsString());
      } catch (ParseException e) {
        throw new JsonParseException(e);
      }
    }
  }
    
    public static String serial() {
        SendData sendData=new SendData();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        sendData.setDate(new Date(100,1,1));
        List accounts=session.createQuery("from AccountDAL a WHERE a.isModified = 1").list();
        
        for(Object a : accounts) {
            sendData.getAccounts().add(new AccountGSON((AccountDAL)a));
        }

        List categories=session.createQuery("from CategoryDAL c WHERE c.isModified = 1").list();
        
        for(Object c : categories) {
            sendData.getCategories().add(new CategoryGSON((CategoryDAL)c));
        }

        List pays=session.createQuery("from PayDAL p WHERE p.isModified = 1").list();
        
        for(Object p : pays) {
            sendData.getPays().add(new PayGSON((PayDAL)p));
        }
        
        Gson gson=new GsonBuilder()
                        .registerTypeAdapter(Date.class, new DateTypeAdapter())
                        //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000")
                        //.setPrettyPrinting()
                        .create();
        
        return gson.toJson(sendData).toString();
    }
    
    public static void deserial(String response) {
        Gson gson=new GsonBuilder()
                        //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000")
                        .registerTypeAdapter(Date.class, new DateTypeAdapter())
                        .create();
        
        ResponseGSON data=gson.fromJson(response, ResponseGSON.class);
        
        HashMap<String,AccountDAL> mapAccounts=new HashMap<String,AccountDAL>();
        HashMap<String,CategoryDAL> mapCategories=new HashMap<String,CategoryDAL>();

        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List accounts=session.createQuery("from AccountDAL a").list();
        for(Object o : accounts) {
            AccountDAL a=(AccountDAL)o;
            if(!mapAccounts.containsKey(a.getGuid()))
                mapAccounts.put(a.getGuid(), a);
        }

        List categories=session.createQuery("from CategoryDAL c").list();        
        for(Object o : categories) {
            CategoryDAL c=(CategoryDAL)o;
            if(!mapCategories.containsKey(c.getGuid()))
                mapCategories.put(c.getGuid(), c);
        }

        for(AccountGSON a : data.getData().getAccounts()) {
            if(mapAccounts.containsKey(a.getGuid())) {
                AccountDAL aDal=mapAccounts.get(a.getGuid());
                aDal.setModified(false);
                aDal.setDeleted(a.isDeleted());
                aDal.setNotes(a.getNotes());
                aDal.setName(a.getName());
                aDal.setCurrency(a.getCurrency());
                session.save(aDal);
            } else {
                AccountDAL aDal=new AccountDAL();
                aDal.setGuid(a.getGuid());
                aDal.setModified(false);
                aDal.setDeleted(a.isDeleted());
                aDal.setNotes(a.getNotes());
                aDal.setName(a.getName());
                aDal.setCurrency(a.getCurrency());
                session.save(aDal);
                mapAccounts.put(a.getGuid(), aDal);
            }
        }
        
        session.getTransaction().commit();
        session.beginTransaction();
        
        for(CategoryGSON c : data.getData().getCategories()) {
            if(mapCategories.containsKey(c.getGuid())) {
                CategoryDAL cDal=mapCategories.get(c.getGuid());
                cDal.setModified(false);
                cDal.setDeleted(c.isDeleted());
                cDal.setNotes(c.getNotes());
                cDal.setName(c.getName());
                cDal.setIsDefault(c.isIsDefault());
                cDal.setTheme(c.getTheme());
                session.save(cDal);               
            } else {
                CategoryDAL cDal=new CategoryDAL();
                cDal.setGuid(c.getGuid());
                cDal.setModified(false);
                cDal.setDeleted(c.isDeleted());
                cDal.setNotes(c.getNotes());
                cDal.setName(c.getName());
                cDal.setIsDefault(c.isIsDefault());
                cDal.setTheme(c.getTheme());
                session.save(cDal);               
                mapCategories.put(c.getGuid(), cDal);
            }
        }

        session.getTransaction().commit();
        session.beginTransaction();
        
        for(PayGSON p : data.getData().getPays()) {
            List findList=session.createQuery("from PayDAL p WHERE p.guid = :guid")
                            .setParameter("guid", p.getGuid())
                            .list();
            if(findList==null || findList.isEmpty()) {
                PayDAL pDal=new PayDAL();
                pDal.setGuid(p.getGuid());
                pDal.setModified(false);
                pDal.setDeleted(p.isDeleted());
                pDal.setNotes(p.getNotes());
                pDal.setValue(p.getValue());
                pDal.setCreated(p.getCreated());
                if(mapAccounts.containsKey(p.getAccountGuid())) {
                    pDal.setAccount(mapAccounts.get(p.getAccountGuid()));
                } else {
                    pDal.setAccount(null);
                }
                if(mapCategories.containsKey(p.getCategoryGuid())) {
                    pDal.setCategory(mapCategories.get(p.getCategoryGuid()));
                } else {
                    pDal.setCategory(null);
                }
                pDal.setSystem(p.isSystem());
                session.save(pDal);
            } else {
                PayDAL pDal=(PayDAL)findList.get(0);
                pDal.setModified(false);
                pDal.setDeleted(p.isDeleted());
                pDal.setNotes(p.getNotes());
                pDal.setValue(p.getValue());
                pDal.setCreated(p.getCreated());
                if(mapAccounts.containsKey(p.getAccountGuid())) {
                    pDal.setAccount(mapAccounts.get(p.getAccountGuid()));
                } else {
                    pDal.setAccount(null);
                }
                if(mapCategories.containsKey(p.getCategoryGuid())) {
                    pDal.setCategory(mapCategories.get(p.getCategoryGuid()));
                } else {
                    pDal.setCategory(null);
                }
                pDal.setSystem(p.isSystem());
                session.save(pDal);
            }
        }
        
       session.getTransaction().commit();
    }
}
