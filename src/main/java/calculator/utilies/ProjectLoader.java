package calculator.utilies;

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
}
