/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author aisaev
 */
public class SerialDB {

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
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000")
                        //.setPrettyPrinting()
                        .create();
        
        return gson.toJson(sendData).toString();
    }
    
    public static void deserial(String response) {
        Gson gson=new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss+0000")
                        .create();
        
        ResponseGSON data=gson.fromJson(response, ResponseGSON.class);
        
        
    }
}
