import java.util.Arrays;

public class ArrayList <E> {

    private E [] data;
    private int actSize;

    public ArrayList() {
        data = (E[])(new Object[10]); //declaring the size of the object
        actSize = 0;
    }

    //method get --> get the data from specified index

    public E get(int index) {
        if (index < actSize) {
            return data[index];
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //method add() --> add to certain index
    public void add(int index, E obj) {
        if(index == actSize) {
            addLast(obj);
        }else if(index < actSize) {
            actSize++;
            int ind = actSize;

            while (ind > index) {

                data[ind-1] = data[ind -2];
                ind--;
            }
            data[index] = obj;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //method addLast() --> add data to the end of the array
    public void addLast(E obj) {

        if(data.length - actSize <= 10) {
            increaseSize();
        }
        data[actSize] = obj;
        actSize++;
    }

    public void increaseSize() {
        data = Arrays.copyOf(data, data.length*2);
    }

    //get number of the element in the array
    public int size() {return actSize;}

    //remove() --> remove element from specific index
    public E remove(int index) {
        if(index < actSize) {

            E obj = data[index];
            data[index] = null;
            int temp = index;

            while(temp < actSize) {
                data[temp] = data[temp+1];
                data[temp+1] = null;
                temp++;
            }
            actSize--;
            return obj;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //set() --> replace data on specified index
    public E set(int index, E obj) {
        E dataBfrUpdate = null;
        if(index < 0 || index > data.length) {
            System.err.println("Index is out of range!");
        }else {
            dataBfrUpdate = data[index];
            data[index] = obj;
        }
        return dataBfrUpdate;
    }
}