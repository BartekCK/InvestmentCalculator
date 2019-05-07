package calculator.user;

import calculator.database.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USER")
public class User implements SuperUser,CommonUser, BaseModel
{

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "EMAIL", canBeNull = false, unique = true)
    private String email;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    private String password;

    @DatabaseField(columnName = "NICK", canBeNull = true, unique = true)
    private String nick;

    @DatabaseField(columnName = "NAME", canBeNull = true)
    private String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = true)
    private String surname;

    @DatabaseField(columnName = "IS_SUPER_USER", canBeNull = false)
    private boolean superUser;

    @DatabaseField(columnName = "POLISH_ZLOTY", canBeNull = false)
    private double polishZlotyAccount;

    public User() {
    }

    public User(String email, String password, String nick) {
        this.email = email;
        this.password = password;
        this.nick = nick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", superUser=" + superUser +
                ", polishZlotyAccount=" + polishZlotyAccount +
                '}';
    }
}
