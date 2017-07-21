package lms.models;

import lms.view.PageParts;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Надя on 18.07.2017.
 */
public class User extends ConnectToDB {
    private String login, password;
    private int id;
    private String loginUsername;
    private String loginPassword;

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User(){}
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public boolean findByLogin(String login) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, login, password FROM users WHERE login=\"" + login + "\";");) {
            if(rs.next()) {
                this.id = rs.getInt("id");
                this.login = rs.getString("login");
                this.password = rs.getString("password");
                String l = rs.getString("login");
                String p = rs.getString("password");
                Integer d = rs.getInt("id");
                System.out.println(d+l+p);
                return true;

            }
            return false;
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean checkLogin() {
        findByLogin(this.loginUsername);
        if(loginUsername.equalsIgnoreCase(login) && loginPassword.equals(password)) {
            return  true;
        }
        return false;
    }
    public void   insert(String login, String password) {
        String sql = "INSERT INTO users(login,password) VALUES(?,?)";

        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
