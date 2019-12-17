package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.AccessoryCategory;

import java.util.List;

public interface AccessoryCategoryService {

    public List<AccessoryCategory> findAll() ;
    public void delete(int id) ;
    public void add(AccessoryCategory category);
}
