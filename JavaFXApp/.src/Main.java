import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello, JavaFX from VS Code!");
        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);
        stage.setTitle("My First JavaFX App");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
