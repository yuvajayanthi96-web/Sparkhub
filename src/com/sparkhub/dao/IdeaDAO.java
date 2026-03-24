package com.sparkhub.dao;

import java.sql.*;
import com.sparkhub.util.DBConnection;

public class IdeaDAO {

    // ✅ ADD IDEA
    public void addIdea(String username, String idea) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) return;

            String sql = "INSERT INTO ideas(username, idea) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, idea);

            ps.executeUpdate();

        } catch (Exception e) {
            // silent
        }
    }

    // ✅ VIEW OTHER IDEAS
    public String[] getOtherIdeas(String username) {
        String arr[] = new String[100];
        int i = 0;

        try {
            Connection con = DBConnection.getConnection();
            if (con == null) return arr;

            String sql = "SELECT * FROM ideas WHERE username != ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                arr[i] = rs.getString("username") + " : " + rs.getString("idea");
                i++;
            }

        } catch (Exception e) {
            // silent
        }

        return arr;
    }

    // ✅ SEARCH IDEA
    public void searchIdea(String keyword) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) return;

            String sql = "SELECT * FROM ideas WHERE idea LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== SEARCH RESULTS =====");

            while (rs.next()) {
                System.out.println(rs.getString("username") + " : " + rs.getString("idea"));
            }

        } catch (Exception e) {
            // silent
        }
    }

    // ✅ EDIT IDEA
    public void editIdea(String username, String oldIdea, String newIdea) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) return;

            String sql = "UPDATE ideas SET idea=? WHERE username=? AND idea=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newIdea);
            ps.setString(2, username);
            ps.setString(3, oldIdea);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Idea Updated ✅");
            } else {
                System.out.println("No matching idea ❌");
            }

        } catch (Exception e) {
            // silent
        }
    }
}