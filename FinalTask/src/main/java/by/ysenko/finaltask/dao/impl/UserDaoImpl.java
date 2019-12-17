package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    private final static String FIND_ALL_REQUEST = "SELECT id,login,password,salt,email,phone,country_id ,city_id,createAt,status,role FROM users";
    private final static String FIND_BY_ID_REQUEST = "SELECT id,login,password,salt,email,phone,country_id,city_id,createAt,status,role FROM users WHERE id = ?";
    private final static String FIND_BY_LOGIN_REQUEST = "SELECT id,login,password,salt,email,phone,country_id,city_id,createAt,status,role FROM users WHERE login = ? ";
    private final static String FIND_BY_EMAIL_REQUEST = "SELECT id,login,password,salt,email,phone,country_id,city_id,createAt,status,role FROM users WHERE email = ? ";
    private final static String DELETE_BY_ID_REQUEST = "DELETE FROM users WHERE id=?";
    private final static String DELETE_BY_ENTITY_REQUEST = "DELETE FROM users WHERE id=?";
    private final static String CREATE_REQUEST = "INSERT INTO users (login,password,salt,email,phone,createAt,status,role) VALUES (?,?,?,?,?,?,?,?)";
    private final static String UPDATE_REQUEST = "UPDATE users SET login=?,password=?,salt=?,email=?,phone=?,country_id=?,city_id=?,createAt=?,status=?,role=? WHERE id=?";


    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<User> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_ALL_REQUEST);

            ArrayList<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setSalt(rs.getString("salt"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                Country country = new Country();
                country.setId(rs.getInt("country_id"));
                user.setCountry(country);
                City city = new City();
                city.setId(rs.getInt("city_id"));
                user.setCity(city);
                user.setCreateDate(rs.getTimestamp("createAt"));
                user.setStatus(rs.getInt("status"));
                user.setRole(rs.getInt("role"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            try {
                st.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public User findEntityById(int id) throws DaoException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_ID_REQUEST);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setSalt(resultSet.getString("salt"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                user.setCountry(country);
                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                user.setCity(city);
                user.setCreateDate(resultSet.getTimestamp("createAt"));
                user.setStatus(resultSet.getInt("status"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public User findUserByLogin(String login) throws DaoException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_LOGIN_REQUEST);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setSalt(resultSet.getString("salt"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                user.setCountry(country);
                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                user.setCity(city);
                user.setCreateDate(resultSet.getTimestamp("createAt"));
                user.setStatus(resultSet.getInt("status"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public User findUserByEmail(String email) throws DaoException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_EMAIL_REQUEST);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setSalt(resultSet.getString("salt"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                user.setCountry(country);
                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                user.setCity(city);
                user.setCreateDate(resultSet.getTimestamp("createAt"));
                user.setStatus(resultSet.getInt("status"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
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
                logger.error(e);
                throw new DaoException(e);
            } finally {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    logger.error(e);
                }
            }

        }

    }

    @Override
    public boolean delete(User entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(DELETE_BY_ENTITY_REQUEST);

            ps.setInt(1, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public Integer create(User entity) throws DaoException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(CREATE_REQUEST, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getSalt());
            ps.setString(4, entity.getEmail());
            ps.setString(5, entity.getPhone());
            ps.setTimestamp(6, entity.getCreateDate());
            ps.setInt(7, entity.getStatus());
            ps.setInt(8, entity.getRole());

            ps.execute();
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {

                throw new DaoException();
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public void update(User entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_REQUEST);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getSalt());
            ps.setString(4, entity.getEmail());
            ps.setString(5, entity.getPhone());
            ps.setInt(6, entity.getCountry().getId());
            ps.setInt(7, entity.getCity().getId());
            ps.setTimestamp(8, entity.getCreateDate());
            ps.setInt(9, entity.getStatus());
            ps.setInt(10, entity.getRole());
            ps.setInt(11, entity.getId());
            ps.execute();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                logger.error(e);
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
            logger.error(e);
        }

    }
}
