package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.AccessoryCategoryDao;
import by.ysenko.finaltask.dao.CityDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends BaseDaoImpl implements CityDao {
    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<City> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,country_id,name FROM cities");

            ArrayList<City> cities = new ArrayList<>();

            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountryId(rs.getInt("country_id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                st.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public List<City> findByCountryId(Integer countryId) throws DaoException {

        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT id,country_id,name FROM cities WHERE country_id=" + countryId);

            ArrayList<City> cities = new ArrayList();
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCountryId(rs.getInt("country_id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
            }
            try {
                st.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public City findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,country_id,name FROM cities WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCountryId(resultSet.getInt("country_id"));
                city.setName(resultSet.getString("name"));
            }
            return city;
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
            ps = connection.prepareStatement("DELETE FROM cities WHERE id=?");

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
    public boolean delete(City entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM cities WHERE id=?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public Integer create(City entity) throws DaoException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("INSERT INTO cities (country_id,name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getCountryId());
            ps.setString(2, entity.getName());
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
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void update(City entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE cities SET country_id=?,name=? WHERE id=?");

            ps.setInt(1, entity.getCountryId());
            ps.setString(2, entity.getName());

            ps.setInt(3, entity.getId());

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

