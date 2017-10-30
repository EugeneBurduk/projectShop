package rest;

import DAO.ProducerDao;
import model.Producer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("producer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProducerService {
     ProducerDao producerDao;
     public ProducerService(){
        producerDao = new ProducerDao();
     }

    @POST
   // @Path("{nameProducer}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Producer> getProducer(Producer producer) {
        List<Producer> producers = producerDao.findByName(producer.getName());
        if(producers.size()==0){
            Producer newProducer = new Producer(producer.getName());
            producerDao.create(newProducer);
            producers.add(newProducer);
        }
        return producers;
    }
}
