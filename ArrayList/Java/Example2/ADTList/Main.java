import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {

        int num;
        Scanner in = new Scanner(System.in);
        //declaring the ArrayList
        ArrayList numList = new ArrayList(20);
        ArrayList num7List = new ArrayList();
        ArrayList oddList = new ArrayList();
        ArrayList evenList = new ArrayList();

        for(int i=0;i<20;i++) {
            System.out.print("Enter number integer: ");
            num = Integer.parseInt(in.nextLine());

            Number obj = new Number(num);
            numList.add(obj);
        }

        //remove all number can be divided by 7 ad add to num7List
        for(int i=0;i<numList.size();i++) {
            Number n  = (Number)numList.get(i);
            if(n.getN() % 7 == 0) {
                numList.remove(i);
                num7List.add(n);
                i--;
            }
        }

        //display num7list content
        System.out.println("\n\nNum7List content: ");
        for(int i=0;i<num7List.size();i++) {
            Number n = (Number)num7List.get(i);
            System.out.print(n.getN() + " ");
        }

        //sort to even numbers and odd numbers
        for(int i=0;i<num7List.size();i++) {
            Number n = (Number)num7List.get(i);
            if(n.getN() % 2 == 0) {
                evenList.add(n);
            }else {
                oddList.add(n);
            }
        }

        System.out.println("\n\nOddList content: ");
        for(int i=0;i<oddList.size();i++) {
            Number n = (Number)oddList.get(i);
            System.out.print(n.getN() + " ");
        }

        //sorting assending order
        Number temp;
        for(int i=0;i<oddList.size();i++) {
            
            Number n = (Number)oddList.get(i);
            for(int j=i+1; j<oddList.size();j++) {
                Number m = (Number)oddList.get(j);
                if(n.getN() > m.getN()) {
                    temp = n;
                    oddList.set(i,m);
                    oddList.set(j,temp);
                }
            }
        }


        System.out.println("\n\nLowest odd: " + ((Number)oddList.get(0)).getN());
        System.out.println("Highest odd: " + ((Number)oddList.get(oddList.size()-1)).getN());


        //sum all the even number
        int sum = 0;
        for(int i=0;i<evenList.size();i++) {
            Number n = (Number)evenList.get(i);
            sum += n.getN();
        }
        System.out.println("\n\nSum of even: "+ sum);
    }
}