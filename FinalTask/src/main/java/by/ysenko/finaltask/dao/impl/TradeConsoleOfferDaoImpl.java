package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.TradeConsoleOffer;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.TradeConsoleOfferDao;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TradeConsoleOfferDaoImpl extends BaseDaoImpl implements TradeConsoleOfferDao {

    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<TradeConsoleOffer> findAll() throws PersistentException {

        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,user_id,name,cost,currency,description,createdAt,closedAt,status FROM trade_console_offers");

            ArrayList<TradeConsoleOffer> offers = new ArrayList<>();

            while (rs.next()) {
                TradeConsoleOffer offer = new TradeConsoleOffer();
                offer.setId(rs.getInt("id"));
                User user = new User();
                user.setId(rs.getInt("user_id"));
                offer.setUser(user);
                offer.setName(rs.getString("name"));
                offer.setCost(rs.getDouble("cost"));
                offer.setCurrency(rs.getString("currency"));
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
    public TradeConsoleOffer findEntityById(int id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,user_id,name,cost,currency,description,createdAt,closedAt,status FROM trade_console_offers WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            TradeConsoleOffer offer = null;
            if (resultSet.next()) {
                offer = new TradeConsoleOffer();
                offer.setId(resultSet.getInt("id"));
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                offer.setUser(user);
                offer.setName(resultSet.getString("name"));
                offer.setName(resultSet.getString("cost"));
                offer.setCurrency(resultSet.getString("currency"));
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
        PreparedStatement ps = connection.prepareStatement("DELETE FROM trade_console_offers WHERE id=?");

        ps.setInt(1, id);

        ps.execute();

        return true;

    }

    @Override
    public boolean delete(TradeConsoleOffer entity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM trade_console_offers WHERE id=?");

        ps.setInt(1, entity.getId());

        ps.execute();

        return true;
    }

    @Override
    public Integer create(TradeConsoleOffer entity) throws PersistentException {
        PreparedStatement ps = null;
        ResultSet resultSet=null;
        try {
            ps = connection.prepareStatement("INSERT INTO trade_console_offers (user_id,name,cost,currency,description,createdAt,closedAt,status) VALUES (?,?,?,?,?,?,?,?)");


            ps.setInt(1, entity.getUser().getId());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getCost());
            ps.setString(4, entity.getCurrency());
            ps.setString(5, entity.getDescription());
            ps.setTimestamp(6, entity.getCreateDate());
            ps.setTimestamp(7, entity.getCloseDate());
            ps.setInt(8, entity.getStatus());
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
    public void update(TradeConsoleOffer entity) throws PersistentException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE trade_console_offers SET user_id=?,name=?,cost=?,currency=?,description=?,createdAt=?,closedAt=?,status=? WHERE id=?");

            ps.setInt(1, entity.getUser().getId());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getCost());
            ps.setString(4, entity.getCurrency());
            ps.setString(5, entity.getDescription());
            ps.setTimestamp(6, entity.getCreateDate());
            ps.setTimestamp(7, entity.getCloseDate());
            ps.setInt(8, entity.getStatus());
            ps.setInt(9, entity.getId());

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
