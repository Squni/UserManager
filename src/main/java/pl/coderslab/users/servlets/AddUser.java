package pl.coderslab.users.servlets;

import pl.coderslab.users.entity.User;
import pl.coderslab.users.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/add")
public class AddUser extends HttpServlet {
    String add = "/user/add.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConf = request.getParameter("passwordConf");
        boolean create = true;

        if (EditUser.emailInUse(email)) {
            request.setAttribute("notCreate", "Email already in use.");
            create = false;
        } else if (EditUser.nameInUse(userName)) {
            request.setAttribute("notCreate", "Username already in use.");
            create = false;
        } else if (!password.equals(passwordConf) || password == null) {
            request.setAttribute("notCreate", "Password doesn't match.");
            create = false;
        }
        if (create) {
            createUser(email, userName, password);
            response.sendRedirect(add);
        } else {
            request.getServletContext().getRequestDispatcher(add).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Create user");
        request.getServletContext().getRequestDispatcher(add).forward(request, response);
    }

    public static void createUser(String userName, String email, String password) {
        UserDao uDao = new UserDao();
        uDao.create(new User(email, userName, password));
    }

}
