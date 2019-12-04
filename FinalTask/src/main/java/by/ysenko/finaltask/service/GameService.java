package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface GameService {


    public List<Game> findAll() throws PersistentException ;

    public void delete(int id) throws PersistentException ;

    public Game findById(Integer id) throws PersistentException;
    public void add(Game game) throws PersistentException ;
}
