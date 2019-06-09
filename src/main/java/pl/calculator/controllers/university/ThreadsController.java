package pl.calculator.controllers.university;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.university.thread.AgreeCash;
import pl.university.thread.BankAccount;
import pl.university.thread.BankCrew;

import java.util.LinkedList;
import java.util.List;

public class ThreadsController {

    @FXML
    private TextField threadCountTextField;

    @FXML
    private TextField sayMe;
    
    @FXML
    void createThreads(ActionEvent event) {
        AgreeCash agreeCash = new AgreeCash();
        Thread t1 = new Thread(new BankCrew(agreeCash));
        Thread t2 = new Thread(new BankAccount(agreeCash));
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec dzialania");

        Runnable runnable = () -> {
            for (int i=0;i<10;i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        runnable.run();


    }

}
