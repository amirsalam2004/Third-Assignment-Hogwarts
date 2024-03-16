import java.util.ArrayList;
import java.util.UUID;

public class course extends Account{
    private ArrayList<String> students;
    private String teacher;
    private String courseName;
    public course(String courseName){
        super("corse");
        students=new ArrayList<>();
        teacher=null;
        this.courseName=courseName;
    }
    public void addStudent(String studentName){this.students.add(studentName);}
    public void setTeacher(String teacherName){this.teacher=teacherName;}
    public ArrayList<String> getStudents(){return this.students;}
    public String getTeacher(){return this.teacher;}
    public String getCourseName(){return this.courseName;}
}
