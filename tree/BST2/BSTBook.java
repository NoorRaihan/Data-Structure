public class BSTBook {
    
    Node root;

    public BSTBook() {
        root = null;
    }

    public void insertNode(Book obj) {

        if(root == null) {
            root = new Node(obj);
        }
        else {
            root.insert(obj);
        }
    }

    //method to count the subject
    public int countSubject(String subject) {
        return countSubjectDetail(root, subject);
    }

    private int countSubjectDetail(Node node, String subject) {

        if(node == null) {
            return 0;
        }
        else {
            Book obj = node.data;

            if(obj.getSubject().equalsIgnoreCase(subject)) {
                return 1 + countSubjectDetail(node.left, subject) + countSubjectDetail(node.right, subject); 
            }
            else {
                return countSubjectDetail(node.left, subject) + countSubjectDetail(node.right, subject);
            }
        }
    }

    //method to calculate all book total price
    public double totalPriceAll() {
        return totalPriceAllDetail(root);
    }

    private double totalPriceAllDetail(Node node) {

        if(node  == null) {
            return 0;
        }
        else {

            double price = node.data.getPrice();
            return price + totalPriceAllDetail(node.left) + totalPriceAllDetail(node.right);
        }
    }

    //method calculate total price based on subject specified
    public double totalPrice(String subject) {
        return totalPriceDetail(root,subject);
    }

    private double totalPriceDetail(Node node, String subject) {

        if(node == null) {
            return 0;
        }
        else {

            Book obj = node.data;
            if(obj.getSubject().equalsIgnoreCase(subject)) {
                
                double price = obj.getPrice();
                return price + totalPriceDetail(node.left, subject) + totalPriceDetail(node.right, subject);
            }
            else {
                return  totalPriceDetail(node.left, subject) + totalPriceDetail(node.right, subject);
            }
        }
    }

    //method to seach book by access number
    public void searchBookByAN(String an) {
        System.out.println(searchBookByANDetail(root,an));
    }

    private String searchBookByANDetail(Node node, String an) {

        if(node == null) {
            return null;
        }
        else if(node.data.getAccessNo().equalsIgnoreCase(an)) {
            return node.data.toString();
        }
        else {
            Book obj = node.data;
            if(obj.getAccessNo().compareTo(an) > 0) {
                return searchBookByANDetail(node.left, an);
            }
            else {
                return searchBookByANDetail(node.right, an);
            }
        }
    }

    public void searchBookbyYP(int yp) {
        searchBookbyYPDetail(root,yp);
    }

    private void searchBookbyYPDetail(Node node, int yp) {


        if(node  == null) {
            return;
        }
        else {
            
            if(node.data.getYearPublished() == yp) 
                System.out.println(node.data.toString());
            searchBookbyYPDetail(node.left, yp);
            searchBookbyYPDetail(node.right, yp);
        }

    }

    public void displayBook() {
        displayBookDetail(root);
    }

    private void displayBookDetail(Node node) {

        if(node == null) {
            return;
        }
        else {
            displayBookDetail(node.right);
            System.out.println(node.data.toString());
            displayBookDetail(node.left);
        }
    }

    public void expensiveCSBook() {
        Book exp = expensiveCSBookDetail(root,null);
        System.out.println(exp.toString());
    }

    private Book expensiveCSBookDetail(Node node, Book exp) {

        if(node != null) {

            if(node.data.getSubject().equalsIgnoreCase("Computer Science")) {

                if(exp == null) {
                    exp = node.data;
                }

                Book obj = node.data;
                double price = obj.getPrice();
                double expPrice = exp.getPrice();
    
                if(price > expPrice) {
                    exp = obj;
                }
    
                exp = expensiveCSBookDetail(node.left, exp);
                exp = expensiveCSBookDetail(node.right, exp);
            }
            else {
                exp = expensiveCSBookDetail(node.left, exp);
                exp = expensiveCSBookDetail(node.right, exp);
            }
            
        }
        return exp;
    }
}
