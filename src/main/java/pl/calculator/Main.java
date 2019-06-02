package pl.calculator;

import pl.calculator.database.DbConnector;
import pl.calculator.utilies.Path;
import pl.calculator.utilies.ProjectLoader;
import pl.calculator.utilies.TimeThread;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static void commonWindowFeatures(Parent parent, Stage stage, String title) {
        Scene scene = new Scene(parent);
        stage.setScene(ProjectLoader.addSCssToScene(scene));
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

        Main.commonWindowFeatures(ProjectLoader.ParentLoader(Path.PATH_MAIN_WINDOW,Path.CSS_MAIN_SCENE), primaryStage, "Kalkulator Inwestora");
        DbConnector.initDatabase();
        TimeThread timeThread = new TimeThread();
    }

    @Override
    public void stop(){
        DbConnector.closeConnectionSource();
        TimeThread timeThread = new TimeThread();
    }

}