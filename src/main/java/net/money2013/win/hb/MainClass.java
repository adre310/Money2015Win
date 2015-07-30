/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import net.money2013.win.hb.model.Account;
import net.money2013.win.hb.model.Pay;
import net.money2013.win.hb.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author aisaev
 */
public class MainClass {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        try {
            for(int iA=0;iA<5;iA++) {
                Account account=new Account();
                account.setGuid(UUID.randomUUID().toString());
                account.setModified(true);
                account.setDeleted(false);
                account.setNotes("notes");
                account.setName("a"+Integer.toString(iA));
                session.save(account);
                for(int iP=0;iP<5;iP++) {
                    Pay pay=new Pay();
                    pay.setGuid(UUID.randomUUID().toString());
                    pay.setModified(true);
                    pay.setDeleted(false);
                    pay.setValue(iP);
                    pay.setCreated(new Date());
                    pay.setAccount(account);
                    session.save(pay);
                }
            }
            session.getTransaction().commit();
        } catch(Exception e) {            
            session.getTransaction().rollback();
            System.out.println("Exception:"+e.getLocalizedMessage());
        }
    }
}
