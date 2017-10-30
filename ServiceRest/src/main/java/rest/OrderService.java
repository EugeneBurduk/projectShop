package rest;

import DAO.OrderDao;
import model.Order;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;
import java.util.Set;

@Path("/order")
public class OrderService {
    OrderDao orderDao;
    public OrderService() {
        orderDao = new OrderDao();
    }

    @GET
    @Produces("application/json")
    public List<Order> getOrders(@Context HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        List<Order> orderList= orderDao.findByUser(user.getId());
        return orderList;
    }

    @POST
    @Consumes("application/json")
    public void createOrder(Order order, @Context HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        orderDao.create(new Order(user.getId(),order.getIdProduct(),false,false));
    }

    @PUT
    @Consumes("application/json")
    public void updateOrder(Order order, @Context HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        orderDao.update(new Order(order.getId(),user.getId(),order.getIdProduct(),true,false));
    }

}
