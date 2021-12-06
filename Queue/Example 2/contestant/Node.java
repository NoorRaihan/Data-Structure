public class Node {
    public Contestant data;
    public Node next;

    public Node(Contestant c) {
        this.data = c;
        this.next = null;  
    }

    public Node(Contestant c, Node nextNode) {
        this.data = c;
        this.next = nextNode;
    }

    public Contestant getContestant() {return data;}
    public Node getLink() {return next;}
}