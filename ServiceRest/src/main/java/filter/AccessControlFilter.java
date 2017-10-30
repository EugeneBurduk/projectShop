package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eugene on 17.10.2017.
 */
@WebFilter(filterName = "AccessControlFilter", urlPatterns = "/rest/*")
public class AccessControlFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        chain.doFilter(req, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
