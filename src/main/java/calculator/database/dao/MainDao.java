package calculator.database.dao;

import calculator.database.BaseModel;
import calculator.database.DbConnector;
import calculator.exceptions.CalculatorException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class MainDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainDao.class);
    protected final ConnectionSource connectionSource;

    public MainDao() {
        this.connectionSource = DbConnector.getConnectionSource();
    }

    public <T extends BaseModel, I> void creatOrUpdate(BaseModel baseModel) throws CalculatorException {
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.createOrUpdate((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Błąd wpisu/aktualizacji");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> void refresh(BaseModel baseModel) throws CalculatorException {
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.refresh((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Błąd odświeżenia bazy danych");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> void delete(BaseModel baseModel) throws CalculatorException {
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.delete((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Błąd usunięcia");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> void deleteById(Class<T> cls, Integer id) throws CalculatorException {
        try {
            Dao<T, I> dao = getDao(cls);
            dao.deleteById((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Błąd usunięcia");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> T findById(Class<T> cls, Integer id) throws CalculatorException {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForId((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Brak wyników");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> List<T> queryForAll(Class<T> cls) throws CalculatorException {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Brak wyników");
        } finally {
            this.closeDbConnection();
        }
    }


    public <T extends BaseModel, I> Dao<T, I> getDao(Class<T> cls) throws CalculatorException {
        try {
            return DaoManager.createDao(connectionSource, cls);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new CalculatorException("Błąd zamknięcia");
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> QueryBuilder<T, I> getQueryBuilder(Class<T> cls) throws CalculatorException {
        Dao<T, I> dao = getDao(cls);
        return dao.queryBuilder();
    }

    private void closeDbConnection() throws CalculatorException {
        try {
            this.connectionSource.close();
        } catch (IOException e) {
            throw new CalculatorException("Błąd zamknięcia");
        }
    }
}
