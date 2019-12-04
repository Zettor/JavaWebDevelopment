package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.impl.UserServiceImpl;

import java.util.List;

public interface GenreService {

    public List<Genre> findAll() throws PersistentException;
    public void delete(int id) throws PersistentException;
    public void add(Genre genre) throws PersistentException;
}
