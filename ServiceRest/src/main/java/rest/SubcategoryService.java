package rest;

import DAO.ProductDao;
import DAO.SubcategoryDao;
import model.Product;
import model.Subcategory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/subcategory")
public class SubcategoryService {

    SubcategoryDao subcategoryDao;

    public SubcategoryService() {
        subcategoryDao = new SubcategoryDao();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Subcategory> getSubcategory() {
        List<Subcategory> subcategories = subcategoryDao.getAll();
        System.out.println(subcategories.toString());
        return subcategories;
    }
    @GET
    @Path("{nameCategory}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Subcategory> getSubcategory(@PathParam("nameCategory") String nameCategory) {
        System.out.println(nameCategory);
        List<Subcategory> subcategories = subcategoryDao.findByCategory(nameCategory);
       System.out.println(subcategories.toString());
        return subcategories;
    }
}

