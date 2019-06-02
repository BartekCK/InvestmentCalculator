package pl.calculator.exceptions;

import javafx.scene.control.Alert;

public class Dialogs {


    private static Alert createDialogAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Uwaga");
        return alert;
    }

    public static void errorDialog(String message)
    {
        Alert alert = createDialogAlert();
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static void errorDialog(String message1, String message2)
    {
        Alert alert = createDialogAlert();
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
