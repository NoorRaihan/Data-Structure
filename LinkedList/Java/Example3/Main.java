import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        LinkedList numLL = new LinkedList();

        for(int i=0;i<10;i++) {
            System.out.print("Enter num: ");
            int num = Integer.parseInt(input.nextLine());

            Number a = new Number(num);
            numLL.insertAtFront(a);
        }

        LinkedList num5LL = new LinkedList();
        LinkedList temp = new LinkedList();

        Number remove;
        remove = (Number)numLL.getFirst();

        while(remove != null) {
            System.out.print(remove.getN());
            remove = (Number)numLL.getNext();
        }

        while(!numLL.isEmpty()) {
            remove = (Number)numLL.removeFromBack();
            if(remove.getN() % 5 == 0) {
                num5LL.insertAtBack(remove);
            }else {
                temp.insertAtBack();
            }
        }

        while(!temp.isEmpty()) {
            numLL.insertAtFront(temp.removeFromBack);
        }
    }
}
