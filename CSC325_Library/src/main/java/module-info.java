module com.mycompany.csc325_library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires com.google.gson;

    opens com.mycompany.csc325_library to javafx.fxml;
    exports com.mycompany.csc325_library;
}
