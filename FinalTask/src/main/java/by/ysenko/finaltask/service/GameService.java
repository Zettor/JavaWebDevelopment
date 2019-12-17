package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Game;

import java.util.List;

public interface GameService {


    public List<Game> findAll() ;

    public void delete(int id)  ;

    public Game findById(Integer id) ;
    public void add(Game game);
}
