import java.io.*;
import java.util.*;

public class Main {

    public static void main(String [] args) {

        ArrayList <Book>bookList = new ArrayList<>(); 

        try {
            BufferedReader inpt = new BufferedReader(new FileReader("bookInput.txt"));

            String data = inpt.readLine();

            while(data != null){
                StringTokenizer trm = new StringTokenizer(data, ";");

                String title = trm.nextToken();
                int year = Integer.parseInt(trm.nextToken());

                Book obj = new Book(title,year);
                bookList.add(obj);

                data = inpt.readLine();
            }

            inpt.close();

        }catch (IOException err) {
            System.err.print(err);
        }

        System.out.println("\nList of Books("+bookList.size()+" record(s))");
        for(int x=0;x<bookList.size();x++) {
            System.out.println("#"+(x+1)+": "+bookList.get(x).toString());
        }
        

        //bubble sort
        Book temp;

        // for(int i=0; i<bookList.size();i++) {

        //     Book n = bookList.get(i);
        //     String a = n.getTitle();

        //     for(int j=i+1;j<bookList.size();j++) {
        //          Book m = bookList.get(i+1);
        //          String b = m.getTitle();

        //          if(a.compareTo(b) > 0) {
        //              temp = n;
        //              bookList.set(i,m);
        //              bookList.set(j,temp);
        //          }
        //     }
        // }

        // for(int i=0;i<bookList.size()-1;i++) {
        //     Book n = bookList.get(i);
        //     String a = n.getTitle();
        //     Book m = bookList.get(i+1);
        //     String b = m.getTitle();

        //     if(a.compareTo(b) > 0) {
        //         temp = n;
        //         bookList.set(i,m);
        //         bookList.set(i+1,temp);
        //     }
        // }

        //sorting the title
        for(int i=0;i<bookList.size();i++) {

            for(int j=1;j<bookList.size()-i;j++) {

                if(bookList.get(j-1).getTitle().compareTo(bookList.get(j).getTitle()) > 0) {
                    temp = bookList.get(j-1);
                    bookList.set(j-1,bookList.get(j));
                    bookList.set(j,temp);
                    
                }
            }
        }

        //sorting the year
        Book temp2;
        for(int i=1;i<bookList.size();i++) {

            if(bookList.get(i-1).getTitle().charAt(0) == bookList.get(i).getTitle().charAt(0)) {
                if(bookList.get(i-1).getYear() > bookList.get(i).getYear()) {
                    temp2 = bookList.get(i-1);
                    bookList.set(i-1,bookList.get(i));
                    bookList.set(i, temp2);
                }
            }
        }

        

        System.out.println("\n\nSorting in assending order");
        System.out.println("List of Books("+bookList.size()+" record(s))");
        for(int i=0;i<bookList.size();i++) {
            System.out.println("#"+(i+1)+": "+bookList.get(i).toString());
        }
        

        //searching using binary search
        int left = 0, right = bookList.size()-1;
        String key = "Neural Networks";

        int indexFound = -1;

        while(left <= right) {
            int mid = left + (right-1) / 2;

            int comp = key.compareTo(bookList.get(mid).getTitle());

            //found in the middleeeeeee
            if(comp == 0) {
                indexFound = mid;
                break;
            }

            //larger than 0, ignore the left halfff
            if(comp > 0) {
                left = mid + 1;
            }else { //lower than 0, ignore the right halffff
                right = mid -1;
            }

        }

        System.out.println("\nSearch for " + key);
        if(indexFound > -1) {
            System.out.println(key + " found on index " + indexFound);
        }else {
            System.out.println("Key does not found in the list!");
        }
        
    }
}