import java.util.ArrayList;
import java.util.Arrays;

public class course extends Account {
    private ArrayList<String> students;
    private String teacher;
    private String courseName;
    private String coursDay;
    public course(String courseName){
        super("corse");
        students=new ArrayList<>();
        teacher=null;
        this.courseName=courseName;
        coursDay="";
    }
    public void addStudent(String studentName){this.students.add(studentName);}
    public void setTeacher(String teacherName){this.teacher=teacherName;}
    public ArrayList<String> getStudents(){return this.students;}
    public String getTeacher(){return this.teacher;}
    public String getCourseName(){return this.courseName;}
    public void deletStudent(String userName){this.students.remove(userName);}
    public void deleteTeacher(String userName){teacher="";}
    public String getCoursDay(){return coursDay;}
    public void setCourseDay(String day){
            coursDay = day;
    }
}
