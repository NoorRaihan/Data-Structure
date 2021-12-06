public class Contestant {

    private int contestantId;
    private String contestantName;
    private char contestantGender;
    private double contestantWeight;

    public Contestant(int id, String name, char gender, double weight) {
        this.contestantId = id;
        this.contestantName = name;
        this.contestantGender = gender;
        this.contestantWeight = weight;
    }

    public int getContestantId() {return contestantId;}
    public String getContestantName() {return contestantName;}
    public char getContestantGender() {return contestantGender;}
    public double getContestantWeight() {return contestantWeight;}

    public String toString() {
        return "\nID: " + contestantId + "\nName: " + contestantName + "\nGender: " + contestantGender + "\nWeight: " + contestantWeight + "kg";
    }
}