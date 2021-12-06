public class Queue {

    LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue (Contestant elem) {
        list.insertAtBack(elem);
    }

    public Contestant dequeue() {
        return list.removeFront();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}