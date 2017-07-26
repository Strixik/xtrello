package lms.models;

import lms.view.PageParts;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Надя on 18.07.2017.
 */
public class User extends ConnectToDB {
    private String login, password, email;
    private int id;
    private String loginUsername, loginPassword, loginemail;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public User(){}

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public boolean findByLogin(String login) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, login, password, email FROM users WHERE login=\"" + login + "\";");) {
            if(rs.next()) {
                this.id = rs.getInt("id");
                this.login = rs.getString("login");
                this.password = rs.getString("password");
                this.email = rs.getString("email");
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
    public void   insert(String login, String password, String email) {
        System.out.println(login+password+email);
        String sql = "INSERT INTO users(login,password,email) VALUES(?,?,?)";

        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
