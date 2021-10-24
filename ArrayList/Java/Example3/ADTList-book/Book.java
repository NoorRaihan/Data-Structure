public class Book {
    private String booktitle;
    private String author;
    private int yearpublished;
    private double bookprice;

    public Book (String title, String author, int year, double price) {
        this.booktitle = title;
        this.author = author;
        this.yearpublished = year;
        this.bookprice = price;
    }

    public String getTitle() {return this.booktitle;}
    public String getAuthor() {return this.author;}
    public int getYearPublished() {return this.yearpublished;}
    public double getPrice() {return this.bookprice;}

    public void PrintBook() {
        System.out.println("Book Title: " + booktitle);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearpublished);
        System.out.println("Book Price: RM" + bookprice);
    }
}