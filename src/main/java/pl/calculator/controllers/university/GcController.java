package pl.calculator.controllers.university;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GcController {


    @FXML
    void turnOn(ActionEvent event) {

        for(long i=0; i<1000000; i++){

            CheckFinalize cf = new CheckFinalize(i);
            if(i%100000==0) System.out.println("Objects created: "+i);
        }
    }

    @FXML
    void turnOf(ActionEvent event) {
        System.gc();
    }



}

class CheckFinalize{
    private long i;

    public CheckFinalize(long i) {
        this.i = i;
    }

    protected void finalize() {
        System.out.println("GarbageCollector został wywołany dla obiektu o numerze: "+i);
    }
}



