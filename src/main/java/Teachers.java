import java.util.ArrayList;

public class Teachers extends Account {
    ArrayList<String> courses;
    ArrayList<ArrayList<String>> students;
    public Teachers(){
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
    }
    public void addCourses(String course,ArrayList<String> students){
        this.courses.add(course);
        this.students.add(students);
    }
    public void addStudent(String course,String studentUsenName){
        students.get(courses.indexOf(course)).add(studentUsenName);
    }
    public ArrayList<String> getAllowedCourses(ArrayList<String> courses){
        ArrayList<String> allowedCourses=new ArrayList<>(courses);
        allowedCourses.removeAll(this.courses);
        return(allowedCourses);
    }
    public void deletStudent(String userName){
        for(int i=0;i<students.size();i++)
            if(students.get(i).contains(userName)){
                int index=students.indexOf(userName);
                students.get(i).remove(index);
            }
    }
    public ArrayList<String> getCourses(){return courses;}
    public ArrayList<String> getStudents(String course){
        int index= courses.indexOf(course);
        return students.get(index);
    }
}
