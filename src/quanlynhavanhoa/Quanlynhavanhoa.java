/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhavanhoa;

import controller.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ADMIN
 */
public class Quanlynhavanhoa extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        Store.getInstance().setStage(primaryStage);
        root = FXMLLoader.load(getClass().getResource("/layout/index.fxml"));
        primaryStage.setTitle("Biểu mẫu đăng ký");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
