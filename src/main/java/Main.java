
/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hogwarts hogwarts=new Hogwarts();
        hogwarts.addAssistant();
        hogwarts.getAssistants().get(0).setUsername("amir salam");
        hogwarts.getAssistants().get(0).changePassword("amir1111");
        runMenu(hogwarts);
    }

    public static void getUsernameAndPass(Account user){
        String password;
        Scanner in=new Scanner(System.in);
        System.out.println("---------------------------------\n" +
                "Enter username\n (Each user will be known by the username in the school)\n"+
                "---------------------------------");
        user.setUsername(in.nextLine());
        System.out.println("---------------------------------\n" +
                "Enter password\n(The password must be at least 8 characters long,\n"
                + "and you have to use letters and numbers in it,\n"
                + "you are not allowed to use special symbols such as #,@,*,...)\n"+
                "---------------------------------");
        while (true) {
            password=in.nextLine();
            if(user.validatePassword(password)){
                user.changePassword(password);
                break;
            }
            System.out.println("The Input Is Incorrect");
        }
        System.out.println("MISSION ACCOMPLISHED");
    }
    public static void studentMenu(Student student, ArrayList<String> courses, Hogwarts hogwarts){
        Scanner in=new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------\n" +
                    "Choose your option:\n" +
                    "  0- EXIT\n"+
                    "  1- View your courses\n" +
                    "  2- View your Teachers\n" +
                    "  3- register in a course\n" +
                    "(ENTER THE OPTION NUMBER)\n" +
                    "---------------------------------");
            String input=in.next();
            if(input.equals("1")){
                System.out.println(student.getCourses());
            }
            else if(input.equals("2"))
                System.out.println(student.getTeachers());
            else if(input.equals("3")){
                ArrayList<String> allowedCourses=new ArrayList<String>(student.getAllowedCourse(courses));
                while (true) {
                    System.out.println("---------------------------------\n" +
                            "Allowed courses for yor:\n   0- EXIT");
                    for (int i = 0; i < allowedCourses.size(); i++) {
                        System.out.println("   " + (i + 1) + "- " + allowedCourses.get(i) +
                                "  (teacher: " +hogwarts.getTeacherViaCourseName(allowedCourses.get(i)) + ")");
                    }
                    System.out.println("ENTER THE NUMBER OF A COURSE TO REGISTER\n" +
                            "---------------------------------");
                    try {
                        String input3=in.next();
                        int option = Integer.parseInt(input3);
                        if (option == 0)
                            break;
                        student.addCourse(allowedCourses.get(option - 1),
                                hogwarts.getTeacherViaCourseName(allowedCourses.get(option - 1)),hogwarts.getDayViaCourseName(allowedCourses.get(option - 1)));
                        System.out.println("MISSION ACCOMPLISHED");
                        break;
                    } catch (Exception e) {
                        System.out.println("INPUT IS INCORRECT!");
                    }
                }
            }
            else if(input.equals("0"))
                break;
            else
                System.out.println("INPUT IS INCORRECT!");
        }
    }
    public static void teacherMenu(Hogwarts hogwarts,Teachers teacher,ArrayList<String> courses){
        Scanner in=new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------\n" +
                    "Choose your option:\n" +
                    "  0- EXIT\n" +
                    "  1- View your courses\n" +
                    "  2- register in a course\n" +
                    "  3- View your score\n" +
                    "(ENTER THE OPTION NUMBER)\n" +
                    "---------------------------------");
            String input = in.next();
            in.nextLine();
            if(input.equals("1")){
                while (true){
                    System.out.println("---------------------------------\n" +
                            "Your courses:\n"+teacher.getCourses()
                            +"\n(ENTER 0 TO RETURN)" +
                            "\n(ALSO YOU CAN ENTER THE NAME OF A COURSE TO SEE THE STUDENTS)"
                            +"\n---------------------------------");
                    input=in.nextLine();
                    if(teacher.getCourses().contains(input)){
                        while (true) {
                            System.out.println("---------------------------------\n" +
                                    "Course: " + input +
                                    "\nThe students of the course:\n" +
                                    teacher.getStudents(input)
                                    + "\n(ENTER THE NAME OF THE NAME OF STUDENT TO SCORE)"+
                                    "\n(ALSO YOU CAN ENTER 0 TO RETURN)"
                                    +"\n---------------------------------");
                            String input1 = in.nextLine();
                            if (teacher.getStudents(input).contains(input1)) {
                                while (true) {
                                    System.out.println("---------------------------------\n" +
                                            "Student name: " + input1
                                            + "\n(Enter score(0-20))"
                                            +"\n---------------------------------");
                                    try {
                                        String input3 = in.next();
                                        in.nextLine();
                                        int input2=Integer.parseInt(input3);
                                        if (input2 >= 0 && input2 <= 20) {
                                            hogwarts.gradeStudent(input1, input2, input);
                                            System.out.print("MISSION ACCOMPLISHED\n");
                                            break;
                                        }
                                        if (input2 < 0 || input2 > 20)
                                            System.out.println("INPUT IS INCORRECT!");
                                    }
                                    catch (Exception e) {
                                        System.out.println("INPUT IS INCORRECT!");
                                    }
                                }
                            }
                            else if(input1.equals("0"))
                                break;
                            else
                                System.out.println("INPUT IS INCORRECT!");
                        }
                    }
                    else if(input.equals("0"))
                        break;
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input.equals("2")){
                while (true) {
                    System.out.println("---------------------------------\n" +
                            "Allowed courses:\n" +
                            teacher.getAllowedCourses(courses) +
                            "\n(ENTER THE COURSE NAME TO REGISTER)\n"
                            +"(ENTER 0 TO RETURN)"
                            +"\n---------------------------------");
                    String input1=in.nextLine();
                    if(teacher.getAllowedCourses(courses).contains(input1)){
                        teacher.addCourses(input1,hogwarts.getStudentsOfCourse(input1));
                        System.out.println("MISSION ACCOMPLISHED");
                        break;
                    }
                    else if(input1.equals("0"))
                        break;
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input.equals("0"))
                break;
            else
                System.out.println("INPUT IS INCORRECT!");
        }
    }
    public static void assistantMenu(Assistant assistant){
        Scanner in=new Scanner(System.in);
        while (true){
            System.out.println("---------------------------------\n" +
                    "Choose your option:\n" +
                    "  0- EXIT\n" +
                    "  1- View all courses\n" +
                    "  2- View all teachers\n" +
                    "  3- View all students\n" +
                    "  4- Create a course\n"+
                    "  5- Register an assistant\n"+
                    "  6- Create teacher account\n"+
                    "(ENTER THE OPTION NUMBER)\n" +
                    "---------------------------------");
            String input0=in.nextLine();
            if(input0.equals("1")){
                System.out.println("---------------------------------\n" +
                        "All courses:\n " +
                        assistant.viewAllCourses()+
                        "\n(ENTER THE NAME OF A COURSE TO SEE MORE INFORMATION)" +
                        "\n(ENTER 0 TO RETURN)"+
                        "\n---------------------------------");
                while (true){
                    String input = in.nextLine();
                    if (assistant.viewAllCourses().contains(input)) {
                        int index=assistant.viewAllCourses().indexOf(input);
                        System.out.println("---------------------------------\n" +
                                "Course : "+input+
                                "\n   Teacher : "+assistant.getCourses().get(index).getTeacher()+
                                "\n   Students : "+assistant.getCourses().get(index).getStudents()+
                                "\n   Day : "+assistant.getCourses().get(index).getCoursDay()+
                                "\n---------------------------------");
                        break;
                    }
                    else if(input.equals("0"))
                        break;
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input0.equals("2")){
                System.out.println("---------------------------------\n" +
                        "All teachers\n "+assistant.viewAllTeachers()+
                        "\n (ENTER THE NAME OF A TEACHER TO SEE MORE INFORMATION OR TO DELETE)"+
                        "\n (ENTER 0 TO RETURN))"+
                        "\n---------------------------------");
                while (true){
                    String input=in.nextLine();
                    if(assistant.viewAllTeachers().contains(input)) {
                        int index = assistant.viewAllTeachers().indexOf(input);
                        System.out.println("---------------------------------\n" +
                                "Teacher :  "+input+
                                "\n   Courses : "+assistant.getTeachers().get(index).getCourses()+
                                "\n   Score : "+assistant.getTeachers().get(index).getScore()+
                                "\n   Comments :\n   "+assistant.getTeachers().get(index).getComments()+
                                "\n(ENTER 1 TO DELETE THIS TEACHER)" +
                                "\n(ENTER 0 TO RETURN)"+
                                "\n---------------------------------");
                        while (true){
                            String input1=in.next();
                            in.nextLine();
                            if(input1.equals("1")){
                                assistant.deleteTeacher(input);
                                System.out.println("MISSION ACCOMPLISHED");
                                break;
                            }
                            else if(input1.equals("0"))
                                break;
                            else
                                System.out.println("INPUT IS INCORRECT!");
                        }
                        break;
                    }
                    else if(input.equals("0"))
                        break;
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input0.equals("3")){
                System.out.println("---------------------------------\n" +
                        "All students\n "+assistant.viewAllStudents()+
                        "\n(ENTER THE NAME OF A STUDENT TO SEE MORE INFORMATION OR TO DELETE)"+
                        "\n(ENTER 0 TO RETURN))"+
                        "\n---------------------------------");
                while (true){
                    String input=in.nextLine();
                    if(assistant.viewAllStudents().contains(input)) {
                        int index = assistant.viewAllStudents().indexOf(input);
                        System.out.println("---------------------------------\n" +
                                "Student :  "+input+
                                "\n   Courses : ");
                        for (int i=0;i<assistant.getStudents().get(index).getCourses().size();i++){
                            System.out.println("      "+assistant.getStudents().get(index).getCourses().get(i)+
                                    "(scores: "+assistant.getStudents().get(index).getScores().get(i)+")" +
                                    "(Teacher: "+assistant.getStudents().get(index).getTeachers().get(i)+")"+
                                    "(day: "+assistant.getStudents().get(index).getCourseDays().get(i)+")");
                        }
                        System.out.println("(ENTER 1 TO DELETE ThIS STUDENT)"+
                                "\n(ENTER 0 TO RETURN))"+
                                "\n---------------------------------");
                        while (true){
                            String input1=in.next();
                            in.nextLine();
                            if(input1.equals("1")){
                                assistant.deleteStudent(input);
                                System.out.println("MISSION ACCOMPLISHED");
                                break;
                            }
                            else if(input1.equals("0"))
                                break;
                            else
                                System.out.println("INPUT IS INCORRECT!");
                        }
                        break;
                    }
                    else if(input.equals("0"))
                        break;
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if (input0.equals("4")) {
                System.out.println("---------------------------------\n" +
                        "ENTER THE NAME OF COURSE"+
                        "\n---------------------------------");
                String input=in.nextLine();
                assistant.addCourse(input);
                System.out.println("---------------------------------\n" +
                        "ENTER THE COURSE DAY"+
                        " DAYS : (Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday)"+
                        "\n---------------------------------");
                while (true){
                    input=in.next();
                    in.nextLine();
                    String[]  days= new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
                    if(Arrays.stream(days).toList().contains(input)) {
                        assistant.getCourses().getLast().setCourseDay(input);
                        break;
                    }
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
                System.out.println("MISSION ACCOMPLISHED");
            }
            else if (input0.equals("5")) {
                assistant.addAssistant();
                getUsernameAndPass(assistant.getAssistants().getLast());

            }
            else if (input0.equals("6")) {
                assistant.createTeacherAccount();
                System.out.println("MISSION ACCOMPLISHED");
            }
            else if(input0.equals("0"))
                break;
            else
                System.out.println("INPUT IS INCORRECT!");
        }
    }
    public static int singIn(ArrayList<String> usernames){
        Scanner in=new Scanner(System.in);
        System.out.println("---------------------------------\n" +
                "Enter your username\n" +
                " (IF YOU ENTER WRONG 3 TIMES,YOU WILL GET OUT)\n"+
                "---------------------------------");
        for (int i=0;i<3;i++){
            String input=in.nextLine();
            if(usernames.contains(input)) {
                return usernames.indexOf(input);
            }
            else
                System.out.println("THERE IS NO SUCH USER!");
        }
        return (-1);
    }
    public static void runMenu(Hogwarts hogwarts) {
        Scanner in=new Scanner(System.in);
        while (true){
            System.out.println("---------------------------------\n" +
                    "Enter the number of a user type\n" +
                    " 0- EXIT\n"+
                    " 1- Student\n" +
                    " 2- Teacher\n" +
                    " 3- Assistant\n" +
                    "---------------------------------");
            String input=in.nextLine();
            if(input.equals("1")){
                System.out.println("---------------------------------\n" +
                        "Enter the number of a option\n" +
                        " 0- EXIT\n"+
                        " 1- Sing in\n" +
                        " 2- Sing up\n" +
                        "---------------------------------");
                while (true){
                    String input1=in.nextLine();
                    if(input1.equals("2")){
                        hogwarts.addStudent();
                        getUsernameAndPass(hogwarts.getStudents().getLast());
                        break;
                    }
                    else if(input1.equals("0"))
                        break;
                    else if(input1.equals("1")) {
                        int index = singIn(hogwarts.viewAllStudents());
                        if (index != -1) {
                            System.out.println("---------------------------------\n" +
                                    "Enter your password\n" +
                                    " (IF YOU ENTER WRONG 3 TIMES,YOU WILL GET OUT)\n" +
                                    "---------------------------------");
                            for (int j = 0; j < 3; j++) {
                                String input2 = in.nextLine();
                                if (hogwarts.getStudents().get(index).getPassword().equals(input2)){
                                    Student student=hogwarts.getStudents().get(index);
                                    studentMenu(student,hogwarts.viewAllCourses(),hogwarts);
                                    break;
                                }
                                else
                                    System.out.println("PASSWORD IS WRONG!");
                            }
                        }
                        break;
                    }
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input.equals("2")){
                System.out.println("---------------------------------\n" +
                        "Enter the number of a option\n" +
                        " 0- EXIT\n"+
                        " 1- Sing in\n" +
                        " 2- Sing up\n" +
                        "---------------------------------");
                while (true){
                    String input1=in.next();
                    in.nextLine();
                    if(input1.equals("0"))
                        break;
                    else if(input1.equals("2")){
                        int index=-1;
                        String input2="X";
                        for(int i=0;i<hogwarts.getTeachers().size();i++)
                            if(hogwarts.getTeachers().get(i).getUsername().isEmpty())
                                index=i;
                        if(index!=-1){
                            Teachers teacher=hogwarts.getTeachers().get(index);
                            getUsernameAndPass(teacher);
                            break;
                        }
                        else {
                            System.out.println("YOU HAVE TO WAIT FOR PERMISSION FROM THE ASSISTANTS");
                            break;
                        }
                    }
                    else if(input1.equals("1")){
                        int index = singIn(hogwarts.viewAllTeachers());
                        if (index != -1) {
                            System.out.println("---------------------------------\n" +
                                    "Enter your password\n" +
                                    " (IF YOU ENTER WRONG 3 TIMES,YOU WILL GET OUT)\n" +
                                    "---------------------------------");
                            for (int j = 0; j < 3; j++) {
                                String input2 = in.nextLine();
                                if (hogwarts.getTeachers().get(index).getPassword().equals(input2)){
                                    Teachers teacher=hogwarts.getTeachers().get(index);
                                    teacherMenu(hogwarts,teacher,hogwarts.viewAllCourses());
                                    break;
                                }
                                else
                                    System.out.println("PASSWORD IS WRONG!");
                            }
                        }
                        break;
                    }
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if(input.equals("3")){
                System.out.println("---------------------------------\n" +
                        "Enter the number of a option\n" +
                        " 0- EXIT\n"+
                        " 1- Sing in\n" +
                        "---------------------------------");
                while (true){
                    String input1=in.next();
                    in.nextLine();
                    if(input1.equals("0"))
                        break;
                    else if(input1.equals("1")){
                        int index = singIn(hogwarts.viewAllAssistants());
                        if (index != -1) {
                            System.out.println("---------------------------------\n" +
                                    "Enter your password\n" +
                                    " (IF YOU ENTER WRONG 3 TIMES,YOU WILL GET OUT)\n" +
                                    "---------------------------------");
                            for (int j = 0; j < 3; j++) {
                                String input2 = in.nextLine();
                                if (hogwarts.getAssistants().get(index).getPassword().equals(input2)){
                                    Assistant assistant=hogwarts.getAssistants().get(index);
                                    assistantMenu(assistant);
                                    break;
                                }
                                else
                                    System.out.println("PASSWORD IS WRONG!");
                            }
                        }
                        break;

                    }
                    else
                        System.out.println("INPUT IS INCORRECT!");
                }
            }
            else if (input.equals("0"))
                break;
            else
                System.out.println("INPUT IS INCORRECT!");
        }
    }
}
