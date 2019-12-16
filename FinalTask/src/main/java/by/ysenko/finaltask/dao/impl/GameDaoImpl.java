package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl extends BaseDaoImpl implements GameDao {

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<Game> findAll() throws DaoException {

        Statement st = null;

        ResultSet rs = null;

        try {

            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,name,img_path,genre_id,exclusivity,description,release_date FROM games");

            ArrayList<Game> games = new ArrayList<>();

            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setName(rs.getString("name"));
                game.setImgPath(rs.getString("img_path"));
                Genre genre = new Genre();
                genre.setId(rs.getInt("genre_id"));
                game.setGenre(genre);
                game.setExclusivity(rs.getInt("exclusivity"));
                game.setReleaseDate(rs.getTimestamp("release_date"));
                game.setDescription(rs.getString("description"));
                games.add(game);
            }
            return games;
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
    public Game findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,name,img_path,genre_id,exclusivity,description,release_date FROM games WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Game game = null;
            if (resultSet.next()) {
                game = new Game();
                game.setId(resultSet.getInt("id"));
                game.setName(resultSet.getString("name"));
                game.setImgPath(resultSet.getString("img_path"));
                Genre genre = new Genre();
                genre.setId(resultSet.getInt("genre_id"));
                game.setGenre(genre);
                game.setExclusivity(resultSet.getInt("exclusivity"));
                game.setReleaseDate(resultSet.getTimestamp("release_date"));
                game.setDescription(resultSet.getString("description"));

            }
            return game;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
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
            ps = connection.prepareStatement("DELETE FROM games WHERE id=?");

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
    public boolean delete(Game entity) throws DaoException{
        PreparedStatement ps=null;
        try {
         ps = connection.prepareStatement("DELETE FROM games WHERE id=?");

            ps.setInt(1, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    @Override
    public Integer create(Game entity) throws DaoException{
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("INSERT INTO games (name,img_path,genre_id,exclusivity,release_date,description) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getImgPath());
            ps.setInt(3, entity.getGenre().getId());
            ps.setInt(4, entity.getExclusivity());
            ps.setTimestamp(5, entity.getReleaseDate());
            ps.setString(6, entity.getDescription());
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
    public void update(Game entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE games SET name=?,img_path=?,genre_id=?,exclusivity=?,release_date=?,description=? WHERE id=?");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getImgPath());
            ps.setInt(3, entity.getGenre().getId());
            ps.setInt(4, entity.getExclusivity());
            ps.setTimestamp(5, entity.getReleaseDate());
            ps.setString(6,entity.getDescription());
            ps.setInt(7, entity.getId());

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
