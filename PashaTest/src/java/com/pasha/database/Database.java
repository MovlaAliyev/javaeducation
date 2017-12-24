package com.pasha.database;

import com.pasha.models.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database implements IDatabase{
    private Connection conn      = null;
    private ResultSet  rs        = null;
    private PreparedStatement ps = null;

    public Database() {
    }
    
    private Connection getConnection(){
        Connection conn = null;
        try{
            conn = DatabaseFactory.
                   getInstance().
                   getConnection();
        }catch(SQLException e){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    private void closeConn(){
        try {
            if(!conn.isClosed()) conn.close();
          } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closePs(){
        try {
            if(!ps.isClosed()) ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeRs(){
        try {
            if(!rs.isClosed()) rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<City> searchCity(String pattern){
        City c = new City();
        List<City> list = new ArrayList<>();
        conn = getConnection();
        try {
            ps = conn.prepareStatement("SELECT * FROM city WHERE Name LIKE ? LIMIT 7");
            ps.setString(1, "%" + pattern + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new City(rs.getInt("ID"), 
                        rs.getString("Name"), 
                        rs.getString("CountryCode"), 
                        rs.getString("District")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConn();
            closePs();
            closeRs();
        }
        return list;
    }
    
    public void updateCity(City c){
        conn = getConnection();
        try {
            ps = conn.prepareStatement("UPDATE city SET ID = ? , Name = ? , CountryCode = ?, District = ? WHERE ID = ?");
            ps.setLong(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getCountryCode());
            ps.setString(4, c.getDistrict());
            ps.setLong(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConn();
            closePs();
        }
    }
    
    public List<City> paginate(String pattern, int start, int limit){
       
        List<City> list = new ArrayList<>();
        conn = getConnection();
        try {
            ps   = conn.prepareStatement("SELECT * FROM city WHERE NAME LIKE ? LIMIT ? , ?");
            ps.setString(1, "%" + pattern + "%");
            ps.setInt(2, start);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new City(rs.getInt("ID"), 
                        rs.getString("Name"), 
                        rs.getString("CountryCode"), 
                        rs.getString("District")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConn();
            closePs();
            closeRs();
        }
        return list;
    }
}
