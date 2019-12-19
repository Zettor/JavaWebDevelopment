package by.ysenko.finaltask.bean;

import java.util.Objects;

public class Country extends Bean {

    public Country() {
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getName().equals(country.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }


}
