import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String [] args) {
        
        Scanner in = new Scanner(System.in);

        BSTNumber treeN = new BSTNumber();
        int intNumber;

        for(int i=0;i<10;i++) {

            System.out.print("Enter integer number: ");
            intNumber = Integer.parseInt(in.next());

            Number obj = new Number(intNumber);
            treeN.insertNode(obj);
        }

        //display the number in ascending order
        System.out.println("\n\nList of numbers in ascending order: ");
        treeN.displayNumber();

        //display the sum of all numbers
        int sum = treeN.calcSum();
        System.out.println("\n\nSum of all numbers: " + sum);

        //display the number of odd numbers
        treeN.countOdd();

        //display the smallest number
        System.out.print("\n\nThe smallest number: " + treeN.findSmallest());

        //search a number
        System.out.println("\n\nEnter the number to search: ");
        int nSearch = Integer.parseInt(in.nextLine());

        Number n = treeN.searchNumber(nSearch);

        if(n != null) {
            System.out.println(nSearch + " is found!!");
        }
        else {
            System.out.print(nSearch + " is not found!!");
        }
    }

}
