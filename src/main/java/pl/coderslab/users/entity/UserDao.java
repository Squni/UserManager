package pl.coderslab.users.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.users.db.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {
    private User[] users;
    private static final String CREATE_USER = "INSERT INTO users(user_name, user_email, user_pass) VALUES (?, ?, ?)";
    private static final String EDIT_USER = "UPDATE users SET users.user_email = ?, users.user_name = ?, users.user_pass = ? WHERE users.user_id = ?;";

    public User create(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        User user = null;
        try (Connection conn = DBUtil.getConnection(); ResultSet rs = DBUtil.getById(conn, "users", userId)) {
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("user_email"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("user_pass"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
    }

    public boolean emailExists(String email) {
        try (Connection conn = DBUtil.getConnection(); ResultSet rs = DBUtil.getByEmail(conn, "users", email)) {
            if (rs == null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usernameExists(String userName) {
        try (Connection conn = DBUtil.getConnection(); ResultSet rs = DBUtil.getByUsername(conn, "users", userName)) {
            if (rs == null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private User[] addToArray(User u, User[] users) {

        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);

        tmpUsers[users.length] = u;

        return tmpUsers;

    }

    public User[] findAll() {
        this.users = new User[0];
        try (Connection conn = DBUtil.getConnection(); ResultSet rs = DBUtil.getAll(conn, "users")) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_email"),
                        rs.getString("user_name"),
                        rs.getString("user_pass"),
                        rs.getString("permission"));
                users = addToArray(user, users);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return users;
        }
    }

    public void update(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.edit(conn,
                    EDIT_USER,
                    user.getId(),
                    user.getEmail(),
                    user.getUserName(),
                    BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void delete(int userId) {
        try (Connection conn = DBUtil.getConnection()) {
            DBUtil.remove(conn, "users", userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
