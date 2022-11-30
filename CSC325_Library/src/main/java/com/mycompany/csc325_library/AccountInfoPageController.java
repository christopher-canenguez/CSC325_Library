package com.mycompany.csc325_library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class AccountInfoPageController implements Initializable {

    @FXML public Button exitButton;
    
    @FXML TextField accountNameTextField;
    @FXML TextField accountNumberTextField;
    @FXML TextField accountPinTextField;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountNameTextField.setText(LoginPageController.currentUser.getName());
        accountNumberTextField.setText(String.valueOf(LoginPageController.currentUser.getId()));
        accountPinTextField.setText(String.valueOf(LoginPageController.currentUser.getPinCode()));
        
    } // End initialize.
    
    @FXML
    public void updateFieldsForCurrentUser(String userName, int acctNum, int acctPin)
    {
        accountNameTextField.setText(userName);
        accountNumberTextField.setText(String.valueOf(acctNum));
        accountPinTextField.setText(String.valueOf(acctPin));
    } // End updateFieldsForCurrentUser.
    
    @FXML
    public void exitButtonEvent(ActionEvent event) {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    } // End exitButtonEvent.
} // End AccountInfoPageController.
