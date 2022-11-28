package com.mycompany.csc325_library;

import com.google.cloud.firestore.Firestore;
import com.mycompany.csc325_library.FirestoreContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX Library App
 * Created by:
 * Christopher Canenguez,
 * Kulsom Zaraei,
 * and Shameed Job!
 */
public class App extends Application 
{
    public static Scene scene;
    
    // Firestore objects.
    public static Firestore fstore;
    private final FirestoreContext contxtFirebase = new FirestoreContext();
    
    @Override
    public void start(Stage stage) throws IOException 
    {
        fstore = contxtFirebase.firebase();
        
        scene = new Scene(loadFXML("LoginPage"), 600, 402);
        stage.setScene(scene);
        stage.show();
    } // End start.

    static void setRoot(String fxml) throws IOException 
    {
        scene.setRoot(loadFXML(fxml));
    } // End setRoot.

    private static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    } // End Parent.
    
    public static void testSearchParameter()
    {
       GoogleBooksController gbc = new GoogleBooksController();
       
       var gbSearch = new GBSearchCompiler().addAuthorParameter("Rowling").addTitleParameter("Potter").compile();
       
       APISearchResult search = gbc.search(gbSearch);
       
       System.out.println(search.totalItems);
       System.out.println(search.items.length);
        
       for(var item: search.items)
       {
           System.out.println(item.volumeInfo.title);
       } // End for.
    } // End testSearchParameter.
    
    public static void main(String[] args) 
    {
        System.out.println("Hello CSC325!");
        testSearchParameter();
        launch();
    } // End main.
}
