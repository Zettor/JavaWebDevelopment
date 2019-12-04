package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.AccessoryCategoryDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.AccessoryCategoryService;

import java.util.List;

public class AccessoryCategoryServiceImpl extends ServiceImpl implements AccessoryCategoryService {

    @Override
    public List<AccessoryCategory> findAll() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        List<AccessoryCategory> categories = accessoryCategoryDao.findAll();
        transaction.end();
        return categories;
    }

    @Override
    public void delete(int id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        accessoryCategoryDao.delete(id);
        transaction.end();

    }

    @Override
    public void add(AccessoryCategory category) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        accessoryCategoryDao.create(category);
        transaction.end();

    }
}
