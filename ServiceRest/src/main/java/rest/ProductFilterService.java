package rest;

import DAO.ProducerDao;
import DAO.ProductDao;
import DAO.ProductFilterDao;
import model.Product;
import model.viewModel.ProductFilter;
import org.hibernate.Criteria;

import javax.ws.rs.*;
import java.util.List;

@Path("products/filter")
public class ProductFilterService {

    ProductFilterDao productDao;

   public ProductFilterService(){
       productDao = new ProductFilterDao();
   }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public List<Product> findProducts(ProductFilter filter) {
        return productDao.findProducts(filter);
    }

}
