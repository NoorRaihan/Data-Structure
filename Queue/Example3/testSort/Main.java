public class Main {

    public static void main(String [] args) {

        int [] num = {3,5,12,13,16,6,8,10,15};
        LinkedList numList = new LinkedList();

        for(int i=0;i<num.length;i++) {
            Number obj = new Number(num[i]);
            numList.insertAtBack(obj);
        }

        //display
        Number data = (Number)numList.getHead();
        numList.bubbleSort();
        while(data != null) {
            System.out.print(data.getNum() + " ");
            data = (Number)numList.getNext();
        }

    }
}