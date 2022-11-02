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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class LoginPageController implements Initializable {

    private Parent root;
    public User[] userList;
    private User currentUser;
    
    @FXML public Button exitButton;
    
    @FXML TextField accountNumTextField;
    @FXML TextField pinCodeTextField;
    
    @FXML Label wrongPinLabel;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        // users list and populating array
        userList = new User[5];
        User user1 = new User("Sam Hindy", 231, 231);
        user1 = userList[0];
        User user2 = new User("Kelly Lane", 222, 222);
        user2 = userList[1];
        User user3 = new User("Christopher Canenguez", 333, 333);
        user3 = userList[2];
        User user4 = new User("Shameed Jobb", 444, 444);
        user4 = userList[3];
        User user5 = new User("Kulsom Zaraei", 555, 555);
        user5 = userList[4];
    } // End initialize.
    
    @FXML
    public void loginButton() throws IOException
    {
        // Gets loader for MainMenu page.
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("MainMenuPage.fxml"));
        root = loginLoader.load();
        
        // Get data from text fields.
        int acctNum = Integer.valueOf(accountNumTextField.getText());
        
        String pinNum = pinCodeTextField.getText();
        
        // Based on the account Number that is entered into the text field,
        // Retrieve the designated account based on the string entered.
        currentUser = User.search(userList, acctNum);

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
