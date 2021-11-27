import java.text.DecimalFormat;
public class Athlete {

    private String name;
    private double distance[];
    DecimalFormat df = new DecimalFormat("0.00");

    //constructor
    public  Athlete(String n, double [] d) {
        name = n;
        distance = d;
    }

    //return best attempt out of 3 attempts
    public double getBestAttempt() {
        double highest = distance[0];

        for(int i=0; i<distance.length;i++) {
            if(distance[i] > highest) {
                highest = distance[i];
            }
        }

        return highest;
    }

    //return average distance
    public double getAverage() {
        double total = 0.00;
        double average = 0.00;

        for(int i=0; i<distance.length;i++) {
           total += distance[i];
        }

        average = total / distance.length;
        return average;
    }

    //toString
    public String toString() {
        return "\nName: " + name + "\nBest Jump: " + df.format(getBestAttempt()) + "m" + "\nAverage Distance: " + df.format(getAverage()) + "m";
    }
}