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
        // users list and populating array
        userList = new User[5];
        User user1 = new User("Sam Hindy", 231, 231);
        userList[0] = user1;
        User user2 = new User("Kelly Lane", 222, 222);
        userList[1] = user2;
        User user3 = new User("Christopher Canenguez", 333, 333);
        userList[2] = user3;
        User user4 = new User("Shameed Jobb", 444, 444);
        userList[3] = user4;
        User user5 = new User("Kulsom Zaraei", 555, 555);
        userList[4] = user5;
    } // End initialize.
    
    @FXML
    public void loginButton() throws IOException
    {
        // Gets loader for MainMenu page.
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("MainMenuPage.fxml"));
        root = loginLoader.load();
        
        // Get data from text fields.
        int acctNum = Integer.valueOf(accountNumTextField.getText());
        int pinNum = Integer.valueOf(pinCodeTextField.getText());
        
        // Based on the account Number that is entered into the text field,
        // Retrieve the designated account based on the string entered.
        currentUser = User.search(userList, acctNum);
        
        // If the pin number entered doesn't match that of the pin on the account,
        // retry entering the pin code until they match.
        //if (!(currentUser.getPinCode() == pinNum)) 
        if (currentUser == null)
        {
            // Set wrong pin number text visibile if both pin numbers don't match.
            wrongPinLabel.setText("The account number you entered doesn't exist. Please enter a valid account number.");
            wrongPinLabel.setVisible(true);
            
            accountNumTextField.clear(); // Reset field.
            pinCodeTextField.clear(); // Reset field.
        } // End if.
        else if(!(currentUser.getPinCode() == pinNum))
        {
            // Set wrong pin number text visibile if both pin numbers don't match.
            wrongPinLabel.setText("The pin code is wrong for this account. Please enter again.");
            wrongPinLabel.setVisible(true);
            
            accountNumTextField.clear(); // Rest field.
            pinCodeTextField.clear(); // Reset field.
        } // End if.
        else
        {
            // Sets stage and opens window.
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            accountNumTextField.clear(); // Reset field.
            pinCodeTextField.clear(); // Reset field.
            wrongPinLabel.setVisible(false); // Turn off error when valid login entered.
        } // End else.

    } // End login.   
    
    @FXML
    public void exitButtonEvent(ActionEvent event) {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    } // End exitButtonEvent.
    
} // End LoginPageController.
