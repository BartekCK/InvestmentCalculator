package pl.calculator.controllers.university;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.calculator.university.thread.AgreeCash;
import pl.calculator.university.thread.BankAccount;
import pl.calculator.university.thread.BankCrew;

import java.util.ArrayList;
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
            for (int i=0;i<11;i++) {
                if (i==10)
                    break;
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
        for(int i=0;i<51;i++){
            if (i==50)
                continue;
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




        List<Thread> listNew = new ArrayList<>();
        Value value = new Value(0);
        for (int i= 0 ;i<500;i++)
        {
            Proba proba = new Proba(value);
            Thread thread = new Thread(proba);
            listNew.add(thread);
            thread.start();
        }

        System.out.println("Wynik z niesynchornizacji watkow "+value.i);

    }

}

class Value
{
    int i;

    public Value(int i) {
        this.i = i;
    }
}

class Proba extends Thread
{

    Value v;
    public Proba(Value v)
    {
        this.v = v;
    }
    @Override
    public void run() {
        increment();
    }

    public void increment()
    {
        for (int i=0;i<500;i++)
            v.i++;
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