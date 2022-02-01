public class Node {
    Book data;
    Node left;
    Node right;

    private Book oriObj;
    private Book newObj;

    public Node(Book obj) {
        oriObj = obj;
        data = obj;
        left = right = null;
    }

    public void insert(Book obj) {

        newObj = obj;

        if(obj.getAccessNo().compareTo(oriObj.getAccessNo()) < 0) {
            if(left == null) {
                left = new Node(obj);
            }
            else {
                left.insert(obj);
            }
        }
        else {
            if(right == null) {
                right = new Node(obj);
            }
            else {
                right.insert(obj);
            }
        }
    }
}
