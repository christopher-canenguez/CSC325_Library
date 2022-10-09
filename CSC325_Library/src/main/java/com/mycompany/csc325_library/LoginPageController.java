/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.csc325_library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class LoginPageController implements Initializable {

    private Parent root;
    
    @FXML
    public Button exitButton;
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
    
    @FXML
    public void exitButtonEvent(ActionEvent event) {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    } // End exitButtonEvent.
} // End LoginPageController.
