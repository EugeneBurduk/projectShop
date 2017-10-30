package DAO;


import model.Characteristic;
import model.CharacteristicProduct;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;
import persistence.SessionManager;


import java.util.List;


public class CharacteristicsProductDao implements GenericDao<CharacteristicProduct> {

    private SessionManager sessionManager;

    public CharacteristicsProductDao() {
        sessionManager = new SessionManager();
    }

    @SuppressWarnings("unchecked")
    public List<CharacteristicProduct> getAll(){
        List<CharacteristicProduct> characteristicsProduct= (List<CharacteristicProduct>)sessionManager.getSession().createQuery("select c from CharacteristicProduct  c").list();
        sessionManager.closeCurrentSession();
        return  characteristicsProduct;
    }

    @Override
    public void create(CharacteristicProduct object) {
        sessionManager.openCurrentSessionWithTransaction().save(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }
    @Override
    public void update(CharacteristicProduct object){
        sessionManager.openCurrentSessionWithTransaction().update(object);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Integer id){
        CharacteristicProduct characteristics = (CharacteristicProduct) sessionManager.openCurrentSessionWithTransaction().load(CharacteristicProduct.class, id);
        sessionManager.getSession().delete(characteristics);
        sessionManager.closeCurrentSessionWithTransaction();
    }

    @Override
    public CharacteristicProduct find(String name) {
        CharacteristicProduct product = (CharacteristicProduct) sessionManager.getSession().get(CharacteristicProduct.class, name);
        sessionManager.closeCurrentSession();
        return product;
    }
    @SuppressWarnings("unchecked")
    public List<CharacteristicProduct> findByProduct(String name) {
        List<CharacteristicProduct> characteristicsProduct = (List<CharacteristicProduct>) sessionManager.getSession().
                createCriteria(CharacteristicProduct.class, "characteristicsproduct").
                createAlias("characteristicsproduct.product", "product").
                add(Restrictions.eq("product.name",name)).list();
        sessionManager.closeCurrentSession();
        return characteristicsProduct;
    }

    @SuppressWarnings("unchecked")
    public List<CharacteristicProduct> findBySubcategory(String name) {
        List<CharacteristicProduct> characteristicsProduct = (List<CharacteristicProduct>) sessionManager.getSession().
                createCriteria(CharacteristicProduct.class, "characteristictoproduct").
                createAlias("characteristictoproduct.product", "product").
                createAlias("product.subcategory", "subcategory").
                add(Restrictions.eq("subcategory.name",name)).list();
        sessionManager.closeCurrentSession();
        return characteristicsProduct;
    }
}
