package pl.coderslab.users.servlets;

import pl.coderslab.users.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/show")
public class ShowUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        request.setAttribute("showUser", userDao.read(Integer.parseInt(id)));
        request.setAttribute("title", "User details");
        request.getServletContext().getRequestDispatcher("/user/show.jsp").forward(request, response);

    }
}

