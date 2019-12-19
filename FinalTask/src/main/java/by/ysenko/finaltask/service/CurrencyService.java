package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import java.util.List;

public interface CurrencyService {

    public List<Currency> findAll();


    public void delete(int id);


    public void add(Currency currency) throws IncorrectFormDataException;
}
