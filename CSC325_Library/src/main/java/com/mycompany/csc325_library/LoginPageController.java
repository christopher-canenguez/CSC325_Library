/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.csc325_library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chriscanenguez
 */
public class LoginPageController implements Initializable {

    private Parent root;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    } // End initialize.
    
    @FXML
    public void loginButton() throws IOException
    {
        // Gets loader for MainMenu page.
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("MainMenuPage.fxml"));
        root = loginLoader.load();

        // Sets stage and opens window.
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } // End login.   
} // End LoginPageController.
