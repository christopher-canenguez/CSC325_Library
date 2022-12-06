package com.mycompany.csc325_library;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField searchTextField;
    @FXML
    private Button backPageButton;
    @FXML
    private Label pageLabel;
    @FXML
    private Button nextPageButton;
    
    private APISearchResult loadedResult;
    private GBSearchObject searchObject;
    int currentPage = 0;
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
        nextPageButton.disableProperty().set(true);
        backPageButton.disableProperty().set(true);

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
    
    void loadPage()
    {
        ArrayList<String> isbnArray = new ArrayList();
        HashMap<String, Book> bookMap = new HashMap();
        for (int i = 0; i < loadedResult.items.size(); i++) {
            if(loadedResult.items.get(i).volumeInfo.industryIdentifiers != null &&
                    loadedResult.items.get(i).volumeInfo.industryIdentifiers.length > 0 &&
                    loadedResult.items.get(i).volumeInfo.authors != null &&
                    loadedResult.items.get(i).volumeInfo.authors.length > 0
                    )
            {
                isbnArray.add(loadedResult.items.get(i).volumeInfo.industryIdentifiers[0].identifier);
                book = new Book(loadedResult.items.get(i).volumeInfo.title,
                            new Person(loadedResult.items.get(i).volumeInfo.authors[0]),
                            "",
                            loadedResult.items.get(i).volumeInfo.industryIdentifiers[0].identifier,
                            "NOT IN STOCK");
                
                bookMap.put(loadedResult.items.get(i).volumeInfo.industryIdentifiers[0].identifier,
                        book);
            }
            
        }
        var bookCollection = App.fstore.collection("Books");
            
        Query query = bookCollection.whereIn("isbn", isbnArray);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("");
        try {
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                book = new Book(document.getData().get("title").toString(),
                        new Person(document.getData().get("author").toString()),
                        document.getData().get("holder").toString(),
                        document.getData().get("isbn").toString(),
                        document.getData().get("availability").toString());
                
                bookMap.put(document.getData().get("isbn").toString(),book);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(var v: bookMap.values())
        {
            books.add(v);
        }
        tableView.setItems(books);
    }
    
    public boolean loadData(int page)
    {
        try {
            key = false;
            tableView.getItems().clear(); // Clear the table when reading.

            loadedResult = new GoogleBooksController().search(searchObject, (page-1)*10);
            System.out.println(loadedResult.items.size());
            nextPageButton.disableProperty().set(currentPage * 10 >= loadedResult.totalItems);
            backPageButton.disableProperty().set(currentPage <= 1);
            pageLabel.setText(""+currentPage);
            loadPage();
        } catch (Exception ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public boolean loadData() {
        try {
            key = false;
            tableView.getItems().clear(); // Clear the table when reading.
            var gbSearchCompiler = new GBSearchCompiler();
            
            if(isbnRadioButton.isSelected())
            {
                gbSearchCompiler.addISBNParameter(searchTextField.getText());
            }
            else if(authorRadioButton.isSelected())
            {
                gbSearchCompiler.addAuthorParameter(searchTextField.getText());
            }
            else if(titleRadioButton.isSelected())
            {
                gbSearchCompiler.addTitleParameter(searchTextField.getText());
            }
            searchObject = gbSearchCompiler.compile();
            loadedResult = new GoogleBooksController().search(searchObject);
            System.out.println(loadedResult.items.size());
            currentPage = 1;
            nextPageButton.disableProperty().set(currentPage * 10 >= loadedResult.totalItems);
            backPageButton.disableProperty().set(currentPage <= 1);
            pageLabel.setText(""+currentPage);
            loadPage();
        } catch (Exception ex) {
            Logger.getLogger(DatabasePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    } // End loadData.

    @FXML
    public void exitButtonEvent(ActionEvent event) throws IOException {
        // Gets current scene when button is clicked then closes window.
        App.window.setWidth(600);
        App.window.setHeight(422);
        App.loadMain();
    } // End exitButtonEvent.

    @FXML
    private void backPage(ActionEvent event) {
        currentPage--;
        loadData(currentPage);
        App.refreshTimer();
    }

    @FXML
    private void forwardPage(ActionEvent event) {
        currentPage++;
        loadData(currentPage);
        App.refreshTimer();
    }
} // End DatabasePageController.
