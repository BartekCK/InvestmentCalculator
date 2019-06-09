package pl.university.thread;

public class BankCrew implements Runnable {
    private AgreeCash agreeCash;

    public BankCrew(AgreeCash agreeCash) {
        this.agreeCash = agreeCash;
    }

    @Override
    public void run() {
        agreeCash.bankAgrees = false;
        System.out.println("Sprawdzamy zdolność kredytową");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        agreeCash.bankAgrees = true;
        System.out.println("Koniec sprawdzania, nasza ocena to"+agreeCash.bankAgrees);
        synchronized (agreeCash) {
            agreeCash.notify();

        }
    }

}
