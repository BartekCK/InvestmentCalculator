package pl.calculator.university.struct;

public class ForMap extends God implements Comparable{

    public ForMap(int key, double value) {
        this.key = key;
        this.value = value;
    }

    public int hashCode(){

        return (int) (this.value%hash);
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.value - ((ForMap)o).getValue());
    }

    @Override
    public boolean equals(Object obj) {
        return this.key == ((ForMap)obj).getKey();
    }

    @Override
    public String toString() {
        return "ForMap";
    }
}
