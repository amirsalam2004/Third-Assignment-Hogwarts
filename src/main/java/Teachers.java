import java.util.ArrayList;

public class Teachers extends Account {
    private ArrayList<String> courses;
    private ArrayList<ArrayList<String>> students;
    private ArrayList<String> comments;
    private int score;
    private int scoreTimes;
    public Teachers(){
        super();
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
        this.comments=new ArrayList<>();
        score=0;
        scoreTimes=0;
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
    public void addComment(String comment,String userName){
        comments.add(userName+" : "+comment);
    }
    public ArrayList<String> getComments(){return comments;}
    public ArrayList<String> getCourses(){return courses;}
    public ArrayList<String> getStudents(String course){
        int index= courses.indexOf(course);
        return students.get(index);
    }
    public int getScore(){return score;}
}
