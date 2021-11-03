rimport java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {

        //declaring scanner and ArrayList
        Scanner in  = new Scanner(System.in);
        ArrayList <Book> Book1 = new ArrayList<>();
        ArrayList <Book> Book2 = new ArrayList<>();
        int SIZE = 5;

        //ask 10 input
        for(int i=0;i<SIZE;i++) {

            System.out.print("Book Title: ");
            String title = in.nextLine();

            System.out.print("Author: ");
            String author = in.nextLine();

            System.out.print("Year Published: ");
            int year = Integer.parseInt(in.nextLine());

            System.out.print("Book Price: ");
            double price = Double.parseDouble(in.nextLine());

            Book obj = new Book(title,author,year,price);

            Book1.add(obj);
        }

        //search for 2002 book
        for(int i=0;i<Book1.size();i++) {
            
            if(Book1.get(i).getYearPublished() == 2002) {
                //create new obj
                Book obj = new Book("Data Structures using Java","D.S. Malik", 2003, 65.00);
                Book1.set(i,obj);
            }
        }

        //find the lowest price
        Book lowest = Book1.get(0);
        for(int i=0;i<Book1.size();i++) {
            if(Book1.get(i).getPrice() <= lowest.getPrice()) {
                lowest = Book1.get(i);
            }
        }

        //display the lowest
        System.out.println("Lowest Book Price");
        lowest.PrintBook();

        for(int i=0;i<Book1.size();i++) {
            Book obj = Book1.get(i);
            if(obj.getYearPublished() < 2008) {
                Book2.add(obj);
                Book1.remove(i);
                i--;
            }
        }

        //find sum of each list
        double sumBook = 0.00;
        
        for(int i=0;i<Book1.size();i++) {
            sumBook += Book1.get(i).getPrice();
        }
        for(int i=0;i<Book2.size();i++) {
            sumBook += Book2.get(i).getPrice();
        }
        System.out.println("Sum book 1: RM" + sumBook);
    }
}