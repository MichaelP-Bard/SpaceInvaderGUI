/**
 * Description: Space Invaders JavaFX Game
 * This game is a version of Space Invaders where players shoot at incoming alien waves.
 * The game gets progressively harder with multiple waves.
 *
 * @author Michael Polk
 * @since May 6, 2025
 */

package com.example.spaceinvadergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static Stage primaryStage;

    /**
     * Sets up and shows the main menu scene.
     * @param stage the primary stage for this application
     * @throws Exception if the FXML fails to load
     */
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        // Load the start screen layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Show the scene
        Scene scene = new Scene(root, 600, 800);
        stage.setTitle("Space Invaders FX");
        stage.setScene(scene);
        stage.show();
    }

    /** Launches the application. */
    public static void main(String[] args) {
        launch();
    }
}

