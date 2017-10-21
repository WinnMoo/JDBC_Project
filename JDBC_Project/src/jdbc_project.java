
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean loopChecker = true;
        int userSelection = 0;
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

            userSelection = input.nextInt();
            if (userSelection == 1) {

            } else if (userSelection == 2) {

            } else if (userSelection == 3) {

            } else if (userSelection == 4) {

            } else if (userSelection == 5) {

            } else if (userSelection == 6) {
                
            } else if (userSelection == 7) {
                System.out.println("What is the name of the book you'd like to insert?");
                String bookToInsert = input.nextLine();
                
            } else if (userSelection == 8) {
                System.out.println("What is the name of the new publisher?");
                String newPublisher = input.nextLine();
                
            } else if (userSelection == 9) {
                System.out.println("Which book would you like to remove?");
                String bookToRemove = input.nextLine();
                
            } else if (userSelection == 10) {
                loopChecker = false;
            }

        }

    }

}
