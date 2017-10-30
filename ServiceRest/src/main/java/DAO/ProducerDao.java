package DAO;

import model.Producer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;
import persistence.SessionManager;

import java.util.List;

public class ProducerDao  implements GenericDao<Producer>{

    private SessionManager sessionManager;

    public ProducerDao() {
        sessionManager = new SessionManager();
    }

    @Override
    public void create(Producer object)  {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Producer object){
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id){
        Producer producer = (Producer) sessionManager.openCurrentSessionWithTransaction().load(Producer.class, id);
        sessionManager.getSession().delete(producer);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAll(){
        List<Producer> subcategories= (List<Producer>)sessionManager.getSession().createQuery("select c from Producer c").list();
        return  subcategories;
    }

    @Override
    public Producer find(String name) {
        Producer producer = (Producer) sessionManager.getSession().createCriteria("from Producer p where p.name ="+
                        name);
        return producer;
    }
    @SuppressWarnings("unchecked")
    public List<Producer> findByName(String name) {
        List<Producer> producers = (List<Producer>) sessionManager.getSession().
                createCriteria(Producer.class, "producer").
                add(Restrictions.eq("producer.name",name)).list();
        return producers;
    }
}
