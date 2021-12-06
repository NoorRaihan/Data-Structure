import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) {
        
        Queue biggestLoser = new Queue();

        try {
            BufferedReader inpt = new BufferedReader(new FileReader("contestant.txt"));
            String data;
            while ((data = inpt.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(data,";");

                int id = Integer.parseInt(token.nextToken());
                String name = token.nextToken();
                char gender = token.nextToken().charAt(0);
                double weight = Double.parseDouble(token.nextToken());

                Contestant obj = new Contestant(id,name,gender,weight);
                biggestLoser.enqueue(obj);
            }
        }catch(Exception err) {
            System.err.println(err);
        }

        //remove more than 100kg
        Queue temp = new Queue();
        Queue overWeight = new Queue();

        while(!biggestLoser.isEmpty()) {
            Contestant obj = biggestLoser.dequeue();
            if(obj.getContestantWeight() > 100) {
                overWeight.enqueue(obj);
            }else {
                temp.enqueue(obj);
            }
        }

        while(!temp.isEmpty()) {
            biggestLoser.enqueue(temp.dequeue());
        }

        //seperate the male and female
        LinkedList maleContestant = new LinkedList();
        LinkedList femaleContestant = new LinkedList();

        while(!biggestLoser.isEmpty()) {
            Contestant obj = biggestLoser.dequeue();
            if(obj.getContestantGender() == 'M') {
                maleContestant.insertAtBack(obj);
            }else {
                femaleContestant.insertAtBack(obj);
            }
            temp.enqueue(obj);
        }

        while(!temp.isEmpty()) {
            biggestLoser.enqueue(temp.dequeue());
        }

        //display the name and weight 
        Contestant data = maleContestant.getFirst();
        Contestant smallM = maleContestant.getFirst();
        while(data != null) {
            
            if(data.getContestantWeight() < smallM.getContestantWeight()) {
                smallM = data;
            }
            data = maleContestant.getNext();
        }

        data = femaleContestant.getFirst();
        Contestant smallP = femaleContestant.getFirst();
        while(data != null) {
            
            if(data.getContestantWeight() < smallP.getContestantWeight()) {
                smallP = data;
            }
            data = femaleContestant.getNext();
        }

        System.out.print("\n\nMale Winner: " + smallM.toString());
        System.out.println("\n\nFemale Winner: " + smallP.toString());

        data = femaleContestant.getFirst();
        Contestant founded = null;
        while(data != null) {
            
            if(data.getContestantName().equalsIgnoreCase("Adira Imani Zamri")) {
                founded = data;
            }
            data = femaleContestant.getNext();
        }
        
        if(founded != null) {
            System.out.println("\n\n" + founded.toString());
        }else{
            System.out.println("\n\nUser not found!");
        }


    }

}