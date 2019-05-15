package calculator;


import calculator.database.DbConnector;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    Thread thread;

    public static void main(String[] args) {
        launch(args);
    }

    private static void commonWindowFeatures(Parent parent, Stage stage, String title) {
        stage.setScene(new Scene(parent));
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

    public static void newWindow(Parent parent, String title) {
        Stage stage = new Stage();
        commonWindowFeatures(parent, stage, title);
    }

    @Override
    public void start(Stage primaryStage) {

        Main.commonWindowFeatures(ProjectLoader.ParentLoader(Path.PATH_MAIN_WINDOW), primaryStage, "Kalkulator Inwestora");
        DbConnector.initDatabase();
    }

    @Override
    public void stop() throws InterruptedException {
        System.out.println("Stage is closing");

    }


}