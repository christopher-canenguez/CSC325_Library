package com.mycompany.csc325_library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import static com.mycompany.csc325_library.LoginPageController.currentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
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
 * @author chriscanenguez
 */
public class ReturnPageController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.refreshTimer();
    }

    @FXML
    public void returnButton() throws InterruptedException, ExecutionException {
        
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

        if (document.getData().get("availability").equals("AVAILABLE")) {
            errorLabel.setText("The isbn you entered is currently available, please try another isbn.");
            errorLabel.setVisible(true);
            return;
        } // End if.

        System.out.println("Check Test");
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
            errorLabel.setText("Isbn entered doesn't exist, please enter a valid isbn.");
            errorLabel.setVisible(true);
            return;
        }

        // Based on the account Number that is entered into the text field,
        // Retrieve the designated account based on the string entered.
        currentUser = User.search(LoginPageController.userList, accountNumber);

        // If the pin number entered doesn't match that of the pin on the account,
        // retry entering the pin code until they match.
        //if (!(currentUser.getPinCode() == pinNum)) 
        if (currentUser == null) {
            // Set wrong pin number text visibile if both pin numbers don't match.
            errorLabel.setText("The account number you entered doesn't exist. Please enter a valid account number.");
            errorLabel.setVisible(true);

            clearTextFields(); // Reset fields.
        } // End if.
        else if (!(currentUser.getPinCode() == accountPin)) {
            // Set wrong pin number text visibile if both pin numbers don't match.
            errorLabel.setText("The pin code is wrong for this account. Please enter again.");
            errorLabel.setVisible(true);

            clearTextFields(); // Reset fields.
        } // End if.
        else if (!(currentUser.getName().equals(document.getData().get("holder"))))
        {
            errorLabel.setText("Only the book holder can return this book.");
            errorLabel.setVisible(true);
        }
        else {
            // Update an existing document
            docRef = App.fstore.collection("Books").document(isbn);
            ApiFuture<WriteResult> future2 = docRef.update("availability", "AVAILABLE");
            ApiFuture<WriteResult> future3 = docRef.update("holder", "");

            successLabel.setVisible(true);
        } // End else.
    }

    @FXML
    private void clearTextFields() {
        accountNumberTextField.clear(); // Reset field.
        isbnTextField.clear(); // Reset field.
        accountPinTextField.clear(); // Reset field.
    } // End clearTextFields.

    @FXML
    public void exitButtonEvent(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.setRoot("MainMenuPage");
    } // End exitButtonEvent.

}
