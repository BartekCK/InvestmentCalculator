package pl.calculator.exceptions;

import javafx.scene.control.Alert;

public class MainDialogs {

    protected static Alert createDialogAlert(Alert.AlertType alertType, String messageTitle)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(messageTitle);
        return alert;
    }
}
