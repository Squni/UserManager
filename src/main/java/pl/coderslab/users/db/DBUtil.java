package pl.coderslab.users.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    private static final String DELETE_QUERY = "DELETE FROM tableName where user_id = ?";
    private static final String GET_BY_ID = "SELECT * FROM tableName where user_id = ?";
    private static final String GET_ALL = "SELECT * FROM tableName";
    private static final String GET_ID = "SELECT * FROM tableName WHERE user_id = ?";
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/users");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    public static ResultSet getAll(Connection conn, String tableName) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_ALL.replace("tableName", tableName));
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet getById(Connection conn, String tableName, int id) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(GET_BY_ID.replace("tableName", tableName));
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                String line = "";
                for (String param : columnNames) {
                    line = line.concat(resultSet.getString(param)).concat(" ");
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Connection conn, String query, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName))) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void edit(Connection conn, String query, int id, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.setInt(params.length + 1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean isRow(Connection conn, String tableName, int row) {
        try (PreparedStatement statement = conn.prepareStatement(GET_ID.replace("tableName", tableName))) {
            statement.setInt(1, row);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() != false) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
