/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Winn
 */
public class Database {
    Connection conn; //once a connection is established it stays
    //as long as the code that created this
    //instance does not exit

    Statement stat;  //stat can be reused in every operation
    String query;
    public Database() throws IOException, ClassNotFoundException,
            SQLException, Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Derby driver not found.");
        }
        //In the string to getConnection you may replace "MP3Player"      
        try {
            //conn needs to be updated for the JDBC url for books/publishers instead of the one that's in it now
            conn = DriverManager.getConnection("jdbc:derby://localhost/MP3Player;create=true;user=APP;pass=APP");
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showAllWritingGroups(){
        
    }
    public void showAllGroupsData(){
        
    }
    public void showAllPublishers(){
        
    }
    public void showAllPublishersData(){
        
    }
    public void showAllBooks(){
        
    }
    public void showAllBooksData(){
        
    }
    public void insertBook() throws SQLException{
        String SQL = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        
    }
    public void isertPublisher(){
        
    }
    public void removeBook(String bookToRemove) throws SQLException{
        String SQL = "DELETE FROM Book WHERE BookTitle = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, bookToRemove);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
