
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Winn
 */
public class jdbc_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        Scanner input = new Scanner(System.in);
        Boolean loopChecker = true;
        String userSelection = "";
        Database database = new Database();

        while (loopChecker) {
            System.out.println("Please select an option:");
            System.out.println("1. Show all writing groups");
            System.out.println("2. Show all data for a group");
            System.out.println("3. Show all publishers");
            System.out.println("4. Show all the data for a publisher");
            System.out.println("5. Show all book titles");
            System.out.println("6. Show all data for a book ");
            System.out.println("7. Insert a new book");
            System.out.println("8. Insert a new publisher");
            System.out.println("9. Remove a book");
            System.out.println("10. Quit");

            userSelection = input.nextLine();
          

            try {
                int userSelectionConverted = Integer.parseInt(userSelection);
                if (userSelectionConverted == 1) {
                ArrayList writingGroups = database.showAllWritingGroups();
                for (int i = 0; i < writingGroups.size(); i++) {
                    Object groupNames = writingGroups.get(i);
                    String groupNamesConverted = groupNames.toString();
                    System.out.println(groupNamesConverted);
                }
            } else if (userSelectionConverted == 2) {
                database.showAllGroupsData();

            } else if (userSelectionConverted == 3) {
                ArrayList publisherNames = database.showAllPublishers();
                for (int i = 0; i < publisherNames.size(); i++) {
                    Object names = publisherNames.get(i);
                    String namesConverted = names.toString();
                    System.out.println(namesConverted);
                }
            } else if (userSelectionConverted == 4) {
                database.showAllPublishersData();

            } else if (userSelectionConverted == 5) {
                ArrayList booktitles = database.showAllBooks();
                for (int i = 0; i < booktitles.size(); i++) {
                    Object titles = booktitles.get(i);
                    String titlesConverted = titles.toString();
                    System.out.println(titlesConverted);
                }
            } else if (userSelectionConverted == 6) {
                database.showAllBooksData();

            } else if (userSelectionConverted == 7) {
                System.out.println("What is the name of the book you'd like to insert?");
                String bookToInsert = input.nextLine();

                System.out.println("What is the year that the book was published?");
                int yearPublished = input.nextInt();

                System.out.println("How many pages are in the book?");
                int numOfPages = input.nextInt();

                System.out.println("Name of publisher?");
                input.nextLine();
                String publisherName = input.nextLine();

                System.out.println("Name of writing group?");
                String writingGroupName = input.nextLine();

                database.insertBook(bookToInsert, yearPublished, numOfPages, publisherName, writingGroupName);

            } else if (userSelectionConverted == 8) {
                System.out.println("What is the name of the new publisher?");
                String newPublisher = input.nextLine();
                System.out.println("What is the publisher's address?");
                String publisherAddress = input.nextLine();
                System.out.println("What is the publisher phone number?");
                String publisherPhone = input.nextLine();
                System.out.println("Publisher Email?");
                String publisherEmail = input.nextLine();
                System.out.println("What is the name of the publisher being bought out?");
                String oldPublisher = input.nextLine();

                database.insertPublisher(newPublisher, publisherAddress, publisherPhone, publisherEmail);
                database.updateBookPublisher(oldPublisher, newPublisher);

            } else if (userSelectionConverted == 9) {
                System.out.println("Which book would you like to remove?");
                String bookToRemove = input.nextLine();
                database.removeBook(bookToRemove);

            } else if (userSelectionConverted == 10) {
                loopChecker = false;
            } else {
                System.out.println("Invalid Selection");
            }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number");
            }
        }
        
    }

}
