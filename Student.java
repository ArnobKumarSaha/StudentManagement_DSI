import java.util.ArrayList;

public class Student {
    private String name;
    private int cls;
    private ArrayList<String> subject;

    private Double averageMarks;
    private int totalDaysTaught, totalExam;
    private Double earnings;

    Student(String name, int cls, ArrayList<String>subject, Double averageMarks, int totalDaysTaught, Double earning){
        this.name = name;
        this.cls = cls;
        this.subject = subject;
        this.averageMarks = averageMarks;
        this.totalDaysTaught = totalDaysTaught;
        this.earnings = earning;
        this.totalExam = 1;
    }

    Student(){
        name = "";
        cls = 10;
        subject = new ArrayList<>();
        totalDaysTaught = 0;
        averageMarks = 0.0;
        totalExam = 0;
        earnings = 0.0;
    }

    // Getters and Setters for Name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // Getters and Setters for Class
    public int getCls(){
        return cls;
    }
    public void setCls(int cls){
        this.cls = cls;
    }

    //  Getters and Setters for Total days taught
    public int getTotalDaysTaught(){
        return totalDaysTaught;
    }
    public void setTotalDaysTaught(int totalDaysTaught){
        this.totalDaysTaught = totalDaysTaught;
    }

    // Getters and Setters for Average marks
    public Double getAverageMarks(){
        return averageMarks;
    }
    public void setAverageMarks(Double averageMarks){
        this.averageMarks = averageMarks;
    }

    // Getters and Setters for Earnings
    public Double getEarnings(){
        return earnings;
    }
    public void setEarnings(Double earnings){
        this.earnings = earnings;
    }

    // Getters and Setters for Subject list
    public ArrayList<String> getSubjects(){
        return subject;
    }
    public void setSubjects(ArrayList<String>subject){
        this.subject = subject;
    }

    public void editMark(){

    }

    public void showStudent(){
        System.out.format("%-18s%-15s%-15s%-15s%-15s%-15s\n" , name, cls, subject.toString(), averageMarks, totalDaysTaught, earnings);
    }
}
