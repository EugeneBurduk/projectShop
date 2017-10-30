package rest;

import DAO.CharacteristicsDao;
import DAO.CharacteristicsProductDao;
import model.Characteristic;
import model.CharacteristicProduct;
import model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("characteristics")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharacteristicService {

    CharacteristicsDao characteristicsDao;

    public CharacteristicService(){
        characteristicsDao= new CharacteristicsDao();
    }

    /**/
    @GET
    @Path("{nameSubcategory}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Characteristic> getSubcategory(@PathParam("nameSubcategory") String nameSubcategory) {
        System.out.println(nameSubcategory);
        List<Characteristic> characteristics = characteristicsDao.findBySubCategory(nameSubcategory);
        System.out.println("jjjj"+characteristics.toString());
        return characteristics;
    }
}
