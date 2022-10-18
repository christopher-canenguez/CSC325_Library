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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class MainMenuPageController implements Initializable 
{

    private Parent root1;
    private Parent root2;
    private Parent root3;

    @FXML
    public Button logoutButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try 
        {
            // TODO
            openJDBC();
        } catch (SQLException ex) 
        {
            Logger.getLogger(MainMenuPageController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    } // End initialize.

    /**
     * Method that transfers user from main menu to checkout page.
     *
     * @throws IOException
     */
    @FXML
    public void goToCheckoutButton() throws IOException 
    {
        // Retrieves Loader for BookCheckout page.
        FXMLLoader checkoutLoader = new FXMLLoader(getClass().getResource("BookCheckoutPage.fxml"));
        root1 = checkoutLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    } // End goToCheckoutButton.

    /**
     * Method that transfers user from main menu to account info page.
     *
     * @throws IOException
     */
    @FXML
    public void goToAccountInfoButton() throws IOException 
    {
        // Retrieves Loader for AccountInfo page.
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("AccountInfoPage.fxml"));
        root2 = accountLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
    } // End goToAccountInfoButton.

    /**
     * Method that transfers user from main menu to database page.
     *
     * @throws IOException
     */
    @FXML
    public void goToDatabaseButton() throws IOException 
    {
        // Retrieves Loader for Database page.
        FXMLLoader databaseLoader = new FXMLLoader(getClass().getResource("DatabasePage.fxml"));
        root3 = databaseLoader.load();

        // Creates and loads scene.
        Stage stage = new Stage();
        stage.setScene(new Scene(root3));
        stage.show();
    } // End goToDatabaseButton.

    /**
     * Method that transfers user from main menu back to login page and ends
     * user session.
     *
     * @param event
     */
    @FXML
    public void logoutButton(ActionEvent event) 
    {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    } // End logoutButton.

    /**
     * openJDBC - method that creates a connection from project to database file.
     * @throws SQLException 
     */
    public void openJDBC() throws SQLException 
    {
        String databaseURL = "";
        Connection conn = null;

        // Name of file.
        databaseURL = "jdbc:ucanaccess://.//Books.accdb";
        conn = DriverManager.getConnection(databaseURL);

        // Test to print database info.
        String tableName = "Books";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("select * from " + tableName);

        while (result.next()) 
        {
            int isbn = result.getInt("Isbn");
            String title = result.getString("Title");
            String author = result.getString("Author");
            String status = result.getString("Status");
            String person = result.getString("Person");
            System.out.printf("%d, %s, %s, %s, %s\n", isbn, title, author, status, person);
        } // End while.
    } // End openJDBC.
} // End MainMenuPageController.
