package pl.coderslab.users.servlets;

import pl.coderslab.users.entity.User;
import pl.coderslab.users.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/edit")
public class EditUser extends HttpServlet {
    private static UserDao userDao = new UserDao();
    private String editPage = "/user/edit.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String passwordConf = request.getParameter("passwordConf");
        boolean edit = true;

        if (emailInUse(email)) {
            request.setAttribute("notCreate", "Email already in use.");
            edit = false;
        } else if (nameInUse(userName)) {
            request.setAttribute("notCreate", "Username already in use.");
            edit = false;
        } else if (!newPassword.equals(passwordConf)) {
            request.setAttribute("notCreate", "Password doesn't match.");
            edit = false;
        }
        if (!newPassword.equals("")) {
            password = newPassword;
        }
        if (edit) {
            userDao.update(new User(id, email, userName, password));
            response.sendRedirect("/users/list");
        } else {
            request.getServletContext().getRequestDispatcher(editPage).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("editUser", userDao.read(Integer.parseInt(id)));
        request.setAttribute("title", "Edit user");
        request.getServletContext().getRequestDispatcher(editPage).forward(request, response);

    }

    public static boolean nameInUse(String userName) {
        return userDao.usernameExists(userName);
    }

    public static boolean emailInUse(String email) {
        return userDao.usernameExists(email);
    }
}


