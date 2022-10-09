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
public class MainMenuPageController implements Initializable {

    private Parent root1;
    private Parent root2;
    
    @FXML
    public Button logoutButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } // End initialize.

    @FXML
    public void goToCheckoutButton() throws IOException {
        // Retrieves Loader for BookCheckout page.
        FXMLLoader checkoutLoader = new FXMLLoader(getClass().getResource("BookCheckoutPage.fxml"));
        root1 = checkoutLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    } // End goToCheckoutButton.

    @FXML
    public void goToAccountInfo() throws IOException {
         // Retrieves Loader for AccountInfo page.
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("AccountInfoPage.fxml"));
        root2 = accountLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    } // End goToAccountInfo.

    @FXML
    public void logoutButton(ActionEvent event) {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    } // End logoutButton.
} // End MainMenuPageController.
