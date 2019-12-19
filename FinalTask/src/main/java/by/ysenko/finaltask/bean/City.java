package by.ysenko.finaltask.bean;

import java.util.Objects;

public class City extends Bean {


    public City() {
    }

    private String name;

    private Integer countryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public City(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getName().equals(city.getName()) &&
                getCountryId().equals(city.getCountryId());
    }

    @Override
    public int hashCode() {
        return getName().hashCode()+ getCountryId();
    }


}
