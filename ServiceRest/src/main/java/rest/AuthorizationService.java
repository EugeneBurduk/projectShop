package rest;


import DAO.UserDao;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/login")
public class AuthorizationService {

    UserDao userDao;
    public AuthorizationService() {
        userDao = new UserDao();
    }


    @GET
    @Path("{username}/{password}")
   // public Response getUser(@Context HttpServletRequest request) {
    public Response getUser(@PathParam("username") String username,
                            @PathParam("password") String password,
                            @Context HttpServletRequest request) {
       // String username = String.valueOf(request.getParameter("username"));
       // String password = String.valueOf(request.getParameter("password"));
        User user = userDao.find(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return Response.status(Response.Status.OK).entity("ok").build();
        } else {
           return Response.status(Response.Status.NOT_FOUND).entity("Пользователь с таким логином и паролем не найден. Проверьте правильность введенных данных").build();
        }

    }
}
