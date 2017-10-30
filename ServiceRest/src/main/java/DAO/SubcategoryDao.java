package DAO;


import model.Subcategory;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;
import persistence.SessionManager;

import java.util.List;

public class SubcategoryDao implements GenericDao<Subcategory>{
    private SessionManager sessionManager;

    public SubcategoryDao() {
        sessionManager = new SessionManager();
    }

    @Override
    public void create(Subcategory object)  {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Subcategory object){
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id){
        Subcategory subcategory = (Subcategory) sessionManager.openCurrentSessionWithTransaction().load(Subcategory.class, id);
        sessionManager.getSession().delete(subcategory);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Subcategory> getAll(){
        List<Subcategory> subcategories= (List<Subcategory>)sessionManager.getSession().createQuery("select c from Subcategory c").list();
        sessionManager.closeCurrentSession();
        return  subcategories;
    }

    @Override
    public Subcategory find(String name) {
        Subcategory subcategory = (Subcategory) sessionManager.getSession().get(Subcategory.class, name);
        sessionManager.closeCurrentSession();
        return subcategory;
    }
    @SuppressWarnings("unchecked")
    public List<Subcategory> findByCategory(String name) {
        List<Subcategory> subcategories = (List<Subcategory>) sessionManager.getSession().
                createCriteria(Subcategory.class, "subcategory").createAlias("subcategory.category", "category").
                add(Restrictions.eq("category.name",name)).list();
        sessionManager.closeCurrentSession();
        return subcategories;
    }
}
