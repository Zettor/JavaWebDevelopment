package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.dao.AccessoryCategoryDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.service.AccessoryCategoryService;

import java.util.List;

public class AccessoryCategoryServiceImpl extends ServiceImpl implements AccessoryCategoryService {

    @Override
    public List<AccessoryCategory> findAll()  {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        List<AccessoryCategory> categories=null;
        try {
            categories = accessoryCategoryDao.findAll();
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
        return categories;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        try {
            accessoryCategoryDao.delete(id);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }

    @Override
    public void add(AccessoryCategory category)  {
        Transaction transaction = transactionFactory.createTransaction();
        AccessoryCategoryDao accessoryCategoryDao = daoFactory.createAccessoryCategoryDao();
        transaction.begin(accessoryCategoryDao);
        try{
        accessoryCategoryDao.create(category);
        transaction.commit();
    }catch (DaoException e){
        transaction.rollback();
    }
        transaction.end();

    }
}
