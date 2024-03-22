import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assistant extends Management{

    public Boolean deleteStudent(String userName){
        ArrayList<Student> students=getStudents();
        ArrayList<Teachers> teachers=getTeachers();
        ArrayList<course> courses=getCourses();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getUsername().equals(userName)){
                students.remove(i);
                for(int j=0;j<teachers.size();j++)
                    teachers.get(i).deletStudent(userName);
                for(int j=0;j<courses.size();j++)
                    courses.get(i).deletStudent(userName);
                return true;
            }
        }
        return false;
    }
    public Boolean deleteTeacher(String userName){
        ArrayList<Student> students=getStudents();
        ArrayList<Teachers> teachers=getTeachers();
        ArrayList<course> courses=getCourses();
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getUsername().equals(userName)){
                teachers.remove(i);
                for(int j=0;j<students.size();j++)
                    students.get(i).deleteTeacher(userName);
                for(int j=0;j<courses.size();j++)
                    courses.get(i).deleteTeacher(userName);
                return true;
            }
        }
        return false;
    }
    public void addAssistant(){
        getAssistants().add(new Assistant());
    }
    public void addCourse(){
        getCourses().add(new course("a"));
    }

}
