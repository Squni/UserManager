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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConf = request.getParameter("passwordConf");

        if (!password.equals(passwordConf) || password == null) {
            request.setAttribute("cannotCreate", "Password doesn't match.");
        } else {
            String check = doExists(userName, email);
            if (!check.equals("")) {
                request.setAttribute("cannotCreate", check + " already in use.");
            } else {
                createUser(userName,email,password);
                request.setAttribute("userCreated", "User successfully created.");
            }
        }
        request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);


    }

    public static String doExists(String userName, String email) {
        UserDao uDao = new UserDao();
        User[] users = uDao.findAll();
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return "Username";
            } else if (user.getEmail().equals(email)) {
                return "Email";
            }
        }
        return "";
    }

    public static void createUser(String userName, String email, String password) {
        UserDao uDao = new UserDao();
        uDao.create(new User(email,userName,password));
    }

}
