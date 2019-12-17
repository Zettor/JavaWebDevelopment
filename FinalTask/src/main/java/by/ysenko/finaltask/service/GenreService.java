package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Genre;

import java.util.List;

public interface GenreService {

    public List<Genre> findAll() ;
    public void delete(int id);
    public void add(Genre genre);
}
