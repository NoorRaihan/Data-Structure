import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    
    public static void main(String [] args) {
        ArrayList <Staff>listStaff = new ArrayList<>();
        ArrayList <Staff>sgmtList = new ArrayList<>();

        try {
            BufferedReader inpt = new BufferedReader(new FileReader("stafflist.txt"));
            String data = inpt.readLine();

            while(data != null) {
                StringTokenizer trm = new StringTokenizer(data,";");
                
                long id = Long.parseLong(trm.nextToken());
                String name = trm.nextToken();
                int year = Integer.parseInt(trm.nextToken());
                String loc = trm.nextToken();

                Staff obj = new Staff(id,name,year,loc);
                listStaff.addLast(obj);

                data = inpt.readLine();
            }
            inpt.close();
        }catch (IOException e) {
            System.err.println(e);
        }

        System.out.println("|\tID\t|" + "\tName\t|" + "\tYear\t|" + "\tLocality\t|");
        for(int i=0; i<listStaff.size();i++) {
            System.out.print("\n\t"+listStaff.get(i).getStaffId() + "\t");
            System.out.print(listStaff.get(i).getStaffName() + "\t");
            System.out.print(listStaff.get(i).getYearOfService() + "\t");
            System.out.print(listStaff.get(i).getLocality());
        }

        int count10 = 0;
        for(int i=0; i<listStaff.size();i++) {
            if(listStaff.get(i).getYearOfService() > 10) {
                count10++;
            }
        }
        System.out.println("\n\nNum Staff more than 10 years of service: " + count10);

        //sorting
        Staff temp = null;
        for(int i=0;i<listStaff.size();i++) {
            for(int j=1 ; j<listStaff.size()-i;j++) {
                if(listStaff.get(j).getStaffId() < listStaff.get(j-1).getStaffId()) {
                    temp = listStaff.get(j);
                    listStaff.set(j,listStaff.get(j-1));
                    listStaff.set(j-1,temp);
                }
            }
        }

        System.out.println("|\tID\t|" + "\tName\t|" + "\tYear\t|" + "\tLocality\t|");
        for(int i=0; i<listStaff.size();i++) {
            System.out.print("\n\t"+listStaff.get(i).getStaffId() + "\t");
            System.out.print(listStaff.get(i).getStaffName() + "\t");
            System.out.print(listStaff.get(i).getYearOfService() + "\t");
            System.out.print(listStaff.get(i).getLocality());
        }


        //binary serach staff id
        int left = 0;
        int right = listStaff.size()-1;
        int mid =0;
        int indexFound = -1;
        long key = 156993;

        while(left <= right) {

            mid = (left + right) / 2;
            int comp = Long.compare(key,listStaff.get(mid).getStaffId());
            
            if(comp == 0) {
                indexFound = mid;
                break;
            }
            
            if(comp > 0) {
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

        if(indexFound > -1) {
            System.out.println("\nData Locality replaced!");
            listStaff.get(indexFound).setLocality("Shah Alam");
        }else {
            System.out.println("\nData not found in the list");
        }
        

        System.out.println("\n\n|\tID\t|" + "\tName\t|" + "\tYear\t|" + "\tLocality\t|");
        for(int i=0; i<listStaff.size();i++) {
            System.out.print("\n\t"+listStaff.get(i).getStaffId() + "\t");
            System.out.print(listStaff.get(i).getStaffName() + "\t");
            System.out.print(listStaff.get(i).getYearOfService() + "\t");
            System.out.print(listStaff.get(i).getLocality());
        }

        for(int i=0; i<listStaff.size();i++) {
            if(listStaff.get(i).getLocality().equalsIgnoreCase("segamat")){
                sgmtList.addLast(listStaff.get(i));
            }
        }

        System.out.println("\nSegamat List::");
        System.out.println("|\tID\t|" + "\tName\t|" + "\tYear\t|" + "\tLocality\t|");
        for(int i=0; i<sgmtList.size();i++) {
            System.out.print("\n\t"+sgmtList.get(i).getStaffId() + "\t");
            System.out.print(sgmtList.get(i).getStaffName() + "\t");
            System.out.print(sgmtList.get(i).getYearOfService() + "\t");
            System.out.print(sgmtList.get(i).getLocality());
        }
    }
}