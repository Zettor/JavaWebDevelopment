package by.ysenko.finaltask.dao.impl;


import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.dao.CountryDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends BaseDaoImpl implements CountryDao {

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }


    @Override
    public List<Country> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,name FROM countries");

            ArrayList<Country> countries = new ArrayList<>();

            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                countries.add(country);
            }
            return countries;
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
    public Country findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,name FROM countries WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Country country = null;
            if (resultSet.next()) {
                country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
            }
            return country;
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
        PreparedStatement ps=null;
        try{
            ps = connection.prepareStatement("DELETE FROM countries WHERE id=?");

            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            try {
                throw new DaoException(e);
            }
            finally {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public boolean delete(Country entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM countries WHERE id=?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e) {
        throw new DaoException(e);
        }

        return true;
    }

    @Override
    public Integer create(Country entity) throws DaoException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("INSERT INTO countries (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

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
            } catch (SQLException  e) {
            }
        }
    }

    @Override
    public void update(Country entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE countries SET name=? WHERE id=?");
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
