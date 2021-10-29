public class Book {

    private String title;
    private int year;

    public Book(String title,int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {return title;}
    public int getYear() {return year;}
    
    public String toString() {
        return title + ", " + year;
    }
}