/* Module 5: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/22/25
File:   M05_Assignment_1.java
*/

/* 14.1 (Display images)
Write a program that displays four images in a grid pane, as shown in Figure 14.43a.
Figure 14.43 (a) Exercise 14.1 displays four images.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class M05_Assignment_1 {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between columns
        gridPane.setVgap(10); // Vertical gap between rows

        // Load images (make sure the image files are in your project folder)
        Image image1 = new Image("file:Images/flag1.gif");
        Image image2 = new Image("file:Images/flag2.gif");
        Image image3 = new Image("file:Images/flag6.gif");
        Image image4 = new Image("file:Images/flag7.gif");

        // Create ImageViews
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Optionally, resize images
        imageView1.setFitWidth(100);
        imageView1.setFitHeight(100);
        imageView2.setFitWidth(100);
        imageView2.setFitHeight(100);
        imageView3.setFitWidth(100);
        imageView3.setFitHeight(100);
        imageView4.setFitWidth(100);
        imageView4.setFitHeight(100);

        // Add images to the GridPane
        gridPane.add(imageView1, 0, 0); // column 0, row 0
        gridPane.add(imageView2, 1, 0); // column 1, row 0
        gridPane.add(imageView3, 0, 1); // column 0, row 1
        gridPane.add(imageView4, 1, 1); // column 1, row 1

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 220, 220);
        primaryStage.setTitle("Display Four Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
