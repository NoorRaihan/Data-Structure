public class Book {

    private String accessNo;
    private String title;
    private String subject;
    private double price;
    private int yearPublished;

    public Book(String accessNo, String title, String subject, double price, int yearPublished) {
        this.accessNo = accessNo;
        this.title = title;
        this.subject = subject;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    public void setAccessNo(String accessNo) {this.accessNo = accessNo;}
    public void setTitle(String title) {this.title = title;}
    public void setSubject(String subject) {this.subject = subject;}
    public void setPrice(double price) {this.price = price;}
    public void setYearPublished(int year) {this.yearPublished = year;}

    public String getAccessNo() {return accessNo;}
    public String getTitle() {return title;}
    public String getSubject() {return subject;}
    public double getPrice() {return price;}
    public int getYearPublished() {return yearPublished;}

    public String toString() {
        return "\nAccess No: " + accessNo + "\nTitle: " + title + "\nSubject: " + subject + "\nPrice : RM" + price + "\nYear Published: " + yearPublished;
    }
}