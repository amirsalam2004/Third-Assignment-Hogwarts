import java.util.ArrayList;

public class Student extends Account {
    private ArrayList<String> courses;
    private ArrayList<String> teachers;
    private ArrayList<Integer> scores;
    private ArrayList<String> courseDays;
    public Student(){
        super();
        courses=new ArrayList<>();
        teachers=new ArrayList<>();
        scores=new ArrayList<>();
        courseDays=new ArrayList<>();
    }
    public ArrayList<String> getAllowedCourse(ArrayList<String> courses,ArrayList<String> courseDys){
        ArrayList<String> allowedCoursesList=new ArrayList<String>();
        for (int i=0;i<courses.size();i++){
            if(!this.courses.contains(courses.get(i)) && !this.courseDays.contains(courseDys.get(i)))
                allowedCoursesList.add(courses.get(i));
        }
        return allowedCoursesList;
    }
    public void addCourse(String courseName,String teacherName,String courseDay){
        this.courses.add(courseName);
        this.teachers.add(teacherName);
        this.scores.add(null);
        this.courseDays.add(courseDay);
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
    public ArrayList<String> getCourseDays(){return this.courseDays;}
}
