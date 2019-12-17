package by.ysenko.finaltask.bean;

import java.util.Objects;

public class Currency extends Bean {

    public Currency() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return getName().equals(currency.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                '}';
    }
}
