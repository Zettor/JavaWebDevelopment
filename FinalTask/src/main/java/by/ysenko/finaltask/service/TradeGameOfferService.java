package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.TradeGameOffer;

import java.util.List;

public interface TradeGameOfferService {

    public List<TradeGameOffer> findLastOffers() ;

    public List<TradeGameOffer> findOffers();

    public void add(TradeGameOffer offer) ;

    public TradeGameOffer findById(Integer id);
}
