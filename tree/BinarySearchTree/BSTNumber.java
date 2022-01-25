public class BSTNumber {
    
    private TreeNode root;

    //constructor an empty tree
    public BSTNumber() {
        root = null;
    }

    //insert a new node in the binary search tree, if node is null,
    //creaye the root node here
    //otherwise, call the insert method of class Treenode
    public void insertNode(Number n) {
        if(root == null) {
            root = new TreeNode(n);
        }
        else {
            root.insert(n);
        }
    }

    //method displayNumber() and its recursive method to displau the
    //numbers in ascending order
    public void displayNumber() { //non recursive method
        displayNumberAscending(root);
    }

    private void displayNumberAscending(TreeNode node) { //recursive method
        if(node == null) {
            return;
        }
        else {
            displayNumberAscending(node.left);
            System.out.print(node.data.getN() + " ");
            displayNumberAscending(node.right);
        }

        /*
        if(node != null) {
            displayNumberAscending(node.left);
            System.out.print(node.data.getN() + " ");
            displayNumberAscending(node.right);
        }
        */
    }

    public int calcSum() {
        return calcSumDetail(root);
    }

    private int calcSumDetail(TreeNode node) {

        if(node == null) {
            return 0;
        }
        else {
            Number n = (Number)node.data;
            return n.getN() + calcSumDetail(node.left) + calcSumDetail(node.right);
        }
    }

    //method to count odd()
    public void countOdd() {
        System.out.print("\n\nNumber of odd numbers: " + countOddDetail(root));
    }

    private int countOddDetail(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            Number n = (Number)node.data;

            if(n.getN() % 2 != 0) {
                return 1 + countOddDetail(node.left) + countOddDetail(node.right);
            }else {
                return countOddDetail(node.left) + countOddDetail(node.right);
            }
        }
    }

    //method to find smallest
    public int findSmallest() {
        Number small = root.data;
        small = findSmallestDetail(root,small);
        //System.out.print("\n\nThe smallest number: " + small.getN());
        return small.getN();
    }

    private Number findSmallestDetail(TreeNode node, Number sObj) {

        if(node != null) {
            Number n = (Number)node.data;
            int num = n.getN();
            int smallNum = sObj.getN();

            if(num < smallNum) {
                sObj = n;
            }
            sObj = findSmallestDetail(node.left, sObj);
            sObj = findSmallestDetail(node.right, sObj);
        }
        return sObj;
    }

    //method searchNumber
    public Number searchNumber(int sNum) {
        return searchNumberDetail(root,sNum);
    }

    private Number searchNumberDetail(TreeNode node, int sNum) {
        if(node == null) {
            return null;
        }
        else if(sNum == node.data.getN()) {
            return node.data;
        }
        else if(sNum < node.data.getN()) {
            return searchNumberDetail(node.left, sNum);
        }
        else {
            return searchNumberDetail(node.right, sNum);
        }
    }
}
