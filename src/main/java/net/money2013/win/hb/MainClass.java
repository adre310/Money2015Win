/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.money2013.win.hb.controller.PayListController;
import net.money2013.win.hb.dal.AccountDAL;
import net.money2013.win.hb.dal.PayDAL;
import net.money2013.win.hb.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author aisaev
 */
public class MainClass extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        try {
            for(int iA=0;iA<5;iA++) {
                AccountDAL account=new AccountDAL();
                account.setGuid(UUID.randomUUID().toString());
                account.setModified(true);
                account.setDeleted(false);
                account.setNotes("notes");
                account.setName("a"+Integer.toString(iA));
                session.save(account);
                for(int iP=0;iP<5;iP++) {
                    PayDAL pay=new PayDAL();
                    pay.setGuid(UUID.randomUUID().toString());
                    pay.setModified(true);
                    pay.setDeleted(false);
                    pay.setValue(iP);
                    pay.setCreated(new Date());
                    pay.setAccount(account);
                    pay.setNotes("notes");
                    session.save(pay);
                }
            }
            session.getTransaction().commit();
        } catch(Exception e) {            
            session.getTransaction().rollback();
            System.out.println("Exception:"+e.getLocalizedMessage());
        }
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Список платежей");
        
        initRootLayout();
        
        showPayList();
    }
    
    /**
     * Initializes the root layout.
    */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/fxml/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showPayList() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/fxml/payList.fxml"));
            AnchorPane payListPane = (AnchorPane) loader.load();

            rootLayout.setCenter(payListPane);
            
            PayListController controller=loader.getController();
            controller.loadList();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
