package filter;

import model.Role;
import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Set;

public class AuthFactory {
    public static boolean isUserAllowed(User user, String requestUri, Set<Class<? extends HttpServlet>> controllers) {
        Class<? extends HttpServlet> controller = getCurrentController(requestUri, controllers);
        Role[] roles = getSecuredRoles(controller);
        for (Role role : roles) {
            if (user.getRole().equals(role))
                return true;
        }
        return false;
    }

    private static Class<? extends HttpServlet> getCurrentController(String requestUri, Set<Class<? extends HttpServlet>> controllers) {
        for (Class<? extends HttpServlet> item : controllers) {
            String[] attrValues = (item.getAnnotation(WebServlet.class)).urlPatterns().length > 0
                    ? (item.getAnnotation(WebServlet.class)).urlPatterns()
                    : (item.getAnnotation(WebServlet.class)).value();
            for (String val : attrValues) {
                if (val.equalsIgnoreCase(requestUri)) {
                    return item;
                }
            }
        }
        return null;
    }

    private static Role[] getSecuredRoles(Class<? extends HttpServlet> controller) {
        return controller.getAnnotation(Secured.class).value();
    }
}
