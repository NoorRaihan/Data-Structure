import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String [] args) {


        //create LinkedList object
        LinkedList numList = new LinkedList();

        //insert element --> add to the back
        numList.add(8);
        numList.add(10);
        numList.add(15);

        //insert element at the head/beginning 
        numList.addFirst(19);

        //insert element --> to the tail
        numList.addLast(7);

        //retrieve the element
        Iterator i = numList.iterator(); //create an Iterator object

        //loop using hasNext to check the next node if not NULL
        while(i.hasNext()) {
            System.out.print(i.next() + " ");
        }

        //retrieve using ListIterator
        ListIterator li = numList.listIterator();
        int max  = Integer.parseInt(numList.getFirst().toString());

        while(li.hasNext()) {
            int num = Integer.parseInt(li.next().toString());

            if(num > max) {
                max = num;
            }
        }
        System.out.println("\nLargest value: " + max);

        System.out.println();
        //retrieve the linkedlist but backward
        while(li.hasPrevious()) {
            System.out.print(li.previous() + " ");
        }


    }
}