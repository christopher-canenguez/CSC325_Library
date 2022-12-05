package com.mycompany.csc325_library;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chris Canenguez
 */
public class DatabasePageController implements Initializable {
    //Configure the tableView
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> isbnColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> availabilityColumn;
    @FXML
    private TableColumn<Book, String> holderColumn;

    @FXML
    RadioButton isbnRadioButton;
    @FXML
    RadioButton authorRadioButton;
    @FXML
    RadioButton titleRadioButton;

    ToggleGroup tg = new ToggleGroup();

    @FXML
    public Button exitButton;
    @FXML
    public Button loadButton;

    public Book[] booksArray;

    private boolean key;
    private Book book;
    ObservableList<Book> books = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up the columns of the table.
        
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        holderColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("holder"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("status"));

        // Added radiobuttons to toggle group so only one could be selected at one time.
        isbnRadioButton.setToggleGroup(tg);

        authorRadioButton.setToggleGroup(tg);

        titleRadioButton.setToggleGroup(tg);

        isbnRadioButton.setSelected(true);

        // Added a change listener to see when a button is clicked.
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                    Toggle o, Toggle n) {

                RadioButton rb = (RadioButton) tg.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();

                    // change the label
                    System.out.println(s + " was selected!");
                } // End if.
            }
        });

        App.refreshTimer();

    } // End initialize.

    /**
     * Method that loads the records from the firebase into the tableView.
     *
     * @param event
     */
    @FXML
    private void loadRecords(ActionEvent event) {
        loadData();
        App.refreshTimer();
    } // End loadRecords.

    public boolean loadData() {
        try {
            key = false;
            tableView.getItems().clear(); // Clear the table when reading.

            // Asynchronously retrieve all documents.
            ApiFuture<QuerySnapshot> future = App.fstore.collection("Books").get();

            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents;

            // Go through the firebase database, create a Person object for every document.
            documents = future.get().getDocuments();

            if (documents.size() > 0) {
                System.out.println("Outing...");
                for (QueryDocumentSnapshot document : documents) {
                    book = new Book(document.getData().get("title").toString(),
                            new Person(document.getData().get("author").toString()),
                            document.getData().get("holder").toString(),
                            document.getData().get("isbn").toString(),
                            document.getData().get("availability").toString());

                    books.add(book);
                } // End for.
            } // End if.
            tableView.setItems(books);
        } catch (InterruptedException ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        } // End catch.

        return key;
    } // End loadData.

    @FXML
    public void exitButtonEvent(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.window.setWidth(600);
        App.window.setHeight(422);
        App.loadMain();
    } // End exitButtonEvent.
} // End DatabasePageController.
