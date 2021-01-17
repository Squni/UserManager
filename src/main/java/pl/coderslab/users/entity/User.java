package pl.coderslab.users.entity;

public class User {
    private int id;
    private String email;
    private String userName;
    private String password;
    private String permission;

    public User() {
    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String email, String userName) {
        this.id = id;
        this.email = email;
        this.userName = userName;
    }


    public User(int id, String email, String userName, String password) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String email, String userName, String password, String permission) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return
                "id= " + id +
                ", email= '" + email + '\'' +
                ", userName= '" + userName + '\'' +
                ", password= '" + password + '\'' + "\n";
    }
}
