package com.mycompany.csc325_library;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class MainMenuPageController implements Initializable {

    private Parent root1;
    private Parent root2;
    private Parent root3;
    private Parent root4;

    public Book[] books = new Book[10]; // Book Array.

    @FXML
    public Button logoutButton;

    @FXML
    Label nameLabel;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (LoginPageController.currentUser != null) {
            nameLabel.setText(LoginPageController.currentUser.getName());
        }
    } // End initialize.

    /**
     * Method that transfers user from main menu to checkout page.
     *
     * @throws IOException
     */
    @FXML
    public void goToCheckoutButton() throws IOException {
        // Retrieves Loader for BookCheckout page.
        App.setRoot("BookCheckoutPage");
    } // End goToCheckoutButton.

    /**
     * Method that transfers user from main menu to account info page.
     *
     * @throws IOException
     */
    @FXML
    public void goToAccountInfoButton() throws IOException {
        // Retrieves Loader for AccountInfo page.
        App.setRoot("AccountInfoPage");
    } // End goToAccountInfoButton.

    /**
     * Method that transfers user from main menu to database page.
     *
     * @throws IOException
     */
    @FXML
    public void goToDatabaseButton() throws IOException {
        // Retrieves Loader for Database page.
        FXMLLoader databaseLoader = new FXMLLoader(getClass().getResource("DatabasePage.fxml"));
        root3 = databaseLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root3));
        stage.show();

    } // End goToDatabaseButton.
    
    /**
     * Method that transfers user from main menu to return page.
     *
     * @throws IOException
     */
    @FXML
    public void goToReturnPage() throws IOException {
        // Retrieves Loader for Database page.
        App.setRoot("ReturnPage");
    } // End goToDatabaseButton.

    /**
     * Method that transfers user from main menu back to login page and ends
     * user session.
     *
     * @param event
     */
    @FXML
    public void logoutButton(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.setRoot("LoginPage");
    } // End logoutButton.

} // End MainMenuPageController.
