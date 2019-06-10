package pl.calculator.controllers.university;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.calculator.university.thread.AgreeCash;
import pl.calculator.university.thread.BankAccount;
import pl.calculator.university.thread.BankCrew;

import java.util.LinkedList;
import java.util.List;

public class ThreadsController {

    @FXML
    private TextField threadCountTextField;

    @FXML
    private TextField sayMe;


    @FXML
    void createThreads() {
        double temp = Double.parseDouble(threadCountTextField.getText());
        AgreeCash agreeCash = new AgreeCash();
        agreeCash.setValue(temp);

        Thread t1 = new Thread(new BankCrew(agreeCash));
        Thread t2 = new Thread(new BankAccount(agreeCash));
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sayMe.setText(String.valueOf(agreeCash.isBankAgreesAboutCredit()));



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


        List<Thread> threads = new LinkedList();
        ThreadSyn threadSyn = new ThreadSyn();
        for(int i=0;i<50;i++){
            Incrementer inc = new Incrementer(threadSyn);
            Thread tt = new Thread(inc);
            threads.add(tt);
            tt.start();
        }

        for(Thread t : threads){
            try {
                t.join();
            }
            catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        System.out.println("Wartość wynosi: "+threadSyn.getValue());

    }

}

class ThreadSyn {
    private int value = 0;


    public synchronized void increment() {


        value++;

    }

    public int getValue() {
        return value;
    }
}

class Incrementer implements Runnable {

    private final ThreadSyn threadSyn;

    Incrementer(ThreadSyn aAccount) {
        this.threadSyn = aAccount;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            threadSyn.increment();
        }
    }

}