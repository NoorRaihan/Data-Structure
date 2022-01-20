import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) {

		ArrayList <ContractorData>dataList = new ArrayList<>();

		try {
			BufferedReader inpt = new BufferedReader(new FileReader("input.txt"));

			String data = inpt.readLine();

			while(data != null) {
				StringTokenizer token = new StringTokenizer(data, ";");

				String name = token.nextToken();
				String address = token.nextToken();
				int type = Integer.parseInt(token.nextToken());
				double payment = Double.parseDouble(token.nextToken());

				ContractorData obj = new ContractorData(name,address,type,payment);
				dataList.addLast(obj);
				data = inpt.readLine();
			}
			inpt.close();

		}catch (IOException err) {
			System.err.println(err);
		}

		//remove data of civilworks and stored in new arraylist
		ArrayList CivilData = new ArrayList();
		for(int i=0;i<dataList.size();i++) {
			ContractorData data = dataList.get(i);
			if(data.getType() == 1) {
				CivilData.addLast(data);
				dataList.remove(i);
				i--;
			}
		}

		//Find the highest total payment by the contractor na didsplay the contractor details
		ContractorData highest = dataList.get(0);
		for(int i=0;i<dataList.size();i++) {
			ContractorData data = dataList.get(i);
			if(data.getPayment() > highest.getPayment()) {
				highest = data;
			}
		}

		System.out.println("\n\nHighest payment: " + highest.toString());

		//sorting the data followed by name asc in bubble sort
		ContractorData temp;
		for(int i=0;i<dataList.size();i++) {
			
			for(int j=1;j<dataList.size()-i;j++) {
				if(dataList.get(j-1).getName().compareTo(dataList.get(j).getName()) > 0) {
					temp = dataList.get(j-1);
					dataList.set(j-1,dataList.get(j));
					dataList.set(j,temp);	
				}else if(dataList.get(j-1).getName().compareTo(dataList.get(j).getName()) == 0) {
					if(dataList.get(j-1).getType() > dataList.get(j).getType()) {
						temp = dataList.get(j-1);
						dataList.set(j-1,dataList.get(j));
						dataList.set(j,temp);
					}
				}
			}
		}
		System.out.println("\n\nSorted List:");
		for(int i=0;i<dataList.size();i++) {
			System.out.println(dataList.get(i).toString());
		}

		//search the contractor name using binary search
		int left = 0;
		int right = dataList.size()-1;
		int mid = 0;
		int indexFound = -1;
		String key = "Anugerah JDT";

		while(left <= right) {

			mid = (left + right) / 2;
			int comp = key.compareToIgnoreCase(dataList.get(mid).getName());

			if(comp == 0) {
				indexFound = mid;
				break;
			}

			if(comp > 0) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}

		if(indexFound > -1) {
			System.out.println("\n\n" + dataList.get(indexFound).toString());
		}else {
			System.out.println("\n\nContractor for " + key +" not found!");
		}

	}
}
