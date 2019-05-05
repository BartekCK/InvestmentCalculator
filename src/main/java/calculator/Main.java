package calculator;

import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setScene(new Scene(ProjectLoader.ParentLoader(Path.PATH_MAIN_WINDOW)));
        primaryStage.show();

    }
}
