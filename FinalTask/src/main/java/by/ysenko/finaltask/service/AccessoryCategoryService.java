package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface AccessoryCategoryService {

    public List<AccessoryCategory> findAll() throws PersistentException;
    public void delete(int id) throws PersistentException;
    public void add(AccessoryCategory category) throws PersistentException;
}
