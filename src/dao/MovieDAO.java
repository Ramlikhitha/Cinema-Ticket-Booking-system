package dao;

import model.Movie;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {

    public boolean movieExists(String title, String language) {

        Connection con = DBConnection.getConnection();
        String sql = "SELECT id FROM movies WHERE title = ? AND language = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, language);

            ResultSet rs = ps.executeQuery();

            return rs.next();   // true = movie exists

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // INSERT MOVIE
    public void addMovie(Movie m) {

        if (movieExists(m.getTitle(), m.getLanguage())) {
            System.out.println("Movie already Exists!");
            return;
        }

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO movies(title, language, duration_min, certification) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, m.getTitle());
            ps.setString(2, m.getLanguage());
            ps.setInt(3, m.getDuration_min());
            ps.setString(4, m.getCertification());

            ps.executeUpdate();
            System.out.println("Movie Added Successfully!");

        } catch (SQLException e) {
            System.out.println("Something happened during insertion");
            e.printStackTrace();
        }
    }
}
