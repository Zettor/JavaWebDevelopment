package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface GameService {


    public List<Game> findAll() ;

    public void delete(int id)  ;

    public Game findById(Integer id) ;
    public void add(Game game);
}
