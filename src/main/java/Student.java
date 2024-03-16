import java.util.ArrayList;

public class Student extends Account{
    ArrayList<String> courses;
    ArrayList<String> teachers;
    public Student(){
        courses=new ArrayList<>();
        teachers=new ArrayList<>();
    }
    public ArrayList<String> getAllowedCourse(ArrayList<String> courses){
        ArrayList<String> allowedCoursesList=new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            if(!this.courses.contains(courses.get(i)))
                allowedCoursesList.add(courses.get(i));
        }
        return allowedCoursesList;
    }
    public void addCourse(String courseName,String teacherName){
        this.courses.add(courseName);
        this.teachers.add(teacherName);
    }
    public ArrayList<String> getTeachers(){return this.teachers;}
    public ArrayList<String> getCourses(){return this.courses;}

}
