package com.mycompany.csc325_library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class AccountInfoPageController implements Initializable {

    @FXML
    public Button exitButton;

    @FXML
    TextField accountNameTextField;
    @FXML
    TextField accountNumberTextField;
    @FXML
    TextField accountPinTextField;

    @FXML
    PasswordField accountNamePasswordField;
    @FXML
    PasswordField accountNumberPasswordField;
    @FXML
    PasswordField accountPinPasswordField;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPasswordAndTextFields();
        App.refreshTimer();
    } // End initialize.

    @FXML
    public void exitButtonEvent(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.loadMain();
    } // End exitButtonEvent.

    private void setPasswordAndTextFields() {
        accountNamePasswordField.setText(LoginPageController.currentUser.getName());
        accountNumberPasswordField.setText(String.valueOf(LoginPageController.currentUser.getId()));
        accountPinPasswordField.setText(String.valueOf(LoginPageController.currentUser.getPinCode()));

        accountNameTextField.setText(LoginPageController.currentUser.getName());
        accountNumberTextField.setText(String.valueOf(LoginPageController.currentUser.getId()));
        accountPinTextField.setText(String.valueOf(LoginPageController.currentUser.getPinCode()));
    }

    @FXML
    public void showInfoEvent(ActionEvent event) {
        if (isInfoVisible()) {
            hideInfo();
        } else {
            showInfo();
        }

    }

    private boolean isInfoVisible() {
        if (accountNameTextField.isVisible()) {
            return true;
        }
        return false;
    }

    private void showInfo() {
        accountNamePasswordField.setVisible(false);
        accountNumberPasswordField.setVisible(false);
        accountPinPasswordField.setVisible(false);

        accountNameTextField.setVisible(true);
        accountNumberTextField.setVisible(true);
        accountPinTextField.setVisible(true);
    }

    private void hideInfo() {
        accountNamePasswordField.setVisible(true);
        accountNumberPasswordField.setVisible(true);
        accountPinPasswordField.setVisible(true);

        accountNameTextField.setVisible(false);
        accountNumberTextField.setVisible(false);
        accountPinTextField.setVisible(false);
    }
} // End AccountInfoPageController.
