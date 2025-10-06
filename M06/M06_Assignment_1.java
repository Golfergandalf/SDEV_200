/* Module 6: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/29/25
File:   M06_Assignment_1.java
*/

/* 34.1 (Access and update a Staff table)
Write a program that views, inserts, and updates staff information stored in a database, as shown in Figure 34.27a. 
The View button displays a record with a specified ID. The Insert button inserts a new record. 
The Update button updates the record for the specified ID. The Staff table is created as follows:

create table Staff (
    id char(9) not null,
    lastName varchar(15),
    firstName varchar(15),
    mi char(1),
    address varchar(20),
    city varchar(20),
    state char(2),
    telephone char(10),
    email varchar(40),
    primary key (id)
);
*/

// Imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class M06_Assignment_1 extends Application {

    // Database connection info
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Staff";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // Text fields for staff information
    private TextField tfID = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMI = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    // Database connection
    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        // Connect to database
        connectToDB();

        // Create a GridPane for layout
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setHgap(5);
        pane.setVgap(5);

        // Add labels and text fields
        pane.add(new Label("ID:"), 0, 0);
        pane.add(tfID, 1, 0);

        pane.add(new Label("Last Name:"), 0, 1);
        pane.add(tfLastName, 1, 1);

        pane.add(new Label("First Name:"), 0, 2);
        pane.add(tfFirstName, 1, 2);

        pane.add(new Label("MI:"), 0, 3);
        pane.add(tfMI, 1, 3);

        pane.add(new Label("Address:"), 0, 4);
        pane.add(tfAddress, 1, 4);

        pane.add(new Label("City:"), 0, 5);
        pane.add(tfCity, 1, 5);

        pane.add(new Label("State:"), 0, 6);
        pane.add(tfState, 1, 6);

        pane.add(new Label("Telephone:"), 0, 7);
        pane.add(tfTelephone, 1, 7);

        pane.add(new Label("Email:"), 0, 8);
        pane.add(tfEmail, 1, 8);

        // Buttons
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");

        // Button bar
        pane.add(new Label(""), 0, 9);
        pane.add(btView, 0, 10);
        pane.add(btInsert, 1, 10);
        pane.add(btUpdate, 2, 10);

        // Align center
        pane.setAlignment(Pos.CENTER);

        // Button actions
        btView.setOnAction(e -> viewRecord());
        btInsert.setOnAction(e -> insertRecord());
        btUpdate.setOnAction(e -> updateRecord());

        // Show scene
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Staff Database Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Connect to database */
    private void connectToDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully.");
        } catch (SQLException ex) {
            showAlert("Database Connection Error", ex.getMessage());
        }
    }

    /** View a record by ID */
    private void viewRecord() {
        String query = "SELECT * FROM Staff WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tfID.getText());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tfLastName.setText(rs.getString("lastName"));
                tfFirstName.setText(rs.getString("firstName"));
                tfMI.setText(rs.getString("mi"));
                tfAddress.setText(rs.getString("address"));
                tfCity.setText(rs.getString("city"));
                tfState.setText(rs.getString("state"));
                tfTelephone.setText(rs.getString("telephone"));
                tfEmail.setText(rs.getString("email"));
            } else {
                showAlert("No Record Found", "No staff found with ID " + tfID.getText());
                clearFields();
            }
        } catch (SQLException ex) {
            showAlert("Error Viewing Record", ex.getMessage());
        }
    }

    /** Insert a new record */
    private void insertRecord() {
        String query = "INSERT INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tfID.getText());
            stmt.setString(2, tfLastName.getText());
            stmt.setString(3, tfFirstName.getText());
            stmt.setString(4, tfMI.getText());
            stmt.setString(5, tfAddress.getText());
            stmt.setString(6, tfCity.getText());
            stmt.setString(7, tfState.getText());
            stmt.setString(8, tfTelephone.getText());
            stmt.setString(9, tfEmail.getText());
            stmt.executeUpdate();
            showAlert("Success", "Record inserted successfully!");
        } catch (SQLException ex) {
            showAlert("Error Inserting Record", ex.getMessage());
        }
    }

    /** Update a record by ID */
    private void updateRecord() {
        String query = """
            UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, 
            state=?, telephone=?, email=? WHERE id=?
            """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tfLastName.getText());
            stmt.setString(2, tfFirstName.getText());
            stmt.setString(3, tfMI.getText());
            stmt.setString(4, tfAddress.getText());
            stmt.setString(5, tfCity.getText());
            stmt.setString(6, tfState.getText());
            stmt.setString(7, tfTelephone.getText());
            stmt.setString(8, tfEmail.getText());
            stmt.setString(9, tfID.getText());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                showAlert("Success", "Record updated successfully!");
            else
                showAlert("Not Found", "No staff found with that ID.");
        } catch (SQLException ex) {
            showAlert("Error Updating Record", ex.getMessage());
        }
    }

    /** Utility: clear fields */
    private void clearFields() {
        tfLastName.clear();
        tfFirstName.clear();
        tfMI.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
        tfEmail.clear();
    }

    /** Utility: show alert box */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
