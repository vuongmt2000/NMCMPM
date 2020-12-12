/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IStatisticalDAO;
import dao.impl.StatisticalDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stt.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unit1.setCellValueFactory(new PropertyValueFactory<>("unit"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        IStatisticalDAO istatisticalDAO = new StatisticalDAO();
        List<Statistical> list = istatisticalDAO.findAll();
        table.setItems(FXCollections.observableArrayList(list));
    }
    
    
}
