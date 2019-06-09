package pl.university.thread;

public class BankAccount extends Thread {
    private int amount;

    private AgreeCash agreeCash;

    public BankAccount(AgreeCash agreeCash)
    {
        this.agreeCash = agreeCash;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Oczekuję na sprawdzenie zdolności kredytowej ");

        while(!agreeCash.bankAgrees){
            synchronized (agreeCash) {
                try{
                    agreeCash.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+" Znam już swoją zdolność kredytową");
    }
}
