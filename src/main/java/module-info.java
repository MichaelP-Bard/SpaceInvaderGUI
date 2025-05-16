module com.example.spaceinvadergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spaceinvadergui to javafx.fxml;
    exports com.example.spaceinvadergui;
}