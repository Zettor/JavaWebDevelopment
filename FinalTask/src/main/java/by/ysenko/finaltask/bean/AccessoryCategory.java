package by.ysenko.finaltask.bean;

import java.util.Objects;

public class AccessoryCategory extends Bean {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setName(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccessoryCategory)) return false;
        AccessoryCategory that = (AccessoryCategory) o;
        return getCategory().equals(that.getCategory());
    }

    public AccessoryCategory() {
    }

    @Override
    public int hashCode() {
        return getCategory().hashCode();
    }

    public AccessoryCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AccessoryCategory{" +
                "category='" + category + '\'' +
                '}';
    }
}
