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
import net.money2013.win.hb.dal.Account;
import net.money2013.win.hb.dal.Category;
import net.money2013.win.hb.dal.Pay;
import net.money2013.win.hb.net.utils.RestClient;
import net.money2013.win.hb.net.utils.SerialDB;
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

        try {
            String gson;
            RestClient client=RestClient.getInstance();
            gson=client.sendSyncData("demo", "demo", SerialDB.serial());
            SerialDB.deserial(gson);
            //System.out.println(gson);
        } catch(Exception e) {
            e.printStackTrace();
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
