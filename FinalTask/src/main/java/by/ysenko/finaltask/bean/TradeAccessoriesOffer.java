package by.ysenko.finaltask.bean;

public class TradeAccessoriesOffer extends Offer {

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
}
