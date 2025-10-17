/* Module 8: Final Project - Main
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   M08_Final_Project.java
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private Game game;
    private Label resultLabel;
    private Label scoreLabel;

    @Override
    public void start(Stage stage) {
        // Ask for player name
        TextInputDialog nameDialog = new TextInputDialog("Player");
        nameDialog.setHeaderText("Enter your name:");
        String playerName = nameDialog.showAndWait().orElse("Player");

        game = new Game(playerName);

        // UI elements
        Button rockBtn = new Button("Rock");
        Button paperBtn = new Button("Paper");
        Button scissorsBtn = new Button("Scissors");
        resultLabel = new Label("Make your move!");
        scoreLabel = new Label("Score: 0");

        // Button actions
        rockBtn.setOnAction(e -> updateResult(game.playRound(Move.ROCK)));
        paperBtn.setOnAction(e -> updateResult(game.playRound(Move.PAPER)));
        scissorsBtn.setOnAction(e -> updateResult(game.playRound(Move.SCISSORS)));

        HBox buttons = new HBox(10, rockBtn, paperBtn, scissorsBtn);
        buttons.setStyle("-fx-alignment: center; -fx-padding: 10;");

        VBox layout = new VBox(15, new Label("Rock-Paper-Scissors!"), buttons, resultLabel, scoreLabel);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20;");

        Scene scene = new Scene(layout, 400, 250);
        stage.setTitle("Rock-Paper-Scissors");
        stage.setScene(scene);
        stage.show();
    }

    private void updateResult(String resultText) {
        resultLabel.setText(resultText);
        scoreLabel.setText("Score: " + game.getPlayer().getScore());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
