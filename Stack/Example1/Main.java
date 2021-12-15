import java.util.*;
import java.util.Stack;

public class Main {

	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		//declaring the stack
		Stack numS = new Stack();

		for(int i=0;i<20;i++){
			System.out.print("Enter number:");
			int num = Integer.parseInt(in.nextLine());

			Number obj = new Number(num);
			
			//pushing the object into the stack
			numS.push(obj);
		}

		//display the content of the stack
		//pop all the content of the stack
		//push the popped content into temporary stack
		Stack tempS = new Stack();
		Number obj;

		System.out.println("NumS Listing: ");
		while(!numS.isEmpty()) {
			obj = (Number)numS.pop();
			System.out.print(obj.getN() + " ");
			tempS.push(obj);
		}

		//restoring the content in the temp stack into the original stack
		while(!tempS.isEmpty()) {
			numS.push(tempS.pop());
		}

		//copy all the number that can be divided into 3
		Stack num3S = new Stack();
		while(!numS.isEmpty()) {
			obj = (Number)numS.pop();
			if(obj.getN() % 3 == 0) {
				num3S.push(obj);
			}
			tempS.push(obj);
		}

		while(!tempS.isEmpty()) {
			numS.push(tempS.pop());
		}

		//display the content of both num3S
		System.out.println("\n\nNum3S listing:");
		while(!num3S.isEmpty()) {
			obj = (Number)num3S.pop();
			System.out.print(obj.getN() + " ");
			tempS.push(obj);
		}

		while(!tempS.isEmpty()) {
			num3S.push(tempS.pop());
		}

		//remove in numS and insert all odd numbers and even numbers in evenS and oddS
		Stack evenS = new Stack();
		Stack oddS = new Stack();

		while(!numS.isEmpty()) {
			obj = (Number)numS.pop();
			if(obj.getN() % 2 == 0) {
				evenS.push(obj);
			}else {
				oddS.push(obj);
			}
		}

		//display evenS and oddS
		System.out.println("\n\nEvenS listing:");
		while(!evenS.isEmpty()) {
			obj = (Number)evenS.pop();
			System.out.print(obj.getN() + " ");
			tempS.push(obj);
		}

		while(!tempS.isEmpty()) {
			evenS.push(tempS.pop());
		}


		System.out.println("\n\nOddS listing: ");
		while(!oddS.isEmpty()) {
			obj = (Number)oddS.pop();
			System.out.print(obj.getN() + " ");
			tempS.push(obj);
		}

		while(!tempS.isEmpty()) {
			oddS.push(tempS.pop());
		}

		//display largest and smallest number in oddS
		Number smol = (Number)oddS.peek();
		Number big = (Number)oddS.peek();
		while(!oddS.isEmpty()) {
			obj = (Number)oddS.pop();

			if(obj.getN() < smol.getN()) {
				smol = obj;
			}else if(obj.getN() > big.getN()) {
				big = obj;
			}
		}

		System.out.println("\n\nLargest number in OddS: " + big.getN());
		System.out.println("\nSmollest number is OddS: " + smol.getN());

		//display sum of all the number is evenS
		int sum = 0;
		while(!evenS.isEmpty()) {
			obj = (Number)evenS.pop();
			sum += obj.getN();
		}
		System.out.println("Total sum of evenS: " + sum);
	}
}
