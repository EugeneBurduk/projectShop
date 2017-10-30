package DAO;


import model.Characteristic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;
import persistence.SessionManager;

import java.util.List;

public class CharacteristicsDao implements GenericDao<Characteristic> {

    private SessionManager sessionManager;

    public CharacteristicsDao() {
        sessionManager = new SessionManager();
    }
    @Override
    public void create(Characteristic object) {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Characteristic object) {
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id) {
        Characteristic characteristic = (Characteristic) sessionManager.openCurrentSessionWithTransaction().load(Characteristic.class, id);
        sessionManager.getSession().delete(characteristic);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public List<Characteristic> getAll() {
        List<Characteristic> characteristics= (List<Characteristic>)sessionManager.getSession().createQuery("select c from Characteristic c").list();
        sessionManager.closeCurrentSession();
        return  characteristics;
    }

    @Override
    public Characteristic find(String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Characteristic> findBySubCategory(String name) {
        List<Characteristic> characteristics = (List<Characteristic>) sessionManager.getSession().
                createCriteria(Characteristic.class, "characteristic").createAlias("characteristic.subcategory", "subcategory").
                add(Restrictions.eq("subcategory.name",name)).list();
        // List<Subcategory> subcategories = (List<Subcategory>) getSession().get(Subcategory.class, );
        return characteristics;
    }


}
