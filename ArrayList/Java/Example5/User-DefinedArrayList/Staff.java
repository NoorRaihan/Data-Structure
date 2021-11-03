public class Staff {
    private long staffId;
    private String staffName;
    private int yearOfService;
    private String locality;

    //constructor
    public Staff(long staffId, String staffName, int yearOfService, String locality) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.yearOfService = yearOfService;
        this.locality = locality;
    }

    //accessor
    public String getStaffName() {return staffName;}
    public long getStaffId() {return staffId;}
    public int getYearOfService() {return yearOfService;}
    public String getLocality() {return locality;}

    public void setLocality(String loc) {this.locality = loc;}

    public String toString() {
        return staffId + ": " + staffName + ", " + yearOfService + ", " + locality;
    }

}