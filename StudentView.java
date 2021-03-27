import java.util.ArrayList;


public class StudentView {
    //private StudentHandler handler = new StudentHandler();

    public void showDetails(ArrayList<Student> studentList, int type){
        if(studentList.isEmpty()){
            System.out.println("No Student found.");
            return;
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-18s%-15s%-15s%-15s%-15s%-15s\n" , "Student", "Class" , "Subject", "Average", "No. of days", "Total" );   
        System.out.printf("%-18s%-15s%-15s%-15s%-15s%-15s" , "Name", "" , "List", "Marks", "taught", "earnings"); 
        System.out.println();
        for(Student student: studentList){
            student.showStudent();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
