import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assistant extends Management{
    public Assistant(){super();}

    public Boolean deleteStudent(String userName){
        ArrayList<Student> students=getStudents();
        ArrayList<Teachers> teachers=getTeachers();
        ArrayList<course> courses=getCourses();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getUsername().equals(userName)){
                students.get(i).deleteUsername(userName);
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
                teachers.get(i).deleteUsername(userName);
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
    public boolean addCommentToTeacher(String comment,String teacherUser){
        ArrayList<Teachers> teachers=getTeachers();
        for(int i=0;i<teachers.size();i++)
            if(teachers.get(i).getUsername().equals(teacherUser)) {
                teachers.get(i).addComment(comment, "MANAGER");
                return true;
            }
        return false;
    }
    public void addAssistant(){
        Assistant newAssistant=new Assistant();
        getAssistants().add(newAssistant);
    }
    public void addCourse(String courseName){
        getCourses().add(new course(courseName));
    }
    public void createTeacherAccount(){
        Teachers newTeacher=new Teachers();
        getTeachers().add(newTeacher);
    }
}
