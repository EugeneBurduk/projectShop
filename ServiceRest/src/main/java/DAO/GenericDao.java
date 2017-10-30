package DAO;


import java.sql.SQLException;
import java.util.List;

 interface GenericDao<T> {
    void create(T object);
    void update(T object);
    void delete(Integer id);
    List<T> getAll();
    T find(String name);
}
