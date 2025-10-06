/* Module 5: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/22/25
File:   M05_Assignment_2.java
*/

/* 15.7 (Change color using a mouse)
Write a program that displays the color of a circle as black when the mouse button is pressed, and as white when the mouse button is released.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class M05_Assignment_2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a circle
        Circle circle = new Circle(150, 150, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Create a pane and add the circle
        Pane pane = new Pane(circle);

        // Handle mouse pressed: turn circle black
        circle.setOnMousePressed((MouseEvent e) -> {
            circle.setFill(Color.BLACK);
        });

        // Handle mouse released: turn circle white
        circle.setOnMouseReleased((MouseEvent e) -> {
            circle.setFill(Color.WHITE);
        });

        // Set up the scene and stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Change Circle Color with Mouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
