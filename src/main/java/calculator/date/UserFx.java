package calculator.date;

import calculator.user.User;
import javafx.beans.property.*;

public class UserFx {


    private IntegerProperty id = new SimpleIntegerProperty();


    private StringProperty email = new SimpleStringProperty();


    private StringProperty nick= new SimpleStringProperty();


    private StringProperty name= new SimpleStringProperty();


    private StringProperty surname= new SimpleStringProperty();


    private DoubleProperty polishZlotyAccount = new SimpleDoubleProperty();


    private DoubleProperty valueBandK= new SimpleDoubleProperty();


    private DoubleProperty valueCaT= new SimpleDoubleProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }


    public String getNick() {
        return nick.get();
    }

    public StringProperty nickProperty() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick.set(nick);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public double getPolishZlotyAccount() {
        return polishZlotyAccount.get();
    }

    public DoubleProperty polishZlotyAccountProperty() {
        return polishZlotyAccount;
    }

    public void setPolishZlotyAccount(double polishZlotyAccount) {
        this.polishZlotyAccount.set(polishZlotyAccount);
    }

    public double getValueBandK() {
        return valueBandK.get();
    }

    public DoubleProperty valueBandKProperty() {
        return valueBandK;
    }

    public void setValueBandK(double valueBandK) {
        this.valueBandK.set(valueBandK);
    }

    public double getValueCaT() {
        return valueCaT.get();
    }

    public DoubleProperty valueCaTProperty() {
        return valueCaT;
    }

    public void setValueCaT(double valueCaT) {
        this.valueCaT.set(valueCaT);
    }


}
