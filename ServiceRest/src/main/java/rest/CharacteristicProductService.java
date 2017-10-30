package rest;

import DAO.CharacteristicsProductDao;
import model.CharacteristicProduct;
import persistence.SessionManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("characteristicsProduct")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharacteristicProductService {
    private SessionManager sessionManager = new SessionManager();

    CharacteristicsProductDao characteristicsProductDao;
    public CharacteristicProductService(){
        characteristicsProductDao= new CharacteristicsProductDao();
    }

    @GET
    @Path("{nameProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CharacteristicProduct> getCharacteristicsProduct(@PathParam("nameProduct") String nameProduct) {
        System.out.println(nameProduct);
        List<CharacteristicProduct> characteristicsProduct = characteristicsProductDao.findByProduct(nameProduct);
        System.out.println("jjjj"+characteristicsProduct.toString());
        return characteristicsProduct;
    }

    @POST
    @Consumes("application/json")
    public void create(CharacteristicProduct[] characteristicProduct) {
         System.out.print(characteristicProduct.length);
        for (CharacteristicProduct characteristic: characteristicProduct) {
            System.out.print(characteristic.toString());
            characteristicsProductDao.create(new CharacteristicProduct(
                    characteristic.getProduct().getId(), characteristic.getNameCharacteristic(),characteristic.getValue()
            ));
        }
    }
}
