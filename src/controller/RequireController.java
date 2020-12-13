/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.UserDAO;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class RequireController {
    
    @FXML
    private Button requireButton;
    
    @FXML
    private TextField requireId;
    
    public void requireAction(ActionEvent event) {
        String hashCode = requireId.getText();
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.findAll();
        list.forEach(item -> {
            if (item.getPassword().equals(hashCode)){
                Redirect("index");
            }
        });
    }
    
    private void Redirect(String file) {
        Stage stage = Store.getInstance().getStage();
        Parent root = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/layout/" + file + ".fxml"));
            scene = new Scene(root);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
}
