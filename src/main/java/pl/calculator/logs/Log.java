package pl.calculator.logs;

import pl.calculator.controllers.MainWindowController;
import pl.calculator.models.model.User;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log implements Serializable, ThisIsLogInformation {

    private LocalDateTime localDateTime;
    private String message;
    private User user;

    public Log(String message) {
        this.localDateTime = LocalDateTime.now();
        this.message = message;
        this.user = MainWindowController.getUser();
        if(this.user == null)
            this.user = new User("Default");

    }

    @Override
    public String toString() {
        return "Log " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"> "+message+", dokonał użytkownik: "+ user+"\n";
    }
}
