package calculator.utilies;

import calculator.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ProjectLoader {

    public static Parent ParentLoader(String fxmlPath,String cssPath)
    {
        try {
            Parent root = FXMLLoader.load(ProjectLoader.class.getResource(fxmlPath));
            if (cssPath!= null)
                root.getStylesheets().add(cssPath);
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
}
