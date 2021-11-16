import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        LinkedList coordinatorList = new LinkedList();
        Scanner in = new Scanner(System.in);
        int SIZE = 3;

        for(int i=0;i<SIZE ;i++) {
            
            System.out.print("\nCoordinator name: ");
            String name = in.nextLine();

            System.out.print("Program name: ");
            String program = in.nextLine();

            System.out.print("Faculty Name: ");
            String faculty = in.nextLine();

            System.out.print("Total Students: ");
            int total = Integer.parseInt(in.nextLine());

            System.out.print("Phone Number: ");
            String phone = in.nextLine();

            Coordinator obj = new Coordinator(name,program,faculty,total,phone);
            coordinatorList.insertAtBack(obj);
        }

        //retrieve the data
        Coordinator curr = (Coordinator)coordinatorList.getFirst();
        while(curr != null) {
            if(curr.getFaculty().equalsIgnoreCase("computer and mathematical sciences")){
                System.out.println(curr.toString());
            }
            curr = (Coordinator)coordinatorList.getNext();
        }

        curr = (Coordinator)coordinatorList.getFirst();
        int count = 0;
        int total = 0;
        while(curr != null) {
            total += curr.getStudents();
            count++;
            curr = (Coordinator)coordinatorList.getNext();
        }
        double average = total / count;
        System.out.println("================================================");
        System.out.println("\nAverage all students: " + average);

        Coordinator highest = (Coordinator)coordinatorList.getFirst();
        curr = (Coordinator)coordinatorList.getFirst();
        while(curr != null) {
            if(curr.getStudents() > highest.getStudents()) {
                highest = curr;
            }
            curr = (Coordinator)coordinatorList.getNext();
        }
        System.out.println("================================================");
        System.out.println("\nHighest:" + highest);

        LinkedList businessList = new LinkedList();
        LinkedList temp = new LinkedList();
        Coordinator removed;
        curr = (Coordinator)coordinatorList.getFirst();

        while(!coordinatorList.isEmpty()) {
            removed = (Coordinator)coordinatorList.removeFromFront();
            if(removed.getFaculty().equalsIgnoreCase("Business Management")) {
                businessList.insertAtBack(removed);
            }else {
                temp.insertAtBack(curr);
            }
        }

        curr = (Coordinator)coordinatorList.getFirst();
        while(!temp.isEmpty()) {
            coordinatorList.insertAtBack(temp.removeFromFront());
        }

        curr = (Coordinator)coordinatorList.getFirst();
        System.out.println("================================================");
        while(curr != null) {
            System.out.println(curr.toString());
            curr = (Coordinator)coordinatorList.getNext();
        }

        curr = (Coordinator)businessList.getFirst();
        System.out.println("================================================");
        while(curr != null) {
            System.out.println(curr.toString());
            curr = (Coordinator)businessList.getNext();
        }
    }
}
