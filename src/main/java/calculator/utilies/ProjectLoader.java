package calculator.utilies;

import calculator.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ProjectLoader {

    public static Parent ParentLoader(String fxmlPath,String cssPath)
    {
        try {
            Parent root = FXMLLoader.load(ProjectLoader.class.getResource(fxmlPath));
            if (cssPath!= null)
                root.getStylesheets().addAll(ProjectLoader.class.getResource(Path.CSS_MAIN_SCENE).toExternalForm());
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FXMLLoader FxmlLoaderNewWindow(String fxmlPath, String title)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Main.newWindow(fxmlLoader.load(ProjectLoader.class.getResource(fxmlPath).openStream()),title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxmlLoader;
    }

    public static FXMLLoader FxmlLoader(String fxmlPath)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(ProjectLoader.class.getResource(fxmlPath).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxmlLoader;
    }

    public static Scene addSCssToScene(Scene scene)
    {
        scene.getStylesheets().addAll(ProjectLoader.class.getResource(Path.CSS_MAIN_SCENE).toExternalForm());
        return scene;
    }
}
