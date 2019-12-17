package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl extends BaseDaoImpl implements GenreDao {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    private final static String FIND_ALL_REQUEST = "SELECT id,name FROM genres";
    private final static String FIND_BY_ID_REQUEST = "SELECT id,name FROM genres WHERE id = ?";
    private final static String DELETE_BY_ID_REQUEST = "DELETE FROM genres WHERE id=?";
    private final static String DELETE_BY_ENTITY_REQUEST = "DELETE FROM genres WHERE id=?";
    private final static String CREATE_REQUEST = "INSERT INTO genres (name) VALUES (?)";
    private final static String UPDATE_REQUEST = "UPDATE genres SET name=? WHERE id=?";

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<Genre> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_ALL_REQUEST);

            ArrayList<Genre> genres = new ArrayList<>();

            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }
            return genres;
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
    public Genre findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_ID_REQUEST);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Genre genre = null;
            if (resultSet.next()) {
                genre = new Genre();
                genre.setId(resultSet.getInt("id"));
                genre.setName(resultSet.getString("name"));
            }
            return genre;
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
    public boolean delete(Genre entity) throws DaoException {
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
    public Integer create(Genre entity) throws DaoException {
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
                logger.error("There is no id");
                throw new DaoException();
            }
        } catch (SQLException e) {
            logger.error(entity);
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

    public void update(Genre entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_REQUEST);
            ps.setString(1, entity.getName());

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
