import java.util.Scanner;
  
class GetInputFromUser {
    private static StudentHandler studentHandler = new StudentHandler();
    public static void main(String args[])
    {
        boolean running = true;
        boolean firstTime = true;
        Scanner in = new Scanner(System.in);
        while(running){
        ReadFile file = new ReadFile();
        if(firstTime)
            file.readFile("instructions/instructions.txt");
        else System.out.println("Use '--help' to see the command list. ");
        String ins = in.nextLine();
        String[] splited = ins.split("\\s+");

        switch(splited[0]){
            case "add":
                if(splited.length == 1){
                    file.readFile("instructions/addInstructions.txt");
                    break;
                }
                switch(splited[1]){
                    case "--help":
                        file.readFile("instructions/addInstructions.txt");
                        break;
                    case "--all":
                        studentHandler.addStudent();
                        break;
                }
                break;
            case "edit":
                if(splited.length == 1){
                    file.readFile("instructions/editInstructions.txt");
                    break;
                }
                switch(splited[1]){
                    case "--help":
                        file.readFile("instructions/editInstructions.txt");
                        break;
                    case "name":
                        String nm = in.nextLine();
                        studentHandler.editStudent(nm);
                        break;
                }
                break;
            case "delete":
                if(splited.length == 1){
                    file.readFile("instructions/deleteInstructions.txt");
                    break;
                }
                switch(splited[1]){
                    case "--help":
                        file.readFile("instructions/deleteInstructions.txt");
                        break;
                    case "--all":
                        studentHandler.deleteAll();
                        break;
                    case "name":
                        studentHandler.deleteStudent();
                        break;
                }
                break;
            case "show":
                if(splited.length == 1){
                    file.readFile("instructions/showInstructions.txt");
                    break;
                }
                switch(splited[1]){
                    case "--help":
                        file.readFile("instructions/showInstructions.txt");
                        break;
                    case "--all":
                        studentHandler.showAll();
                        break;
                    case "class":
                        System.out.println("Enter the class : (8/9/10)");
                        int cls = in.nextInt();
                        studentHandler.showClass(cls);
                        break;
                    case "name":
                        System.out.println("Enter student Name : ");
                        String nm = in.nextLine();
                        studentHandler.showStudent(nm);
                        break;
                    case "info":
                        studentHandler.showInfo();
                        break;
                }
                break;
            case "stop":
                running = false;
                break;
            case "--help":
                file.readFile("instructions/instructions.txt");
                break;
            default:
                System.out.println("\n" +splited[0] + " is not a defined command.");
                System.out.println("Use \'--help\' command to see how this terminal can be used.");
                break;
        }
        firstTime = false;
    }
    in.close();
    }
}