package controller;

import dao.impl.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class LoginController implements Initializable {

    @FXML
    TextField username;

    @FXML
    TextField password;

    @FXML
    Label invalid;

    @FXML
    Button login;

    @FXML
    Button back;

    private String in = "Tên tài khoản hoặc mật khẩu không chính xác";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String usernameLogin = username.getText();
                String passwordLogin = password.getText();
                if (usernameLogin != "" && passwordLogin != ""){
                    UserDAO userDao = new UserDAO();
                    User user = new User();
                    user = userDao.findByName(usernameLogin);
                    if (!user.getPassword().equals(passwordLogin)){
                        invalid.setText(in);
                    }
                    if (user != null){
                        Redirect("manager-layout");
                    }
                }
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
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
