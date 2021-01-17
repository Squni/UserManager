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
        boolean created = false;

        if (!password.equals(passwordConf) || password == null) {
            request.setAttribute("notCreate", "Password doesn't match.");
        } else {
            String check = AddUser.doExists(userName, email);
            if (!check.equals("")) {
                request.setAttribute("notCreate", check + " already in use.");
            } else {
                created = true;
                AddUser.createUser(userName, email, password);
                response.sendRedirect("/login");
            }
        }
        if (!created) {
            request.getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
    }
}
