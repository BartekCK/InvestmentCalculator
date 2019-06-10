package pl.calculator.university.struct;

public class ForMap extends God implements Comparable{

//    private int key;
//    private double value;




    public ForMap(int key, double value) {
        this.key = key;
        this.value = value;
    }



    @Override
    public int compareTo(Object o) {
        return (int) (this.value - ((ForMap)o).getValue());
    }

    @Override
    public boolean equals(Object obj) {
        return this.key == ((ForMap)obj).getKey();
    }
}
