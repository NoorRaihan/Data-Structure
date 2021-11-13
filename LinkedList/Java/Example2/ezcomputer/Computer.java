import java.text.DecimalFormat;
public class Computer {
    
    private String brand; //eg: Acer, Asus
    private String serialNo; //eg: 1234
    private int year; //year manufactured
    private String type; //desktop or notebook
    private double price; //price
    DecimalFormat df = new DecimalFormat("#0.00");

    //constructor
    public Computer() {
        this(null,null,0,null,0.00);
    }

    public Computer(String brand, String serialNo, int year, String type, double price) {
        this.brand = brand;
        this.serialNo = serialNo;
        this.year = year;
        this.type = type;
        this.price = price;
    }

    //setters
    public void setBrand(String brand) {this.brand = brand;}
    public void setSerialNo(String serialNo) {this.serialNo = serialNo;}
    public void setYear(int year) {this.year = year;}
    public void setType(String type) {this.type = type;}
    public void setPrice(double price) {this.price = price;}

    //getters
    public String getBrand() {return brand;}
    public String getSerialNo() {return serialNo;}
    public int getYear() {return year;}
    public String getType() {return type;}
    public double getPrice() {return price;}

    //printers
    public String toString() {
        return "\nBrand: " + brand + "\nSerial No: " + serialNo + "\nYear: " + year + "\nType: " + type + "\nPrice: RM" + df.format(price);
    }

}