package rest;


import model.Price;
import serviceSoap.ServiceSoap;
import serviceSoap.WebServiceSOAP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.util.List;


@Path("prices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PriceService {
   private  WebServiceSOAP webServiceSOAP;

    public PriceService() throws MalformedURLException {
        webServiceSOAP= new ServiceSoap().getServiceSoapPort();
    }

    @GET
    @Path("{nameProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public Price getPrice(@PathParam("nameProduct") String nameProduct) {
        Price price;
        price = webServiceSOAP.getPriceByName(nameProduct);
        System.out.println("price"+price);
        return price;
    }
    /*@GET
    @Path("{startPrice}/{finalPrice}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Price> getProductByPrice(@PathParam("startPrice") String startPrice,
                                         @PathParam("finalPrice") String finalPrice) {

        List<Price> products = webServiceSOAP.getProductsByPrice(startPrice,finalPrice);
        return products;
    }*/

}
