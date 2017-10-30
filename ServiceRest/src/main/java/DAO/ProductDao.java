package DAO;


import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;
import persistence.SessionManager;

import java.sql.SQLException;
import java.util.List;


public class ProductDao  implements GenericDao<Product>{
    private SessionManager sessionManager;

    public ProductDao() {
        sessionManager = new SessionManager();
    }

    @Override
    public void create(Product object)  {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }
    @Override
    public void update(Product object){
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id){
        Product product = (Product) sessionManager.openCurrentSessionWithTransaction().load(Product.class, id);
        sessionManager.getSession().delete(product);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAll(){
        List<Product> products= (List<Product>)sessionManager.getSession().createQuery("select c from Product c").list();
        sessionManager.closeCurrentSession();
        return  products;
    }

    @Override
    public Product find(String name) {
        Product product = (Product) sessionManager.getSession().get(Product.class, name);
        sessionManager.closeCurrentSession();
        return product;
    }
    @SuppressWarnings("unchecked")
    public List<Product> findProduct(String name) {
        List<Product> products = (List<Product>) sessionManager.getSession().
                createCriteria(Product.class, "product").
                add(Restrictions.like("product.name",name+"%")).list();
        sessionManager.closeCurrentSession();
        return products;
    }

    @SuppressWarnings("unchecked")
    public List<Product> findProductByProducer(String name) {
        List<Product> products = (List<Product>) sessionManager.getSession().
                createCriteria(Product.class, "product").createAlias("product.producer", "producer").
                add(Restrictions.eq("producer.name",name)).list();
        sessionManager.closeCurrentSession();
        return products;
    }
    @SuppressWarnings("unchecked")
    public List<Product> findBySubcategory(String name) {
        List<Product> subcategories = (List<Product>) sessionManager.getSession().
                createCriteria(Product.class, "product").createAlias("product.subcategory", "subcategory").
                add(Restrictions.eq("subcategory.name",name)).list();
        sessionManager.closeCurrentSession();
        return subcategories;
    }
}
