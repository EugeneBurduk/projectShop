package serviceSoap;

import model.Price;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceSOAP {


   @WebMethod
    public void create(Price price);
    @WebMethod
    public void update(Price price) ;
    @WebMethod
    public Price getPriceByName(String nameProduct);
   /* @WebMethod
    public List<Price> getProductsByPrice(String startPrice, String finalPrice);*/

}
