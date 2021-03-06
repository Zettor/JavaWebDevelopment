package by.ysenko.finaltask.bean;

import java.sql.Timestamp;


public class TradeGameOffer extends Bean{

    public TradeGameOffer() {
    }

    private User user;

    private String description;

    private Timestamp createDate;

    private double cost;

    private Currency currency;

    private Game game;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }



    public TradeGameOffer(User user, String description, Timestamp createDate, double cost, Currency currency, Game game) {
        this.user = user;
        this.description = description;
        this.createDate = createDate;
        this.cost = cost;
        this.currency = currency;
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeGameOffer)) return false;
        TradeGameOffer offer = (TradeGameOffer) o;
        return Double.compare(offer.getCost(), getCost()) == 0 &&
                getUser().equals(offer.getUser()) &&
                getDescription().equals(offer.getDescription()) &&
                getCreateDate().equals(offer.getCreateDate()) &&
                getCurrency().equals(offer.getCurrency()) &&
                getGame().equals(offer.getGame());
    }

    @Override
    public int hashCode() {
        return getUser().hashCode()
                + getDescription().hashCode()
                + getCreateDate().hashCode()
                + (int)getCost()+ getCurrency().hashCode()
                + getGame().hashCode();
    }

    @Override
    public String toString() {
        return "TradeGameOffer{" +
                "user=" + user +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", cost=" + cost +
                ", currency=" + currency +
                ", game=" + game +
                '}';
    }
}
