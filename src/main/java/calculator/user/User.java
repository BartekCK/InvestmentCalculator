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

    @DatabaseField(columnName = "PHONE", canBeNull = true)
    private String phone;

    public User() {
    }

    public User(String email, String password, String nick) {
        this.email = email;
        this.password = password;
        this.nick = nick;
    }
}
