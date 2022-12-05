/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.csc325_library;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import static com.mycompany.csc325_library.LoginPageController.currentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class BookCheckoutPageController implements Initializable {

    @FXML
    public Button exitButton;

    @FXML
    public TextField isbnTextField;
    @FXML
    public TextField accountNumberTextField;
    @FXML
    public TextField accountPinTextField;

    @FXML
    public Label errorLabel;
    @FXML
    public Label successLabel;

    private User user1;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.refreshTimer();
        // TODO
    } // End initialize.

    @FXML
    public void checkoutButton() throws InterruptedException, ExecutionException {
        // Set labels to hidden whenever button is clicked first.
        errorLabel.setVisible(false);
        successLabel.setVisible(false);
        
        if (accountNumberTextField.getText().trim().equals("") || isbnTextField.getText().trim().equals("") || accountPinTextField.getText().trim().equals("")) {
            errorLabel.setText("Field(s) are empty, please try again");
            errorLabel.setVisible(true);
            clearTextFields();
            return;
        } // End if.

        // Get data from text fields.
        String isbn = isbnTextField.getText();
        System.out.println(isbn);
        int accountNumber = Integer.parseInt(accountNumberTextField.getText());
        int accountPin = Integer.parseInt(accountPinTextField.getText());

        // Check if the isbn exists.
        DocumentReference docRef = App.fstore.collection("Books").document(isbn);

        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();

        // future.get() blocks on response
        DocumentSnapshot document = future.get();

        // Checks if the book isbn entered is available or not.
        if (document.getData().get("availability").equals("UNAVAILABLE")) {
            errorLabel.setText("The isbn you entered is reserved, please try another isbn.");
            errorLabel.setVisible(true);
            clearTextFields();
            return;
        } // End if.

        System.out.println("Check Test");

        // Checks if the isbn entered exists within the firebase database.
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
            errorLabel.setText("Isbn entered doesn't exist, please enter a valid isbn.");
            errorLabel.setVisible(true);
            clearTextFields();
            return;
        } // End else.

        // Based on the account Number that is entered into the text field,
        // Retrieve the designated account based on the string entered.
        user1 = User.search(LoginPageController.users, accountNumber);

        // If the pin number entered doesn't match that of the pin on the account,
        // retry entering the pin code until they match.
        //if (!(currentUser.getPinCode() == pinNum)) 
        if (user1 == null) {
            // Set wrong pin number text visibile if both pin numbers don't match.
            errorLabel.setText("The account number you entered doesn't exist. Please enter a valid account number.");
            errorLabel.setVisible(true);

            clearTextFields(); // Reset fields.
        } // End if.
        else if (!(user1.getPinCode() == accountPin)) {
            // Set wrong pin number text visibile if both pin numbers don't match.
            errorLabel.setText("The pin code is wrong for this account. Please enter again.");
            errorLabel.setVisible(true);

            clearTextFields(); // Reset fields.
        } // End if.
        else {
            // Checks if the current user in the session has entered their specific account number and pin.
            // Preventing the user from checking out or returning a book from another person credentials.
            if (user1.getId() != currentUser.getId()) {
                errorLabel.setText("The account number and pin you've entered don't match that of the user currently logged in.");
                errorLabel.setVisible(true);
                
                accountNumberTextField.clear();
                accountPinTextField.clear();
                return;
                
            } // End if.
            // Update an existing document
            docRef = App.fstore.collection("Books").document(isbn);
            ApiFuture<WriteResult> future2 = docRef.update("availability", "UNAVAILABLE");
            ApiFuture<WriteResult> future3 = docRef.update("holder", currentUser.getName());
            clearTextFields();
            successLabel.setVisible(true);
        } // End else.
    } // End checkoutButton.

    @FXML
    private void clearTextFields() {
        accountNumberTextField.clear(); // Reset field.
        isbnTextField.clear(); // Reset field.
        accountPinTextField.clear(); // Reset field.
    } // End clearTextFields.

    @FXML
    public void exitButtonEvent(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.loadMain(); 
    } // End exitButtonEvent.
} // End BookCheckoutPageController.
