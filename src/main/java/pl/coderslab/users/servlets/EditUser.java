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
    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String passwordConf = request.getParameter("passwordConf");

        if (!inUse(id, userName, email).equals("")) {
            request.setAttribute("cannotEdit", inUse(id, userName, email) + " already in use.");
            request.getServletContext().getRequestDispatcher("/user/edit.jsp").forward(request, response);
        } else {
            if (!newPassword.equals(passwordConf)) {
                request.setAttribute("cannotEdit", "Password doesn't match.");
                request.getServletContext().getRequestDispatcher("/user/edit.jsp").forward(request, response);
            } else if (!newPassword.equals("")){
                password = newPassword;
            }
            userDao.update(new User(id, email, userName, password));
            response.sendRedirect("/users/list");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("editUser", userDao.read(Integer.parseInt(id)));
        request.getServletContext().getRequestDispatcher("/user/edit.jsp").forward(request, response);


    }

    public String inUse(int id, String userName, String email) {
        User[] users = userDao.findAll();
        for (User user : users) {
            if (user.getId() != id) {
                if (user.getUserName().equals(userName)) {
                    return "Username";
                } else if (user.getEmail().equals(email)) {
                    return "Email";
                }
            }
        }
        return "";
    }

}

