import java.util.ArrayList;
import java.util.Scanner;

public class StudentHandler {
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private Scanner in = new Scanner(System.in);
    private StudentView view = new StudentView();


    private int totalDayaAllClass=0, totalDaysClass8=0, totalDaysClass9=0, totalDaysClass10=0;
    private Double totalEarning=0.0, totalEarningClass8=0.0, totalEarningClass9=0.0, totalEarningClass10=0.0;
    private Double totalMarks = 0.0;
    private int numOfStudent = 0;

    StudentHandler(){
        Student s1 = new Student("Arnob kumar saha", 10, makeSubjectList("phy, che"), 90.0, 13, 13.0);
        Student s2 = new Student("Maruf raihan", 9, makeSubjectList("phy, Bio"), 80.0, 17, 17.0);
        Student s3 = new Student("Nur pavel", 10, makeSubjectList("Math, che"), 65.0, 48, 48.0);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        Student s4 = new Student("Katha alam", 8, makeSubjectList("Bangla, Math"), 70.0, 23, 23.0);
        Student s5 = new Student("Amrita dattya", 9, makeSubjectList("English, che"), 75.0, 10, 10.0);
        studentList.add(s4);
        studentList.add(s5);
        for(int i=0;i<studentList.size(); i++){
            addImpact(studentList.get(i) );
        }
    }

    private void addImpact(Student s){
        totalDayaAllClass += s.getTotalDaysTaught();
        totalEarning += s.getEarnings();
        switch(s.getCls()){
            case 8:
                totalDaysClass8 += s.getTotalDaysTaught();
                totalEarningClass8 += s.getEarnings();
                break;
            case 9:
                totalDaysClass9 += s.getTotalDaysTaught();
                totalEarningClass9 += s.getEarnings();
                break;
            case 10:
                totalDaysClass10 += s.getTotalDaysTaught();
                totalEarningClass10 += s.getEarnings();
                break;
        }
        numOfStudent++;
        totalMarks += s.getAverageMarks();
    }

    private ArrayList<String> makeSubjectList(String s){
        String[] splited = s.split(",");
        String st = "";

        ArrayList<String> sub = new ArrayList<String>();

        for(int i=0;i<splited.length;i++){
            st = splited[i];
            if(st.length() == 0) continue;
            if(st.charAt(0)==' ') st = st.substring(1,st.length()-1);
            if(st.charAt(st.length()-1) == ' ') st = st.substring(0, st.length()-2);
            sub.add(st);
        }
        return sub;
    }
    public void addStudent(){
        System.out.println("Enter name of the Student :");
        String name = in.nextLine();


        System.out.println("Enter the subjects He/she reads :(comma seperated multiple value allowed)");
        String s = in.nextLine();
        ArrayList<String> sub =  makeSubjectList(s);

        System.out.println("Which class does this student read in ? : Class 8/9/10 ?");
        int cls = in.nextInt();
        in.next();


        System.out.println("Enter average marks of that Student :");
        Double averageMarks = in.nextDouble();
        in.next();

        System.out.println("How many days you have taught that Student ? :");
        int totalDaysTaught = in.nextInt();
        in.next();

        System.out.println("Your total earning ? :");
        Double earnings = in.nextDouble();
        in.next();

        Student newStudent = new Student(name, cls, sub, averageMarks, totalDaysTaught, earnings);

        studentList.add(newStudent);
        addImpact(newStudent);
    }

    public void deleteStudent(){
        System.out.println("Enter student name you want to delete.");
        System.out.print("Student name: ");
        String nameToDelete = in.nextLine();

        Student stuToDelete = searchStudent(nameToDelete);
        if(stuToDelete != null){
            studentList.remove(stuToDelete);
            System.out.println(nameToDelete + " is deleted.");
        }
    }

    public void deleteAll(){
        studentList.clear();
    }

    private Student searchStudent(String nameDel){
        for(Student stu: studentList){
            if(stu.getName().equals(nameDel)){
                return stu;
            }
        }
        System.out.println("Student with name " + nameDel + " is not found.");
        return null;
    }

    public void showAll(){
        view.showDetails(studentList,2);
    }

    public void showInfo(){
        System.out.println("-----------------------------------------------------------");

        System.out.println("Number of students is " + numOfStudent);
        System.out.println("Total days taught across all classes : " + totalDayaAllClass);
        System.out.println("Total days taught in class 8 : " + totalDaysClass8);
        System.out.println("Total days taught in class 9 : " + totalDaysClass9);
        System.out.println("Total days taught in class 10 : " + totalDaysClass10);

        System.out.println("Total earnings across all classes : " + totalEarning);
        System.out.println("Total earnings in class 8 : " + totalEarningClass8);
        System.out.println("Total earnings in class 9 : " + totalEarningClass9);
        System.out.println("Total earnings in class 10 : " + totalEarningClass10);

        System.out.println("Average marks of all students is " + totalMarks / numOfStudent);

        System.out.println("-----------------------------------------------------------");
    }

    public void showClass(int cls){
        ArrayList<Student> tmpList = new ArrayList<>();
        for(int i=0;i<studentList.size(); i++){
            Student ss = studentList.get(i);
            if(ss.getCls() == cls){
                tmpList.add(ss);
            }
        }
        view.showDetails(tmpList,1);
    }

    public void showStudent(String name){
        Student newStu = searchStudent(name);
        if(newStu == null) return;
        ArrayList<Student> tmpList =  new ArrayList<Student>();
        tmpList.add(newStu);
        view.showDetails(tmpList, 0);
    }

    public void editStudent(String name){
        Student newStu = searchStudent(name);
        if(newStu == null) return;
        newStu.editMark();
    }
}
