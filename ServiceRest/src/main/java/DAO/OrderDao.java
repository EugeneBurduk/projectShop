package DAO;


import model.Order;
import org.hibernate.criterion.Restrictions;
import persistence.SessionManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderDao implements GenericDao<Order>{

    private SessionManager sessionManager;

    public OrderDao() {
        sessionManager = new SessionManager();
    }

    @Override
    public void create(Order object) {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Order object) {
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id) {
        Order order = (Order) sessionManager.openCurrentSessionWithTransaction().load(Order.class, id);
        sessionManager.getSession().delete(order);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public List<Order> getAll() {
        List<Order> users= (List<Order>)sessionManager.getSession().createQuery("select c from Order c").list();
        sessionManager.closeCurrentSession();
        return  users;
    }

    @Override
    public Order find(String name) {

        return null;
    }
    public List<Order> findByUser(Integer idUser) {
        List<Order> ordersList = (List<Order>) sessionManager.getSession().
                createCriteria(Order.class, "order").
                add(Restrictions.eq("order.idUser", idUser)).list();

        sessionManager.closeCurrentSession();
        return ordersList;
    }

}
