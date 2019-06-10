package pl.calculator.university.struct;

public class God implements Cloneable{

    protected static int id;
    protected int key;
    protected double value;
    protected int hash;

    public God() {
        id++;
        System.out.println("Stowrzylem obiekt nr "+id);
    }

    static {
        id =0;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int hashCode(){

        return this.key%hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
