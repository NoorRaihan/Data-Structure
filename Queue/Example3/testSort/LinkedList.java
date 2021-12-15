public class LinkedList {

    Node head;
    Node tail;
    Node curr;

    public LinkedList() {
        this.head = this.curr = this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object getHead() {
        if(isEmpty()) {
            throw new EmptyListException();
        }else{
            curr = head;
            return curr.data;
        }
    }

    public Object getTail() {
        if(isEmpty()) {
            throw new EmptyListException();
        }else {
            curr = tail;
            return curr.data;
        }
    }

    public Object getNext() {
        if(isEmpty()){
            throw new EmptyListException();
        }else if(curr != tail){
            curr = curr.next;
            return curr.data;
        }else {
            return null;
        }
    }

    public void insertAtFront(Object obj) {
        if(isEmpty()) {
            head = tail = new Node(obj);
        }else {
            head = new Node(obj,head);
        }
    }

    public void insertAtBack(Object obj) {
        if(isEmpty()) {
            head = tail = new Node(obj);
        }else{
            tail = tail.next = new Node(obj);                                 
        }
    }

    public Object removeFront() {
        
        Object remove;
        if(isEmpty()) {
            throw new EmptyListException();
        }
        
        remove = head.data;

        if(head.equals(tail)) {
            head = tail = null;
        }else {
            head = head.next;
        }
        return remove;
    }

    public Object removeBack() {
        Object remove;

        if(isEmpty()) {
            throw new EmptyListException();
        }
        remove = tail.data;

        if(tail.equals(head)) {
            tail = head = null;
        }else {

            Node currN = head;
            while(currN != tail) {
                currN = currN.next;
            }
            tail = currN;
            tail.next = null;
        }
        return remove;
    }

    public void bubbleSort() {

        Node current = head;
        Node index = null;
        Object temp;
        Number big = (Number)head.data;

        while(current != null) {
            index = current.next;
            while(index != null) {

                Number i = (Number)current.data;
                Number j = (Number)index.data;
                
                if(i.getNum() >= j.getNum()) {

                    temp = current.data;
                    current.data = index.data;
                    index.data =  temp;
                }

                
                index = index.next;
            }
            current = current.next;
        }
    }

    public void insertionSort() {
        
        Node current = head;


    }
}