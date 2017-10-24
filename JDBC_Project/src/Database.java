/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

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
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JDBC_Project;create=true;user=APP;pass=APP");
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> showAllWritingGroups() throws SQLException {
        ArrayList writingGroups = new ArrayList();
        String getWritingGroup = "SELECT GroupName FROM WritingGroup";
        PreparedStatement statement = conn.prepareStatement(getWritingGroup);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            writingGroups.add(resultSet.getString(1));

        }
        return writingGroups;
    }

    public void showAllGroupsData(String bookWeWant) throws SQLException {
        String getWritingGroup = "SELECT * FROM WritingGroup WHERE GroupName = ?";
       
        PreparedStatement statement = conn.prepareStatement(getWritingGroup);
        statement.setString(1, bookWeWant);
        ResultSet resultset = statement.executeQuery();

        ResultSetMetaData rsmd = resultset.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        
        if(resultset.next() != true){
            System.out.println("Writing Group doesn't exist");
        }
        // Iterate through the data in the result set and display it. 
        while (resultset.next()) {
            //Print one row          
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultset.getString(i) + " "); //Print one element of a row
            }
            System.out.println();//Move to the next line to print the next row.           
        }
    }

    public ArrayList<String> showAllPublishers() throws SQLException {
        ArrayList publishersName = new ArrayList();
        String getPublisherName = "SELECT PublisherName FROM Publisher";
        PreparedStatement statement = conn.prepareStatement(getPublisherName);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            publishersName.add(resultSet.getString(1));

        }
        return publishersName;
    }

    public void showAllPublishersData(String publisherWeWant) throws SQLException {
        String getPublisher = "SELECT * FROM Publisher WHERE PublisherName = ?";

        PreparedStatement statement = conn.prepareStatement(getPublisher);
        statement.setString(1, publisherWeWant);
        
        ResultSet resultset = statement.executeQuery();

        ResultSetMetaData rsmd = resultset.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        if(resultset.next() != true){
            System.out.println("Publisher doesn't exist");
        }
        // Iterate through the data in the result set and display it. 
        while (resultset.next()) {
            //Print one row          
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultset.getString(i) + " "); //Print one element of a row
            }
            System.out.println();//Move to the next line to print the next row.           
        }
    }

    public ArrayList<String> showAllBooks() throws SQLException {
        ArrayList titles = new ArrayList();
        String getTitle = "SELECT bookTitle FROM Book";
        PreparedStatement statement = conn.prepareStatement(getTitle);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            titles.add(resultSet.getString(1));

        }
        return titles;
    }

    public void showAllBooksData(String bookWeWant) throws SQLException {
        String getBookData = "SELECT * FROM Book WHERE BookTitle = ?";
        
        PreparedStatement statement = conn.prepareStatement(getBookData);
        statement.setString(1, bookWeWant);
        ResultSet resultset = statement.executeQuery();

        ResultSetMetaData rsmd = resultset.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        // Iterate through the data in the result set and display it. 
        if(resultset.next() != true){
            System.out.println("Book doesn't exist");
        }
        while (resultset.next()) {
            //Print one row          
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultset.getString(i) + " "); //Print one element of a row
            }
            System.out.println();//Move to the next line to print the next row.           
        }
    }

    public void insertBook(String bookToInsert, int yearPublished, int numOfPages, String publisherName, String writingGroupName) throws SQLException {
        String SQL = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, bookToInsert);
        pstmt.setInt(2, yearPublished);
        pstmt.setInt(3, numOfPages);
        pstmt.setString(4, publisherName);
        pstmt.setString(5, writingGroupName);
        try {
            pstmt.executeUpdate();
           
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("GroupName or PublisherName is incorrect, please try again");
        }

        pstmt.close();
    }

    public void insertPublisher(String publisherName, String publisherAddress, String publisherPhone, String publisherEmail) throws SQLException {
        String SQL = "INSERT INTO Publisher VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, publisherName);
        pstmt.setString(2, publisherAddress);
        pstmt.setString(3, publisherPhone);
        pstmt.setString(4, publisherEmail);
        try {
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("That publisher already exists, please enter in a different publisher");
        }

        pstmt.close();
    }

    public void updateBookPublisher(String oldPublisher, String newPublisher) throws SQLException {
        String SQL = "UPDATE Book SET PublisherName = ? WHERE PublisherName = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, newPublisher);
        pstmt.setString(2, oldPublisher);
        int checker = pstmt.executeUpdate();
        if(checker == 0){
            System.out.println("The publisher specified does not exist");
        }else{
            System.out.println("The publisher was successfully updated");
        }
        pstmt.close();
    }

    public void removeBook(String bookToRemove) throws SQLException {
        String SQL = "DELETE FROM Book WHERE BookTitle = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, bookToRemove);
        int checker = pstmt.executeUpdate();
        if(checker == 0){
            System.out.println("Removal unsuccessful");
        }else{
            System.out.println("Removal successful");
        }
        pstmt.close();
    }
}
