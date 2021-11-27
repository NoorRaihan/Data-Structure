import java.util.Scanner;
public class Main {

    public static void main(String [] args) {
        //declare
        Scanner in = new Scanner(System.in);
        ArrayList <Athlete>athList = new ArrayList<>();
        int SIZE = 7;

        for(int i=0;i<SIZE;i++) {
            double [] distance = new double[3];

            System.out.print("\nAthlete Name: ");
            String name = in.nextLine();
            
            for(int j=0;j<3;j++){
                System.out.print("Distance " + (j+1) + ": ");
                distance[j] = Double.parseDouble(in.nextLine());
            }

            Athlete obj = new Athlete(name,distance);
            athList.addLast(obj);
        }

        //display all the athlete
        System.out.println("============================================");
        System.out.println("Athlete List: ");
        for(int i=0;i<athList.size();i++) {
            System.out.println(athList.get(i));
        }

        //display the longest(winner)
        System.out.println("============================================");
        Athlete longest = athList.get(0);
        for(int i=0;i<athList.size();i++) {
            Athlete obj = athList.get(i);
            if(obj.getBestAttempt() > longest.getBestAttempt()) {
                longest = obj;
            }
        }
        System.out.println("\nWinner: " + longest.toString());


        LinkedList consistentAthlete = new LinkedList();

        //get the average of all best jumps
        double total = 0.00;
        double average = 0.00;
        for(int i=0;i<athList.size();i++) {
           total += athList.get(i).getBestAttempt();
        }
        average = total / athList.size();

        //check for the consistent athelete
        for(int i=0;i<athList.size();i++) {
            Athlete obj = athList.get(i);
            if(obj.getAverage() > average) {
                consistentAthlete.insertAtBack(obj);
                athList.remove(i);
            }
        }

        //find shortest jump athlete
        System.out.println("============================================");
        Athlete curr = (Athlete)consistentAthlete.getFirst();
        Athlete shortest = curr;
        while(curr != null) {
            if(curr.getBestAttempt() < shortest.getBestAttempt()){
                shortest = curr;
            }
            curr = (Athlete)consistentAthlete.getNext();
        }
        System.out.println("Shortest Jump Athlete: " + shortest.toString());

        //display all the info in consistent list
        System.out.println("============================================");
        System.out.println("Consistent List: ");
        curr = (Athlete)consistentAthlete.getFirst();
        while(curr != null) {
            System.out.println(curr.toString());
            curr = (Athlete)consistentAthlete.getNext();
        }
    }
}