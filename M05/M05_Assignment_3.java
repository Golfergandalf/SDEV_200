/* Module 5: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/22/25
File:   M05_Assignment_3.java
*/

/* 16.3 (Traffic lights)
Write a program that simulates a traffic light. The program lets the user select one of three lights: red, yellow, or green. 
When a radio button is selected, the light is turned on. Only one light can be on at a time (see Figure 16.37a). 
No light is on when the program starts.
Figure 16.37 (a) The radio buttons are grouped to let you turn only one light on at a time. 
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class M05_Assignment_3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the circles for red, yellow, and green lights
        Circle redLight = new Circle(30, Color.GRAY);
        Circle yellowLight = new Circle(30, Color.GRAY);
        Circle greenLight = new Circle(30, Color.GRAY);

        // Create the traffic light frame
        Rectangle frame = new Rectangle(120, 300);
        frame.setFill(Color.WHITE);
        frame.setStroke(Color.BLACK);

        // Stack the lights vertically
        VBox lights = new VBox(20, redLight, yellowLight, greenLight);
        lights.setAlignment(Pos.CENTER);

        // Group the lights inside a container
        BorderPane lightBox = new BorderPane();
        lightBox.setCenter(lights);
        lightBox.setTop(frame);
        BorderPane.setAlignment(lights, Pos.CENTER);

        // Create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // Group radio buttons so only one can be selected at a time
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // Put the radio buttons in an HBox
        HBox buttonBox = new HBox(20, rbRed, rbYellow, rbGreen);
        buttonBox.setAlignment(Pos.CENTER);

        // Event handling for each radio button
        rbRed.setOnAction(e -> {
            redLight.setFill(Color.RED);
            yellowLight.setFill(Color.GRAY);
            greenLight.setFill(Color.GRAY);
        });

        rbYellow.setOnAction(e -> {
            redLight.setFill(Color.GRAY);
            yellowLight.setFill(Color.YELLOW);
            greenLight.setFill(Color.GRAY);
        });

        rbGreen.setOnAction(e -> {
            redLight.setFill(Color.GRAY);
            yellowLight.setFill(Color.GRAY);
            greenLight.setFill(Color.LIMEGREEN);
        });

        // Combine everything in a BorderPane layout
        BorderPane pane = new BorderPane();
        pane.setCenter(lights);
        pane.setBottom(buttonBox);
        pane.setStyle("-fx-padding: 20;");

        // Set up the scene and stage
        Scene scene = new Scene(pane, 250, 400);
        primaryStage.setTitle("Traffic Light Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
