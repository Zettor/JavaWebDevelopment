package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.TradeConsoleOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl extends BaseDaoImpl implements GenreDao {

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<Genre> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,name FROM genres");

            ArrayList<Genre> genres = new ArrayList<>();

            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }
            return genres;
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
    public Genre findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,name FROM genres WHERE id = ?");
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
         ps = connection.prepareStatement("DELETE FROM genres WHERE id=?");

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

    }}

    @Override
    public boolean delete(Genre entity) throws DaoException {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("DELETE FROM genres WHERE id=?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return true;
    }

    @Override
    public Integer create(Genre entity) throws DaoException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("INSERT INTO genres (name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);

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
            } catch (SQLException | NullPointerException e) {
            }
        }
    }
    @Override

    public void update(Genre entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE genres SET name=? WHERE id=?");
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
