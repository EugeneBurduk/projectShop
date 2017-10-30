package rest;


import DAO.UserDao;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserService {
    UserDao userDao;

    @Context
    private HttpServletRequest request;
    public UserService() {
        userDao = new UserDao();
    }
    //request.getSession(true);
    @GET
    @Path("{username}")
    @Produces("application/json")
    public Response getUser(@PathParam("username") String username) {
        if(userDao.find(username)!=null){
            return Response.status(Response.Status.CONFLICT).entity("Пользователь с таким именем уже существует").build();
        }
        return null;//  Response.status(Response.Status.OK).entity("ok").build();
    }

    @POST
    @Consumes("application/json")
    public void create(User user){
        userDao.create(user);
    }
    /*
    @POST
@Consumes("application/xml")
public Response post(String content) {
  URI createdUri = ...
  String createdContent = create(content);
  return Response.created(createdUri).entity(Entity.text(createdContent)).build();
}*/
   /* //Возврат кода статуса 201 и добавление Location заголовка в ответ на запрос POST
    @POST
    @Consumes("application/xml")
    public Response post(String content) {
        URI createdUri = ...
        create(content);
        return Response.created(createdUri).build();
    }*/
    /*@Path("items/{itemid}/")
public Item getItem(@PathParam("itemid") String itemid) {
  Item i = getItems().get(itemid);
  if (i == null) {
    throw new CustomNotFoundException("Item, " + itemid + ", is not found");
  }
 
  return i;
}*/
}
