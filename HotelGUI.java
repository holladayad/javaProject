/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class HotelGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 
        Label lblUser = new Label("Enter Username");
        TextField txtUser = new TextField();
        Label lblPass = new Label ("Enter Password");
        TextField txtPass = new TextField();
        Button btnLogin = new Button("Login");
        
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        primaryPane.add(lblUser, 0, 0);
        primaryPane.add(txtUser,1,0);
        primaryPane.add(lblPass, 0, 1);
        primaryPane.add(txtPass, 1, 1);
        primaryPane.add(btnLogin, 1,3);
        
        Scene primaryScene = new Scene(primaryPane, 650, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Hotel Madison");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
