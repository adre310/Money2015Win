/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.money2013.win.hb.dal.PayDAL;
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
        payValueColumn.setCellValueFactory(cellData -> cellData.getValue().getValue().asString());
        payNotesColumn.setCellValueFactory(cellData -> cellData.getValue().getNotes());
    }    
    
    public void loadList() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        List resultList=session.createQuery("from PayDAL").list();
        ObservableList<PayView> viewList=FXCollections.observableArrayList();
        
        for(Object o : resultList) {
            viewList.add(new PayView((PayDAL)o));
        }
        
        payTable.setItems(viewList);
    }
}
