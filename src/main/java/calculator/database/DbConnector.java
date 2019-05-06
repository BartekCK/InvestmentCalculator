package calculator.database;

import calculator.user.User;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbConnector.class);
    private static final String JDBC_DRIVER_HD = "jdbc:sqlite:investment.db";

    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
        //dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null) try {
            connectionSource.close();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);

        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable(){
        try {
            TableUtils.dropTable(connectionSource, User.class,true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
