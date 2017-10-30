package service;





import com.evgenya.DAO.PriceDao;
import com.evgenya.model.Price;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService(endpointInterface = "service.WebServiceSOAP")
public class ServiceSoap implements WebServiceSOAP {
    PriceDao priceDao;

    public ServiceSoap(){   priceDao = new PriceDao();}
    @Override
    public void create(Price price)  {
        try {
            priceDao.create(price);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public void update(Price price) {
        try {
            priceDao.update(price);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

   @Override
    public  Price getPriceByName(String nameProduct) {
      Price  price = priceDao.find(nameProduct);
        return price;
    }

   /* @Override
    public List<Price> getProductsByPrice(String startPrice, String finalPrice) {
        List<Price> priceList = priceDao.findProductsByPrice(startPrice,finalPrice);
        return priceList;
    }*/


}
