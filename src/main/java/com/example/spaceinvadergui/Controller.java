/**
 * Description: Space Invaders JavaFX Game
 * This game is a version of Space Invaders where players shoot at incoming alien waves.
 * The game gets progressively harder with multiple waves.
 *
 * @author Michael Polk
 * @since May 6, 2025
 */

package com.example.spaceinvadergui;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class HelloController {

    @FXML
    private Canvas backgroundCanvas;

    @FXML
    private Label welcomeText;

    private static final int STAR_COUNT = 100;
    private final double[] starX = new double[STAR_COUNT];
    private final double[] starY = new double[STAR_COUNT];
    private final double[] speed = new double[STAR_COUNT];
    private final Random random = new Random();

    private double pulseAngle = 0;

    /**
     * Runs once the controller is initialized.
     * Sets up falling stars and pulsing welcome text.
     */
    @FXML
    public void initialize() {
        // Set up random star positions and speeds
        for (int i = 0; i < STAR_COUNT; i++) {
            starX[i] = random.nextDouble() * 600;
            starY[i] = random.nextDouble() * 800;
            speed[i] = 1 + random.nextDouble() * 2;
        }

        GraphicsContext gc = backgroundCanvas.getGraphicsContext2D();

        // Animation loop for background effect
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear background
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, 600, 800);

                // Draw falling stars
                gc.setFill(Color.LIGHTGRAY);
                for (int i = 0; i < STAR_COUNT; i++) {
                    gc.fillOval(starX[i], starY[i], 2, 8);
                    starY[i] += speed[i];
                    if (starY[i] > 800) {
                        starY[i] = 0;
                        starX[i] = random.nextDouble() * 600;
                    }
                }

                // Animate pulsing text
                pulseAngle += 0.02;
                double scale = 1 + 0.1 * Math.sin(pulseAngle);
                welcomeText.setScaleX(scale);
                welcomeText.setScaleY(scale);

                // Keep text centered
                double textWidth = welcomeText.getWidth();
                welcomeText.setLayoutX((600 - textWidth * scale) / 2);
            }
        };

        timer.start();
    }

    /**
     * Starts the actual game when the button is pressed.
     */
    @FXML
    private void startGame() {
        Stage stage = HelloApplication.primaryStage;
        GameCanvas gameCanvas = new GameCanvas(600, 800);

        // Wrap game canvas in layout node to be used as a scene root
        StackPane root = new StackPane(gameCanvas);
        Scene gameScene = new Scene(root, 600, 800);

        stage.setScene(gameScene);
        stage.show();
        gameCanvas.start();
    }
}
