package pl.calculator.database;

import pl.calculator.currency.types.BandK;
import pl.calculator.currency.types.CaT;
import pl.calculator.models.model.SuperUser;
import pl.calculator.models.model.Transaction;
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

            TableUtils.createTableIfNotExists(connectionSource, SuperUser.class);
            TableUtils.createTableIfNotExists(connectionSource, Transaction.class);
            TableUtils.createTableIfNotExists(connectionSource, BandK.class);
            TableUtils.createTableIfNotExists(connectionSource, CaT.class);

        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable(){
        try {

            TableUtils.dropTable(connectionSource, SuperUser.class,true);
            TableUtils.dropTable(connectionSource, Transaction.class,true);
            TableUtils.dropTable(connectionSource, BandK.class,true);
            TableUtils.dropTable(connectionSource, CaT.class,true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
