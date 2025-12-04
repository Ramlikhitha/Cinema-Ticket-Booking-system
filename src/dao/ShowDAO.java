package dao;
import model.Show;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShowDAO {
    public boolean isShowConflict(int auditorium_id,String show_time){
        String sql="select id from shows where auditorium_id= ? and show_time= ?;";

        try {
            Connection con= DBConnection.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,auditorium_id);
            ps.setString(2,show_time);

            ResultSet rs= ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error while checking show conflict");
            throw new RuntimeException(e);
        }


    }
    //insert new Show
    public void createShow(Show s){
        System.out.println("Checking if another show is already scheduled...");
        boolean conflict=isShowConflict(s.getAuditorium_id(),s.getShow_time());
        if (conflict){
            System.out.println("Can't create show! ");
            System.out.println("Another show is already booked in this auditorium at the same time.");
            System.out.println("Try choosing a different time slot. \n");
            return;
        }
        System.out.println("No conflict found! ");

        String sql="Insert into shows(movie_id,auditorium_id,show_time,end_time,status)values(?,?,?,?,'ACTIVE');";

        try {
            Connection con =DBConnection.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,s.getMovie_id());
            ps.setInt(2,s.getAuditorium_id());
            ps.setString(3,s.getShow_time());
            ps.setString(4,s.getEnd_time());

            ps.executeUpdate();
            System.out.println("Show created Successfully!..");

        } catch (SQLException e) {
            System.out.println("Error while inserting show into database");
            throw new RuntimeException(e);
        }


    }
}
