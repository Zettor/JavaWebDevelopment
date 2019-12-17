package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.City;
import java.util.List;

public interface CityService {

    public List<City> findByCountryId(Integer countryId);

    public void delete(int id);

    public void add(City city);
}
