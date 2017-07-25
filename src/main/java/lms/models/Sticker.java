package lms.models;

import lms.view.PageParts;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Надя on 18.07.2017.
 */
public class Sticker extends ConnectToDB {
private String sticker_name;
private String note;

    public String getSticker_name() {
        return sticker_name;
    }

    public void setSticker_name(String sticker_name) {
        this.sticker_name = sticker_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void insertNote(int id, String stickerName, String text){

        String sql = "INSERT INTO notes(note,user_id,sticker_name) VALUES(?,?,?)";

        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, text);
            pstmt.setInt(2, id);
            pstmt.setString(3, stickerName);
            pstmt.executeUpdate();
                    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void insertStiker_name(int id, String stickerName) {
            try (Connection con = DriverManager.getConnection(DB_URL);
                 Statement stmt = con.createStatement();) {
                stmt.executeUpdate("INSERT INTO notes (sticker_name, user_id) VALUE(\"" + stickerName + "\"," + id + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


    public static ArrayList<String> getNote(Integer id, String sticker_name) {
        ArrayList<String> note = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT note FROM notes WHERE user_id=\"" + id + "\" AND sticker_name=\"" + sticker_name + "\";");) {
            while (rs.next()) {
                note.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return note;
    }

    public static ArrayList<String> getStickername(Integer id) {
        ArrayList<String> note = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT sticker_name FROM notes WHERE user_id=\"" + id + "\";");) {
            while (rs.next()) {
                note.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return note;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "sticker_name='" + sticker_name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

}
