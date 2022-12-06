package com.mycompany.csc325_library;

import com.google.cloud.firestore.Firestore;
import com.mycompany.csc325_library.FirestoreContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.time.DateUtils;

/**
 * JavaFX Library App Created by: Christopher Canenguez, Kulsom Zaraei, and
 * Shameed Job!
 */
public class App extends Application {

    public static Scene scene;
    public static Stage window;

    // Firestore objects.
    public static Firestore fstore;
    private final FirestoreContext contxtFirebase = new FirestoreContext();

    @Override
    public void start(Stage stage) throws IOException {
        fstore = contxtFirebase.firebase();
        window = stage;
        scene = new Scene(loadFXML("LoginPage"), 600, 400);

        
        stage.setScene(scene);
        stage.show();
                System.out.println(window.getHeight());
        System.out.println(window.getWidth());
    } // End start.

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    } // End setRoot.

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    } // End Parent.

    static void loadMain() throws IOException {
        setRoot("MainMenuPage");
    }

    public static void main(String[] args) {
        launch();
    } // End main.

    public static Timer logInTimer;
    private static boolean timerSet;

    public static void setUpTimer() {

        refreshTimer();
    }
    
    public static void refreshTimer()
    {
        if(timerSet == true)
        {
            logInTimer.cancel();
            timerSet = false;
        }
        timerSet = true;
        logInTimer = new Timer();
        var targetTime = DateUtils.addMinutes(Date.from(Instant.now()), 5);
        logInTimer.schedule(new LogOutTimerTask(), targetTime);
    }

    public static void logOut() {
        try {
            setRoot("LoginPage");
            App.window.setWidth(600);
            App.window.setHeight(422);
            if(timerSet== true)
            {
                logInTimer.cancel();
                timerSet = false;
            }
            logInTimer = null;
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
