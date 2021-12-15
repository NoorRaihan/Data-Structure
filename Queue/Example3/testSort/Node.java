public class Node {

    Object data;
    Node next;

    public Node() {
        data = next = null;
    }

    public Node(Object n) {
        this.data = n;
        this.next = null;
    }

    public Node(Object n, Node next) {
        this.data = n;
        this.next = next;
    }

    public Object getData() {return data;}
    public Node getNext() {return next;}


}