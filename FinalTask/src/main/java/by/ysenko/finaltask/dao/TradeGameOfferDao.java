package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.dao.exception.DaoException;

import java.util.List;

public interface TradeGameOfferDao extends Dao<TradeGameOffer> {
    public List<TradeGameOffer> findByUser(int user_id) throws DaoException;
    public List<TradeGameOffer> findLastOffers() throws DaoException;
}
