package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Country;

import java.util.List;

public interface CountryService {


    public List<Country> findAll(); ;

    public void delete(int id);

    public void add(Country country);
}
