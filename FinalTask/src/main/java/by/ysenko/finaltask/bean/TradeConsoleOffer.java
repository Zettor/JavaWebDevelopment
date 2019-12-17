package by.ysenko.finaltask.bean;

import java.sql.Timestamp;


public class TradeConsoleOffer extends Bean {

    public TradeConsoleOffer() {
    }

    private String name;

    private double cost;

    private User user;

    private String currency;

    private String description;

    private Timestamp createDate;

    private Timestamp closeDate;

    private int status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public TradeConsoleOffer(String name, double cost, User user, String currency, String description, Timestamp createDate, Timestamp closeDate, int status) {
        this.name = name;
        this.cost = cost;
        this.user = user;
        this.currency = currency;
        this.description = description;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeConsoleOffer)) return false;
        TradeConsoleOffer that = (TradeConsoleOffer) o;
        return Double.compare(that.getCost(), getCost()) == 0 &&
                getStatus() == that.getStatus() &&
                getName().equals(that.getName()) &&
                getUser().equals(that.getUser()) &&
                getCurrency().equals(that.getCurrency()) &&
                getDescription().equals(that.getDescription()) &&
                getCreateDate().equals(that.getCreateDate()) &&
                getCloseDate().equals(that.getCloseDate());
    }

    @Override
    public int hashCode() {
        return getName().hashCode()
                + (int) getCost()
                + getUser().hashCode()
                + getCurrency().hashCode()
                + getDescription().hashCode()
                + getCreateDate().hashCode()
                + getCloseDate().hashCode()
                + getStatus();
    }

    @Override
    public String toString() {
        return "TradeConsoleOffer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", user=" + user +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", closeDate=" + closeDate +
                ", status=" + status +
                '}';
    }
}
