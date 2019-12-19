package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import java.util.List;

public interface CountryService {


    public List<Country> findAll(); ;

    public void delete(int id);

    public void add(Country country) throws IncorrectFormDataException;
}
