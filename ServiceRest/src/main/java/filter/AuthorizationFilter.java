package filter;

import model.User;
import org.reflections.Reflections;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/order"})
public class AuthorizationFilter implements Filter {
    private static Set<Class<? extends HttpServlet>> controllers;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String loginURI = request.getContextPath() + "/login";

        HttpSession session = request.getSession();
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        if(loggedIn){
            User user = (User)session.getAttribute("user");
            if(AuthFactory.isUserAllowed(user, request.getRequestURI(), controllers))
                chain.doFilter(req, resp);
            else
                response.sendRedirect("");
        }
        else
            response.sendRedirect(loginURI);
    }

    public void init(FilterConfig config) throws ServletException {
        Reflections reflections = new Reflections("controllers");
        controllers =  reflections.getSubTypesOf(HttpServlet.class);
    }

}
