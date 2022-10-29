package com.mycompany.csc325_library;

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

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException 
    {
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

    public static void main(String[] args) 
    {
        System.out.println("Hello CSC325!");
        launch();
    } // End main.
} // End App.