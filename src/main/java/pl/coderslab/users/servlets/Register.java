package pl.coderslab.users.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
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
        } else if (!password.equals(passwordConf)) {
            request.setAttribute("notCreate", "Password doesn't match.");
            create = false;
        }
        if (create) {
            AddUser.createUser( userName, email, password);
            response.sendRedirect("/login");
        } else {
            request.getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Register");
        request.getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
    }
}
