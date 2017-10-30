package rest;


import DAO.ProducerDao;
import DAO.ProductDao;
import model.Producer;
import model.Product;
import model.Subcategory;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.util.List;


@Path("/products")
public class ProductService {

    ProductDao productDao;
    ProducerDao producerDao;

    public ProductService(){

        productDao= new ProductDao();
        producerDao = new ProducerDao();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getProducts() {
        List<Product> products = productDao.getAll();
        System.out.println(products.toString());
        return products;
    }
    @GET
    @Path("{nameProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getProduct(@PathParam("nameProduct") String nameProduct) {
        System.out.println(nameProduct);
        List<Product> products = productDao.findProduct(nameProduct);
        System.out.println(products.toString());
        return products;
    }

    @GET
    @Path("brand/{nameProducer}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getProductbyProducer(@PathParam("nameProducer") String nameProducer) {
        System.out.println(nameProducer);
        List<Product> products = productDao.findProductByProducer(nameProducer);
        System.out.println(products.toString());
        return products;
    }
    @GET
    @Path("subcategory/{nameSubcategory}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getSubcategory(@PathParam("nameSubcategory") String nameSubcategory) {
        System.out.println(nameSubcategory);
        List<Product> products = productDao.findBySubcategory(nameSubcategory);
        System.out.println(products.toString());
        return products;
    }


    @POST
    @Consumes("application/json")
    public Product create(Product product){
        System.out.println("VFD"+product.getPhoto());
        File file = new File(product.getPhoto());
        Product newProduct = new Product (product.getName(), "/static/image/"+file.getName(),0,
                product.getIdProducer(), product.getIdSubcategory(), product.getCountProduct());
        productDao.create(newProduct);
        newProduct.setProducer(new Producer (product.getProducer().getName()));
        newProduct.setSubcategory(new Subcategory(product.getSubcategory().getName()));
        return newProduct;
    }

    @PUT
    @Consumes("application/json")
    public void update(Product product){
        System.out.println("VFD"+product.getPhoto());
        File file = new File(product.getPhoto());
        Product newProduct = new Product (product.getId(),product.getName(), "/static/image/"+file.getName(),0,
                product.getIdProducer(), product.getIdSubcategory(),product.getCountProduct()-1);
        productDao.update(newProduct);

    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        productDao.delete(id);
    }

}
