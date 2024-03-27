import java.util.ArrayList;
import java.util.UUID;

public class Management extends Account{
    private static ArrayList<Student> students;
    private static ArrayList<Teachers> teachers;
    private static ArrayList<course> courses;
    private static ArrayList<String> courseDays;
    private static ArrayList<Assistant> assistants;
    String[] days;
    public Management(){
        super("course");
        students=new ArrayList<>();
        teachers=new ArrayList<>();
        courses=new ArrayList<>();
        assistants=new ArrayList<>();
        courseDays=new ArrayList<>();
    }
    public ArrayList<String> viewAllTeachers() {
        ArrayList<String> allTeachers=new ArrayList<>();
        for(int i=0;i<teachers.size();i++)
            allTeachers.add(teachers.get(i).getUsername());
        return allTeachers;
    }

    public ArrayList<String> viewAllStudents() {
        ArrayList<String> allStudents=new ArrayList<>();
        for(int i=0;i<students.size();i++)
            allStudents.add(students.get(i).getUsername());
        return allStudents;
    }

    public ArrayList<String> viewAllCourses() {
        ArrayList<String> allCourses=new ArrayList<>();
        for(int i=0;i<courses.size();i++) {
            allCourses.add(courses.get(i).getCourseName());
        }
        return allCourses;
    }
    public ArrayList<String> viewAllAssistants(){
        ArrayList<String> allAssistants=new ArrayList<>();
        for(int i=0;i<assistants.size();i++)
            allAssistants.add(assistants.get(i).getUsername());
        return allAssistants;
    }

    public ArrayList<Student> getStudents(){return students;}
    public ArrayList<Teachers> getTeachers(){return teachers;}
    public ArrayList<course> getCourses(){return courses;}
    public ArrayList<Assistant> getAssistants(){return assistants;}
    public ArrayList<String> getCourseDays(){return courseDays;}
    public void addStudent(){
        Student newStudent=new Student();
        students.add(newStudent);}
}

