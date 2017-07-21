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
private String[] note;

    public String getSticker_name() {
        return sticker_name;
    }

    public void setSticker_name(String sticker_name) {
        this.sticker_name = sticker_name;
    }

    public String[] getNote() {
        return note;
    }

    public void setNote(String[] note) {
        this.note = note;
    }

    public void insertNote(int id){
        StringBuilder strb = new StringBuilder();
        for (String s:note){
            strb.append(s).append('\n');
        }
        try (Connection con = DriverManager.getConnection(DB_URL);
            Statement stmt = con.createStatement();){
            stmt.executeUpdate("INSERT INTO notes (note, user_id) VALUE(\"" + strb + "\"," + id +")");
        } catch (SQLException e) {
            e.printStackTrace();
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


    public static ArrayList<String> getNote(int id) {
        ArrayList<String> note = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT notes FROM note WHERE user_id=\"" + id + "\";");) {
            while (rs.next()) {
                note.add(rs.getString(2));
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
                ", note=" + Arrays.toString(note) +
                '}';
    }

}
