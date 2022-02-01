import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String [] args) {
        
        Scanner in = new Scanner(System.in);
        BSTBook booktree = new BSTBook();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
            String input = br.readLine();

            while(input != null) {
                StringTokenizer token = new StringTokenizer(input,";");

                String an = token.nextToken();
                String title = token.nextToken();
                String subject = token.nextToken();
                double price = Double.parseDouble(token.nextToken());
                int year = Integer.parseInt(token.nextToken());

                Book obj = new Book(an,title,subject,price,year);
                booktree.insertNode(obj);

                input = br.readLine();
            }
            br.close();
        }
        catch (Exception err) {
            System.err.println(err);
        }

        System.out.println("Management book: " + booktree.countSubject("Management"));
        System.out.println("Total Price All Books : RM" + booktree.totalPriceAll());
        System.out.println("Total Price for CS : RM" + booktree.totalPrice("Computer Science"));
        booktree.searchBookByAN("CS0080");
        booktree.searchBookbyYP(2018);
    }
}
