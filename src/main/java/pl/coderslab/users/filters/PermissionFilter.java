package pl.coderslab.users.filters;

import pl.coderslab.users.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/users/*")
public class PermissionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("LoggedIn");
        if (user != null && user.getPermission().equals("user")) {
            request.setAttribute("permissionDenied", "Permission denied.");
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
