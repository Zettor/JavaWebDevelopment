package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.TradeGameOfferDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TradeGameOfferDaoImpl extends BaseDaoImpl implements TradeGameOfferDao {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    private final static String FIND_ALL_REQUEST="SELECT id,game_id,user_id,cost,currency_id,description,createdAt,closedAt,status FROM trade_game_offers";
    private final static String FIND_LAST_REQUEST="SELECT id,game_id,user_id,cost,currency_id,description,createdAt,closedAt,status FROM trade_game_offers LIMIT 5";
    private final static String FIND_BY_ID_REQUEST="SELECT id,game_id,user_id,cost,currency_id,description,createdAt,closedAt,status FROM trade_game_offers WHERE id = ?";
    private final static String DELETE_BY_ID_REQUEST="DELETE FROM trade_game_offers WHERE id=?";
    private final static String DELETE_BY_ENTITY_REQUEST="DELETE FROM trade_game_offers WHERE id=?";
    private final static String CREATE_REQUEST= "INSERT INTO trade_game_offers (game_id,user_id,cost,currency_id ,description,createdAt,closedAt,status) VALUES (?,?,?,?,?,?,?,?)";
    private final static String UPDATE_REQUEST= "UPDATE trade_game_offers SET game_id=?,user_id=?,cost=?,currency_id=?,description=?,createdAt=?,closedAt=?,status=? WHERE id=?";


    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<TradeGameOffer> findAll() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_ALL_REQUEST);

            ArrayList<TradeGameOffer> offers = new ArrayList<>();

            while (rs.next()) {
                TradeGameOffer offer = new TradeGameOffer();
                offer.setId(rs.getInt("id"));
                Game game = new Game();
                game.setId(rs.getInt("game_id"));
                offer.setGame(game);
                User user = new User();
                user.setId(rs.getInt("user_id"));
                offer.setUser(user);
                offer.setCost(rs.getDouble("cost"));
                Currency currency = new Currency();
                currency.setId(rs.getInt("currency_id"));
                offer.setCurrency(currency);
                offer.setDescription(rs.getString("description"));
                offer.setCreateDate(rs.getTimestamp("createdAt"));
                offer.setCloseDate(rs.getTimestamp("closedAt"));
                offers.add(offer);
            }
            return offers;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException  e) {
                logger.error(e);
            }
            try {
                st.close();
            } catch (SQLException  e) {
                logger.error(e);
            }
        }
    }

    @Override
    public List<TradeGameOffer> findLastOffers() throws DaoException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery(FIND_LAST_REQUEST);

            ArrayList<TradeGameOffer> offers = new ArrayList<>();

            while (rs.next()) {
                TradeGameOffer offer = new TradeGameOffer();
                offer.setId(rs.getInt("id"));
                Game game = new Game();
                game.setId(rs.getInt("game_id"));
                offer.setGame(game);
                User user = new User();
                user.setId(rs.getInt("user_id"));
                offer.setUser(user);
                offer.setCost(rs.getDouble("cost"));
                Currency currency = new Currency();
                currency.setId(rs.getInt("currency_id"));
                offer.setCurrency(currency);
                offer.setDescription(rs.getString("description"));
                offer.setCreateDate(rs.getTimestamp("createdAt"));
                offer.setCloseDate(rs.getTimestamp("closedAt"));
                offers.add(offer);
            }
            return offers;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException  e) {
                logger.error(e);
            }
            try {
                st.close();
            } catch (SQLException  e) {
                logger.error(e);
            }
        }
    }

    @Override
    public TradeGameOffer findEntityById(int id) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(FIND_BY_ID_REQUEST);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            TradeGameOffer offer = null;
            if (resultSet.next()) {
                offer = new TradeGameOffer();
                offer.setId(resultSet.getInt("id"));
                Game game = new Game();
                game.setId(resultSet.getInt("game_id"));
                offer.setGame(game);
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                offer.setUser(user);
                offer.setCost(resultSet.getDouble("cost"));
                Currency currency=new Currency();
                currency.setId(resultSet.getInt("currency_id"));
                offer.setCurrency(currency);
                offer.setDescription(resultSet.getString("description"));
                offer.setCreateDate(resultSet.getTimestamp("createdAt"));
                offer.setCreateDate(resultSet.getTimestamp("closedAt"));
            }
            return offer;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException  e) {
                logger.error(e);
            }
            try {
                statement.close();
            } catch (SQLException  e) {
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
    public boolean delete(TradeGameOffer entity) throws DaoException {
        PreparedStatement ps = null;
try {
     ps = connection.prepareStatement(DELETE_BY_ENTITY_REQUEST);

    ps.setInt(1, entity.getId());

    ps.execute();
} catch (SQLException e) {
    throw new DaoException(e);
}
        return true;
    }

    @Override
    public Integer create(TradeGameOffer entity) throws DaoException  {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(CREATE_REQUEST,Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getGame().getId());
            ps.setInt(2, entity.getUser().getId());
            ps.setDouble(3, entity.getCost());
            ps.setInt(4, entity.getCurrency().getId());
            ps.setString(5, entity.getDescription());
            ps.setTimestamp(6, entity.getCreateDate());
            ps.setTimestamp(7, entity.getCloseDate());
            ps.setInt(8, entity.getStatus());
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
    public void update(TradeGameOffer entity) throws DaoException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_REQUEST);
            ps.setInt(1, entity.getGame().getId());
            ps.setInt(2, entity.getUser().getId());
            ps.setDouble(3, entity.getCost());
            ps.setInt(4, entity.getCurrency().getId());
            ps.setString(5, entity.getDescription());
            ps.setTimestamp(6, entity.getCreateDate());
            ps.setTimestamp(7, entity.getCloseDate());
            ps.setInt(7, entity.getStatus());
            ps.setInt(8, entity.getId());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException  e) {
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
