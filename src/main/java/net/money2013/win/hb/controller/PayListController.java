/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.controller;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.money2013.win.hb.dal.Pay;
import net.money2013.win.hb.util.HibernateUtil;
import net.money2013.win.hb.view.PayView;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author aisaev
 */
public class PayListController implements Initializable {
    @FXML
    private TableView<PayView> payTable;
    @FXML
    private TableColumn<PayView,String> payDateColumn;
    @FXML
    private TableColumn<PayView,String> payValueColumn;
    @FXML
    private TableColumn<PayView,String> payNotesColumn;

   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        payDateColumn.setCellValueFactory(cellData -> cellData.getValue().getCreated().asString());
        payValueColumn.setCellValueFactory(cellData -> cellData.getValue().getValue());
        payNotesColumn.setCellValueFactory(cellData -> cellData.getValue().getNotes());
    }    
    
    public void loadList() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        //List accounts=session.createQuery("select a.id, sum(p.payValue) from Account a left outer join a.pays p group by a.id").list();
        
        List resultList=session.createQuery("select p.id,p.notes,p.payValue,p.created,a.name,a.currency,c.name,p.isSystem from Pay p left outer join p.account a left outer join p.category c WHERE p.isDeleted = false and a.isDeleted = false ORDER BY p.created DESC").list();
        ObservableList<PayView> viewList=FXCollections.observableArrayList();
        
        for(Object o : resultList) {
            Object[] p=(Object[])o;
            viewList.add(new PayView((long)p[0],(String)p[1],(double)p[2],(Date)p[3],(String)p[4],(String)p[5],(String)p[6],(boolean)p[7]));
        }
        
        payTable.setItems(viewList);
    }
}
