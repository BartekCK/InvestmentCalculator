package calculator.utilies;

import calculator.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ProjectLoader {

    public static Parent ParentLoader(String fxmlPath)
    {
        try {
            return FXMLLoader.load(ProjectLoader.class.getResource(fxmlPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FXMLLoader FxmlLoader(String fxmlPath, String title)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Main.newWindow(fxmlLoader.load(ProjectLoader.class.getResource(fxmlPath).openStream()),title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxmlLoader;
    }
}
