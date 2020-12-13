/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IStatisticalDAO;
import dao.impl.StatisticalImpl; 
import java.io.IOException; 
import java.net.URL;  
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; 
import javafx.fxml.Initializable; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage; 
import model.Statistical;

/**
 *
 * @author vuong
 */
public class StatisticalController implements  Initializable{
    
    @FXML
    TableView<Statistical> table;
    
    @FXML
    TableColumn<Statistical, Number> stt;
    
    @FXML
    TableColumn<Statistical, Number> id;
    
    @FXML
    TableColumn<Statistical, String> name;
    
    @FXML
    TableColumn<Statistical, Number> quantity;
    
    @FXML
    TableColumn<Statistical, String> unit1;
    
    @FXML
    TableColumn<Statistical, Number> status;
    
    @FXML 
    TableColumn<Statistical, String> roomId; 
     
    @FXML 
    Button goBack; 
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit1.setCellValueFactory(new PropertyValueFactory<>("unit"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        roomId.setCellValueFactory(new PropertyValueFactory<>("room")); 
        
        IStatisticalDAO istatisticalDAO = new StatisticalImpl();
        List<Statistical> list = istatisticalDAO.findAll();
        table.setItems(FXCollections.observableArrayList(list));
    }
    
    public void goBackPage(ActionEvent event) {  
         Stage stage = Store.getInstance().getStage(); 
        Parent root = null; 
        Scene scene = null; 
        try { 
            root = FXMLLoader.load(this.getClass().getResource("/layout/manager-layout.fxml")); 
            scene = new Scene(root); 
        } catch (IOException e1) { 
            e1.printStackTrace(); 
        } 
        stage.setScene(scene); 
        stage.show(); 
    } 
     
    
}
