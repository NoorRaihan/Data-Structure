public class LinkedList {

    private ListNode firstNode;
    private ListNode currNode;
    private ListNode lastNode;

    public LinkedList() {
        firstNode = currNode = lastNode = null;
    }

    public void insertAtBack(Object obj) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(obj);
        }else {
            lastNode = lastNode.next = new ListNode(obj);
        }
    }

    public Object getFirst() {
        if(isEmpty()) {
            return null;
        }else {
            currNode = firstNode;
            return currNode.data;
        }
    }

    public Object getNext() {

        if(currNode != lastNode) {
            currNode = currNode.next;
            return currNode.data;
        } else {
            return null;
        }
    }

    public Object removeFromFront() {
        Object remove = null;
        if(isEmpty()) {
            throw new EmptyListException();
        }
        remove = firstNode.data;


        if(firstNode.equals(lastNode)) {
            firstNode = lastNode = null;
        }else {
            firstNode = firstNode.next;
        }
        return remove;
    }

    public Object removeFromBack() {
        Object remove = null;
        if(isEmpty()) {
            throw new EmptyListException();
        }
        remove = lastNode.data;

        if(lastNode.equals(firstNode)) {
            lastNode = firstNode = null;
        }else {
            ListNode current = firstNode;
            while(current != lastNode) {
                current = current.next;
            }
            lastNode = current;
            current.next = null;
        }
        return remove;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
}
