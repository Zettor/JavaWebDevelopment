package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.dao.AccessoryCategoryDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessoryCategoryDaoImpl extends BaseDaoImpl implements AccessoryCategoryDao {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    private final static String FIND_ALL_REQUEST = "SELECT id,category FROM accessory_categories";
    private final static String FIND_BY_ID_REQUEST = "SELECT id,category FROM accessory_categories WHERE id = ?";
    private final static String DELETE_BY_ID_REQUEST = "DELETE FROM accessory_categories WHERE id=?";
    private final static String DELETE_BY_ENTITY_REQUEST = "DELETE FROM accessory_categories WHERE id=?";
    private final static String CREATE_REQUEST = "INSERT INTO accessory_categories (category) VALUES (?)";
    private final static String UPDATE_REQUEST = "UPDATE accessory_categories SET category=? WHERE id=?";

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<AccessoryCategory> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_ALL_REQUEST);

            ArrayList<AccessoryCategory> categories = new ArrayList<>();

            while (rs.next()) {
                AccessoryCategory accessoryCategory = new AccessoryCategory();
                accessoryCategory.setId(rs.getInt("id"));
                accessoryCategory.setName(rs.getString("category"));
                categories.add(accessoryCategory);
            }
            return categories;
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
    public AccessoryCategory findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_ID_REQUEST);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            AccessoryCategory accessoryCategory = null;
            if (resultSet.next()) {
                accessoryCategory = new AccessoryCategory();
                accessoryCategory.setId(resultSet.getInt("id"));
                accessoryCategory.setName(resultSet.getString("category"));

            }
            return accessoryCategory;
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
    public boolean delete(AccessoryCategory entity) throws DaoException {
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
    public Integer create(AccessoryCategory entity) throws DaoException {
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(CREATE_REQUEST, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getCategory());

            ps.execute();
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no id");
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
    public void update(AccessoryCategory entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_REQUEST);
            ps.setString(1, entity.getCategory());

            ps.setInt(2, entity.getId());

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
