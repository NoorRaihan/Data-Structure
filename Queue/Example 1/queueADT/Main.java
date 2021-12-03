import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        Queue qNumber = new Queue();

        for(int i=0;i<10;i++) {
            System.out.print("Enter number: ");
            int num = Integer.parseInt(in.nextLine());

            Number obj = new Number(num);
            qNumber.enqueue(obj);
        }

        //sum of all numbers
        Queue temp = new Queue();
        int total = 0;
        while(!qNumber.isEmpty()) {
            Number obj = (Number)qNumber.dequeue();
            total += obj.getN();
            temp.enqueue(obj);
        }

        while(!temp.isEmpty()) {
            qNumber.enqueue(temp.dequeue());
        }

        System.out.println("Sum of all numbers: " + total);

        //get smallest number
        Number smallest = (Number)qNumber.front();
        while(!qNumber.isEmpty()) {
            Number obj = (Number)qNumber.dequeue();
            if(obj.getN() < smallest.getN()) {
                smallest = obj;
            }
            temp.enqueue(obj);
        }

        while(!temp.isEmpty()) {
            qNumber.enqueue(temp.dequeue());
        }

        System.out.println("Smallest Number: " + smallest.getN());

        //remove all number that can be divided by 3
        Queue qThree = new Queue();
        while(!qNumber.isEmpty()) {
            Number obj = (Number)qNumber.dequeue();
            if(obj.getN() % 3 == 0) {
                qThree.enqueue(obj);
            }else {
                temp.enqueue(obj);
            }
        }

        while(!temp.isEmpty()) {
            qNumber.enqueue(temp.dequeue());
        }

        //display all the listing
        System.out.println("\n\nQThree list: ");
        while(!qThree.isEmpty()) {
            Number obj = (Number)qThree.dequeue();
            System.out.print(obj.getN() + " ");
        }

        System.out.println("\n\nQNumber list: ");
        while(!qNumber.isEmpty()) {
            Number obj = (Number)qNumber.dequeue();
            System.out.print(obj.getN() + " ");
        }

    }
}