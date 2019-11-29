package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl extends BaseDaoImpl implements GameDao {

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<Game> findAll() throws PersistentException {

        Statement st = null;

        ResultSet rs = null;

        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,name,genre_id,exclusivity,release_date FROM games");

            ArrayList<Game> games = new ArrayList<>();

            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setName(rs.getString("name"));
                Genre genre = new Genre();
                genre.setId(rs.getInt("genre_id"));
                game.setGenre(genre);
                game.setExclusivity(rs.getInt("exclusivity"));
                game.setReleaseDate(rs.getString("release_date"));
                games.add(game);
            }
            return games;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                st.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public Game findEntityById(int id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,name,genre_id,exclusivity,release_date FROM games WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Game game = null;
            if (resultSet.next()) {
                game = new Game();
                game.setId(resultSet.getInt("id"));
                game.setName(resultSet.getString("name"));
                Genre genre = new Genre();
                genre.setId(resultSet.getInt("genre_id"));
                game.setGenre(genre);
                game.setExclusivity(resultSet.getInt("exclusivity"));
                game.setReleaseDate(resultSet.getString("release_date"));

            }
            return game;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM games WHERE id=?");

        ps.setInt(1, id);

        ps.execute();

        return true;

    }

    @Override
    public boolean delete(Game entity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM games WHERE id=?");

        ps.setInt(1, entity.getId());

        ps.execute();

        return true;
    }

    @Override
    public Integer create(Game entity) throws PersistentException {
        PreparedStatement ps = null;
        ResultSet resultSet=null;
        try {
            ps = connection.prepareStatement("INSERT INTO games (name,genre_id,exclusivity,release_date) VALUES (?,?,?,?)");

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getGenre().getId());
            ps.setInt(3, entity.getExclusivity());
            ps.setString(4, entity.getReleaseDate());
            ps.execute();
            resultSet = ps.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {

                throw new PersistentException();
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void update(Game entity) throws PersistentException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE games SET name=?,genre_id=?,exclusivity=?,release_date=?, WHERE id=?");
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getGenre().getId());
            ps.setInt(3, entity.getExclusivity());
            ps.setString(4, entity.getReleaseDate());
            ps.setInt(5, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException | NullPointerException e) {
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
