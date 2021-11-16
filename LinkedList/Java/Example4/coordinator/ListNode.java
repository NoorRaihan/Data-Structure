import java.util.List;

public class ListNode {

    Object data;
    ListNode next;

    public ListNode(Object obj) {
        this(obj,null);
    }

    public ListNode(Object obj, ListNode nextNode) {
        data = obj;
        next = nextNode;
    }

    public Object getObject() {return data;}
    public ListNode getLink() {return next;}
    
}