package calculator.models.model;


import calculator.calculate.MyMath;
import calculator.currency.manage.Money;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.database.BaseModel;
import calculator.database.tasks.CurrencyTask;
import com.j256.ormlite.field.DatabaseField;
import javafx.collections.FXCollections;


public class User implements BaseModel, Cloneable, Comparable
{

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(columnName = "EMAIL", canBeNull = false, unique = true)
    String email;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    String password;

    @DatabaseField(columnName = "NICK", canBeNull = true, unique = true)
    String nick;

    @DatabaseField(columnName = "NAME", canBeNull = true)
    String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = true)
    String surname;

    @DatabaseField(columnName = "IS_SUPER_USER", canBeNull = false)
    boolean superUser;

    @DatabaseField(columnName = "POLISH_ZLOTY", canBeNull = false)
    double polishZlotyAccount;

    @DatabaseField(columnName = "B_AND_K", canBeNull = false)
    double valueBandK;

    @DatabaseField(columnName = "C_A_T", canBeNull = false)
    double valueCaT;

    public User() {
    }

    public User(String email, String password, String nick) {
        this.email = email;
        this.password = password;
        this.nick = nick;
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

    @Override
    public boolean equals(Object obj) {

        return this.id == ((User)obj).getId();
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(calculateAllWealth((User) o),calculateAllWealth(this));
    }

    protected double calculateAllWealth(User user)
    {
        CurrencyTask currencyTask= new CurrencyTask();
        Money[] tempList = currencyTask.init(FXCollections.observableArrayList(new CaT(), new BandK())).toArray(new Money[2]);

        double tempMoneyUser = user.getPolishZlotyAccount();
        tempMoneyUser+=user.getValueCaT()* tempList[0].getMoneyRate();
        tempMoneyUser+=user.getValueBandK() * tempList[1].getMoneyRate();

        return MyMath.roundTwo(tempMoneyUser);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isSuperUser() {
        return superUser;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }

    public double getPolishZlotyAccount() {
        return polishZlotyAccount;
    }

    public void setPolishZlotyAccount(double polishZlotyAccount) {
        this.polishZlotyAccount = MyMath.roundTwo(polishZlotyAccount);
    }

    public double getValueBandK() {
        return valueBandK;
    }

    public void setValueBandK(double valueBandK) {
        this.valueBandK = MyMath.roundTwo(valueBandK);
    }

    public double getValueCaT() {
        return valueCaT;
    }

    public void setValueCaT(double valueCaT) {
        this.valueCaT = MyMath.roundTwo(valueCaT);
    }

}
