package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.impl.UserServiceImpl;

import java.util.List;

public interface GenreService {

    public List<Genre> findAll() ;
    public void delete(int id);
    public void add(Genre genre);
}
