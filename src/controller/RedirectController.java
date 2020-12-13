package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RedirectController implements  Initializable{
    
    @FXML
    Button registerId;
    
    @FXML
    Button loginId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage stage = Store.getInstance().getStage();
        
        registerId.setOnAction(new EventHandler<ActionEvent>() {
			
                @Override
                public void handle(ActionEvent arg0) {
                    Redirect("register");
                }
        });
        
        loginId.setOnAction(new EventHandler<ActionEvent>() {
			
                @Override
                public void handle(ActionEvent arg0) {
                    Redirect("login");
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
