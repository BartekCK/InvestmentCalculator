package pl.calculator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pl.calculator.logs.SaveLogs;
import pl.calculator.logs.ThisIsLogInformation;

public class LogController {

    @FXML
    private TextArea textArea;


    @FXML
    private void initialize()
    {
        String message= null;
        for (ThisIsLogInformation log : SaveLogs.getListLog()) {
            if (message == null)
                message = log.toString();
            else
                message += log.toString();
        }
        textArea.setText(message);

    }


}
