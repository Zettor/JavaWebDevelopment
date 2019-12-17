package by.ysenko.finaltask.bean;

import java.util.Objects;

public class TradeAccessoriesOffer extends Bean {

    public TradeAccessoriesOffer() {
    }

    private String name;

    private AccessoryCategory category;

    private double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessoryCategory getCategory() {
        return category;
    }

    public void setCategory(AccessoryCategory categort) {
        this.category = categort;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public TradeAccessoriesOffer(String name, AccessoryCategory category, double cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeAccessoriesOffer)) return false;
        TradeAccessoriesOffer that = (TradeAccessoriesOffer) o;
        return Double.compare(that.getCost(), getCost()) == 0 &&
                getName().equals(that.getName()) &&
                getCategory().equals(that.getCategory());
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + getCategory().hashCode() + (int) getCost();
    }

    @Override
    public String toString() {
        return "TradeAccessoriesOffer{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", cost=" + cost +
                '}';
    }
}
