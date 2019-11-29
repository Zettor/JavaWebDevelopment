package by.ysenko.finaltask.dao.impl;

import java.sql.Connection;

public class BaseDaoImpl {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
