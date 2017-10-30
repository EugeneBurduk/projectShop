package DAO;


import model.User;
import org.hibernate.criterion.Restrictions;
import persistence.SessionManager;

import java.util.List;

public class UserDao implements GenericDao<User> {

    private SessionManager sessionManager;

    public UserDao() {
        sessionManager = new SessionManager();
    }

    @Override
    public void create(User object) {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(User object) {

        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id) {
        User user = (User) sessionManager.openCurrentSessionWithTransaction().load(User.class, id);
        sessionManager.getSession().delete(user);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public List<User> getAll() {
        List<User> users= (List<User>)sessionManager.getSession().createQuery("select c from User c").list();
        sessionManager.closeCurrentSession();
        return  users;
    }

    @Override
    public User find(String name) {
        User user = (User) sessionManager.getSession().
                createCriteria(User.class, "user").
                add(Restrictions.eq("user.username",name)).uniqueResult();
        sessionManager.closeCurrentSession();
        return user;
    }


    public User find(String username, String password) {
        User user = (User) sessionManager.getSession().
                createCriteria(User.class, "user").
                add(Restrictions.eq("user.username",username)).add(Restrictions.eq("user.password", password)).uniqueResult();
        sessionManager.closeCurrentSession();
        return user;
    }
}
