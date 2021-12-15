import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String [] args) {

		LinkedList dataList = new LinkedList();
		
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
				dataList.insertAtBack(obj);
				data = inpt.readLine();
			}
			inpt.close();

		}catch (IOException err) {
			System.err.println(err);
		}

		System.out.println("\n\nFOUND!!");
		//remove data of civilworks and stored in new arraylist
		LinkedList CivilData = new LinkedList();
		LinkedList temp = new LinkedList();

		while(!dataList.isEmpty()) {
			ContractorData removed = (ContractorData)dataList.removeFromBack();
			if(removed.getType() == 1) {
				CivilData.insertAtBack(removed);
			}else{
				temp.insertAtBack(removed);
			}
		}

		while(!temp.isEmpty()) {
			dataList.insertAtBack(temp.removeFromFront());
		}

		System.out.println("\n\nFOUND!!");

		//Find the highest total payment by the contractor na didsplay the contractor details
		ContractorData highest = (ContractorData)dataList.getFirst();
		ContractorData data = (ContractorData)dataList.getFirst();
		while(data != null) {
			if(data.getPayment() > highest.getPayment()) {
				highest = data;
			}
			data = (ContractorData)dataList.getNext();
		}

		System.out.println("\n\nHighest payment: " + highest.toString());
		
		//search the contractor name 
		data = (ContractorData)dataList.getFirst();
		while(data != null) {
			if(data.getName().equalsIgnoreCase("OBU OBU")) {
				System.out.println("\n\nFOUND!!" + data.toString());
				break;
			}
			data = (ContractorData)dataList.getNext();
		}
	}
}
