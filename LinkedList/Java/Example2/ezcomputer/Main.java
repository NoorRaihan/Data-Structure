import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    static double calcDiscount(double price) {
        double discount = 0;

        if(price < 2000){
            discount = price * 0.10;
        }else if(price >= 2000 && price <= 3000) {
            discount = price * 0.15;
        }else if(price > 3000) {
            discount = price * 0.20;
        }

        return (price - discount);
    }

    public static void main(String [] args) {

        //declare
        Scanner in = new Scanner(System.in);
        LinkedList <Computer>compList = new LinkedList<>();
        DecimalFormat df = new DecimalFormat("#0.00");
        int totalComputer = 0;

        System.out.print("How many computer want to be inserted: ");
        totalComputer = Integer.parseInt(in.nextLine());

        for(int i=0;i<totalComputer;i++) {
            System.out.print("\nComputer brand: ");
            String brand = in.nextLine();

            System.out.print("Serial Number: ");
            String serialNo = in.nextLine();

            System.out.print("Year Manufactured: ");
            int year = Integer.parseInt(in.nextLine());

            System.out.print("Type [desktop/notebook]: ");
            String type = in.nextLine();
            type = type.toLowerCase();

            System.out.print("Price: RM");
            double price = Double.parseDouble(in.nextLine());

            Computer obj = new Computer(brand,serialNo,year,type,price);
            compList.add(obj);
        }

        //calculate and display
        ListIterator list = compList.listIterator();

        
        while(list.hasNext()) {
            Computer compObj = (Computer)list.next();
            System.out.println(compObj.toString());
            System.out.println("Discounted Price: RM" + df.format(calcDiscount(compObj.getPrice())));
        }

        System.out.println("========================================================");

        list = compList.listIterator();
        Computer highest = compList.getFirst(); 
        while(list.hasNext()) {
            Computer compObj = (Computer)list.next();
            if(compObj.getBrand().equalsIgnoreCase("Acer") && compObj.getType().equals("notebook")) {
                if(compObj.getPrice() > highest.getPrice()) {
                    highest = compObj;
                }
            }
        }

        System.out.println(highest.toString());

        System.out.println("========================================================");
        LinkedList <Computer>notebookList = new LinkedList<>();
        LinkedList <Computer>desktopList = new LinkedList<>();

        list = compList.listIterator();
        while(list.hasNext()) {
            Computer compObj = (Computer)list.next();
            if(compObj.getType().equals("notebook")) {
                notebookList.add(compObj);
            }else {
                desktopList.add(compObj);
            }
        }

        ListIterator noteList = notebookList.listIterator();
        ListIterator deskList = desktopList.listIterator();

        while(noteList.hasNext()) {
            Computer compObj = (Computer)noteList.next();
            System.out.println(compObj.toString());
        }

        System.out.println("========================================================");
        while(deskList.hasNext()) {
            Computer compObj = (Computer)deskList.next();
            System.out.println(compObj.toString());
        }
    }
}