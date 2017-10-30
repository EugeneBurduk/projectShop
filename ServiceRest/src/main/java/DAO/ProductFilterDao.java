package DAO;

import model.CharacteristicProduct;
import model.Product;
import model.viewModel.ProductFilter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import persistence.SessionManager;
import rest.PriceService;

import java.util.List;

public class ProductFilterDao {

    private SessionManager sessionManager;
    private PriceService priceService;

    public ProductFilterDao() {
        sessionManager = new SessionManager();

    }

    public List<Product> findProducts(ProductFilter filter){
        Criteria criteria = sessionManager.getSession().createCriteria(CharacteristicProduct.class, "charact")
                .createAlias("charact.product", "product")
                .createAlias("product.producer", "producer");

        if (filter.getBrand()!=null){
            criteria.add(Restrictions.eq("producer.name",filter.getBrand()));
        }
        if(filter.getMinDiameter()!=null){
            criteria.add(Restrictions
                    .and(Restrictions.eq("charact.nameCharacteristic","Диаметр колес"),
                    Restrictions.ge("charact.value",filter.getMinDiameter().toString())
                    ));

        }
        if(filter.getMaxDiameter()!=null){
            criteria.add(Restrictions
                    .and(Restrictions.eq("charact.nameCharacteristic","Диаметр колес"),
                            Restrictions.le("charact.value",filter.getMaxDiameter().toString())
                    ));

        }
        return criteria.list();
    }
}
