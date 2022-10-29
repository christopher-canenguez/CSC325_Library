package com.mycompany.csc325_library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class DatabasePageController implements Initializable {

    //Configure the tableView
    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, Integer> isbnColumn;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> availabilityColumn;
    
    @FXML
    public Button exitButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up the columns of the table.
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("titleColumn"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authorColumn"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("availabilityColumn"));

        // Load Books.
        tableView.setItems(getBooks());
    } // End initialize.
    
    public ObservableList<Book> getBooks()
    {
        
    }
    
    @FXML
    public void exitButtonEvent(ActionEvent event) {
        // Gets current scene when button is clicked then closes window.
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    } // End exitButtonEvent.
} // End DatabasePageController.
