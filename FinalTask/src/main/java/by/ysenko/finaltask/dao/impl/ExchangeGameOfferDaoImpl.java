package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.ExchangeGameOffer;
import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.ExchangeGameOfferDao;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExchangeGameOfferDaoImpl extends BaseDaoImpl implements ExchangeGameOfferDao {


    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<ExchangeGameOffer> findAll() throws PersistentException {

        Statement st = null;

        ResultSet rs = null;

        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,game_id,user_id,description,createdAt,closedAt,status FROM exchange_game_offers");

            ArrayList<ExchangeGameOffer> offers = new ArrayList<>();

            while (rs.next()) {
                ExchangeGameOffer offer = new ExchangeGameOffer();
                offer.setId(rs.getInt("id"));
                Game game = new Game();
                game.setId(rs.getInt("game_id"));
                offer.setGame(game);
                User user = new User();
                user.setId(rs.getInt("user_id"));
                offer.setUser(user);
                offer.setDescription(rs.getString("description"));
                offer.setCreateDate(rs.getTimestamp("createdAt"));
                offer.setCreateDate(rs.getTimestamp("closedAt"));
                offers.add(offer);
            }
            return offers;
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
    public ExchangeGameOffer findEntityById(int id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,game_id,user_id,description,createdAt,closedAt,status FROM exchange_game_offers WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            ExchangeGameOffer offer = null;
            if (resultSet.next()) {
                offer = new ExchangeGameOffer();
                offer.setId(resultSet.getInt("id"));
                Game game = new Game();
                game.setId(resultSet.getInt("game_id"));
                offer.setGame(game);
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                offer.setUser(user);
                offer.setDescription(resultSet.getString("description"));
                offer.setCreateDate(resultSet.getTimestamp("createdAt"));
                offer.setCreateDate(resultSet.getTimestamp("closedAt"));

            }
            return offer;
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
        PreparedStatement ps = connection.prepareStatement("DELETE FROM exchange_game_offers WHERE id=?");

        ps.setInt(1, id);

        ps.execute();

        return true;

    }

    @Override
    public boolean delete(ExchangeGameOffer entity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM exchange_game_offers WHERE id=?");

        ps.setInt(1, entity.getId());

        ps.execute();

        return true;
    }

    @Override
    public Integer create(ExchangeGameOffer entity) throws PersistentException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("INSERT INTO exchange_game_offers (game_id,user_id,description,createdAt,closedAt,status) VALUES (?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, entity.getGame().getId());
            ps.setInt(2, entity.getUser().getId());
            ps.setString(3, entity.getDescription());
            ps.setTimestamp(4, entity.getCreateDate());
            ps.setTimestamp(5, entity.getCloseDate());
            ps.setInt(6, entity.getStatus());
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
    public void update(ExchangeGameOffer entity) throws PersistentException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE exchange_game_offers SET game_id=?,user_id=? ,description=?,createdAt=?,closedAt=?,status=? WHERE id=?");
            ps.setInt(1, entity.getGame().getId());
            ps.setInt(2, entity.getUser().getId());
            ps.setString(3, entity.getDescription());
            ps.setTimestamp(4, entity.getCreateDate());
            ps.setTimestamp(5, entity.getCloseDate());
            ps.setInt(6, entity.getStatus());
            ps.setInt(7, entity.getId());

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
