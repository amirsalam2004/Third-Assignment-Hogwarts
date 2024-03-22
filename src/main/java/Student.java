import java.util.ArrayList;

public class Student extends Account {
    ArrayList<String> courses;
    ArrayList<String> teachers;
    ArrayList<Integer> scores;
    public Student(){
        courses=new ArrayList<>();
        teachers=new ArrayList<>();
        scores=new ArrayList<>();
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
        this.scores.add(null);
    }
    public void garde(String course,int score){
        int index=courses.lastIndexOf(course);
        scores.set(index,score);
    }
    public void addTeacher(String course,String teacherUserName){
        int index=courses.lastIndexOf(course);
        teachers.set(index,teacherUserName);
    }
    public void deleteTeacher(String userName){
        for(int i=0;i<teachers.size();i++)
            if(teachers.get(i).equals(userName))
                teachers.set(i,"");
    }
    public ArrayList<String> getTeachers(){return this.teachers;}
    public ArrayList<String> getCourses(){return this.courses;}
    public ArrayList<Integer> getScores(){return this.scores;}
}
