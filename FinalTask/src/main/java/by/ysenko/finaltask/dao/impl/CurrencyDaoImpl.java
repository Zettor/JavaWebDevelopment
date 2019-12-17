package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.AccessoryCategoryDao;
import by.ysenko.finaltask.dao.CurrencyDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoImpl extends BaseDaoImpl implements CurrencyDao {

    private final static String FIND_ALL_REQUEST="SELECT id,name FROM currencies";
    private final static String FIND_BY_ID_REQUEST="SELECT id,name FROM currencies WHERE id = ?";
    private final static String DELETE_BY_ID_REQUEST="DELETE FROM currencies WHERE id=?";
    private final static String DELETE_BY_ENTITY_REQUEST="DELETE FROM currencies WHERE id=?";
    private final static String CREATE_REQUEST= "INSERT INTO currencies (name) VALUES (?)";
    private final static String UPDATE_REQUEST= "UPDATE currencies SET name=? WHERE id=?";

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<Currency> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_ALL_REQUEST);

            ArrayList<Currency> currencies = new ArrayList<>();

            while (rs.next()) {
                Currency currency = new Currency();
                currency.setId(rs.getInt("id"));
                currency.setName(rs.getString("name"));
                currencies.add(currency);
            }
            return currencies;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException  e) {
            }
            try {
                st.close();
            } catch (SQLException  e) {
            }
        }
    }

    @Override
    public Currency findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_ID_REQUEST);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Currency currency = null;
            if (resultSet.next()) {
                currency = new Currency();
                currency.setId(resultSet.getInt("id"));
                currency.setName(resultSet.getString("name"));
            }
            return currency;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException  e) {
            }
            try {
                statement.close();
            } catch (SQLException  e) {
            }
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE_BY_ID_REQUEST);

            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            try {
                throw new DaoException(e);
            } finally {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public boolean delete(Currency entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE_BY_ENTITY_REQUEST);
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e) {
          throw new DaoException(e);
        }
        return true;
    }

    @Override
    public Integer create(Currency entity) throws DaoException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(CREATE_REQUEST, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());

            ps.execute();
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {

                throw new DaoException();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override

    public void update(Currency entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_REQUEST);
            ps.setString(1, entity.getName());

            ps.setInt(2, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException  e) {
            }
        }
    }

    @Override
    public void close(Statement st) {

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
        }

    }
}


