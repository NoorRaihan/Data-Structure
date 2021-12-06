
public class LinkedList {

    private Node firstNode;
    private Node LastNode;
    private Node currNode;

    public LinkedList() {
        firstNode = LastNode = currNode = null;
    }

    public void insertAtBack(Contestant elem) {
        if(isEmpty()) {
            firstNode = LastNode = new Node(elem);
        }else {
            Node obj = new Node(elem);
            LastNode.next = obj;
            LastNode = LastNode.next;
        }
    }

    public Contestant getFirst() {

        if(isEmpty()) {
            throw new EmptyListException();
        }else {
            currNode = firstNode;
            return currNode.data;
        }
    }

    public Contestant getNext() {

        if(isEmpty()) {
            throw new EmptyListException();
        }else if(currNode != LastNode){
            currNode = currNode.next;
            return currNode.data;
        }else {
            return null;
        }
    }

    public Contestant removeFront() {

        Contestant remove = null;

        if(isEmpty()) {
            throw new EmptyListException();
        }

        remove = firstNode.data;

        if(firstNode.equals(LastNode)) {
            firstNode = LastNode = null;
        }else {
            firstNode = firstNode.next;
        }
        return remove;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

}