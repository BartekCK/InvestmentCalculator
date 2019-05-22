package calculator.exceptions;

import javafx.scene.control.Alert;

public class Dialogs {
    public static void errorDialog(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Uwaga");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
