package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Currency;

import java.util.List;

public interface CurrencyService {

    public List<Currency> findAll();


    public void delete(int id);


    public void add(Currency currency);
}
