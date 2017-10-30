package com.evgenya.DAO;


import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    public void create(T object) throws SQLException;
    public void update(T object) throws SQLException;
    public List<T> getAll() throws SQLException;
    T find(String nameProduct) throws SQLException;
}
