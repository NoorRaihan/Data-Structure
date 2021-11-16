import java.nio.charset.CoderResult;

public class Coordinator {

    private String coordinatorName;
    private String programName;
    private String facultyName;
    private int totalStudents;
    private String phoneNumber;

    //constructor
    public Coordinator(){
        this(null,null,null,0,null);
    }

    public Coordinator(String name, String program, String faculty, int totalStudents, String phone) {
        this.coordinatorName = name;
        this.programName = program;
        this.facultyName = faculty;
        this.totalStudents = totalStudents;
        this.phoneNumber = phone;
    }

    //setters
    public void setName(String name) {this.coordinatorName = name;}
    public void setProgram(String program) {this.programName = program;}
    public void setFaculty(String faculty) {this.facultyName = faculty;}
    public void setStudents(int total) {this.totalStudents = total;}
    public void setPhone(String phone) {this.phoneNumber = phone;}

    //getters
    public String getName() {return coordinatorName;}
    public String getProgram() {return programName;}
    public String getFaculty() {return facultyName;}
    public int getStudents() {return totalStudents;}
    public String getPhone() {return phoneNumber;}

    public String toString() {
        return "\nCoordinator Name: " + coordinatorName + "\nProgram Name: " + programName + "\nFaculty Name: " + facultyName + "\nTotal Students: " + totalStudents + "\nPhone Numbers: " + phoneNumber;
    }

}