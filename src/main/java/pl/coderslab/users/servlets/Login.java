package pl.coderslab.users.servlets;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.users.entity.User;
import pl.coderslab.users.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userLog = request.getParameter("userName");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        boolean noUser = true;
        for (User user : users) {
            if (userLog.equals(user.getUserName())) {
                if (BCrypt.checkpw(password, user.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LoggedIn", user);
                    if (user.getPermission().equals("admin")) {
                        session.setAttribute("permission", 1);
                    }
                    response.sendRedirect("/index.jsp");
                } else {
                    request.setAttribute("invalidLogin", "Wrong password. Try again.");
                    request.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
                }
                noUser = false;
                break;
            }
        }
        if (noUser) {
            request.setAttribute("invalidLogin", "Username not found. Try again or register.");
            request.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);


    }
}
