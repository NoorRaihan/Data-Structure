import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        //declaring ArrayList --> by default the size is 10
        ArrayList <Integer> aList = new ArrayList<>(); //generic Integer
        ArrayList <Integer> sList = new ArrayList<>(); //generic Integer

        //insert the data
        //15,115,1,7,90 -->insert at the back
        aList.add(15);
        aList.add(115);
        aList.add(1);
        aList.add(7);
        aList.add(90);

        System.out.println("Insert data at the back: ");
        for(int i=0;i<aList.size();i++) {
            System.out.print(aList.get(i) + " ");
        }

        //add based on index add(index,element)
        //15,1,115,90,7
        aList.add(0,15);
        aList.add(2,115);
        aList.add(1,1);
        aList.add(4,7);
        aList.add(3,90);

        System.out.println("\n\nInsert data based on Index:");
        for(int i=0;i<aList.size();i++) {
            System.out.print(aList.get(i) + " ");
        }
        //replace or modifying the listing set(index, element)
        aList.set(3, 100);
        aList.set(2,800);

        System.out.println("\n\nReplace data based on Index:");
        for(int i=0;i<aList.size();i++) {
            System.out.print(aList.get(i) + " ");
        }

        //remove the data from the list
        for(int i=0;i<aList.size();i++) {
           int n = (Integer)aList.get(i);
           if(n % 5 == 0) {
               aList.remove(i);
               sList.add(n);
               i--;
           }
        }
        System.out.println("\n\nRemove the data from ArrayList:");
        for(int i=0;i<aList.size();i++) {
            System.out.print(aList.get(i) + " ");
        }

        System.out.println("\n\nData removed from the List:");
        for(int i=0;i<sList.size();i++) {
            System.out.print(sList.get(i) + " ");
        }
    }
}
