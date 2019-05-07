package calculator.user;

import calculator.database.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class User implements BaseModel
{

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField(columnName = "EMAIL", canBeNull = false, unique = true)
    protected String email;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    protected String password;

    @DatabaseField(columnName = "NICK", canBeNull = true, unique = true)
    protected String nick;

    @DatabaseField(columnName = "NAME", canBeNull = true)
    protected String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = true)
    protected String surname;

    @DatabaseField(columnName = "IS_SUPER_USER", canBeNull = false)
    protected boolean superUser;

    @DatabaseField(columnName = "POLISH_ZLOTY", canBeNull = false)
    protected double polishZlotyAccount;

    public User() {
    }

    public User(String email, String password, String nick) {
        this.email = email;
        this.password = password;
        this.nick = nick;
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
        this.polishZlotyAccount = polishZlotyAccount;
    }
}
