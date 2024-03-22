import java.util.ArrayList;
import java.util.UUID;

public class Management extends Account{
    private static ArrayList<Student> students;
    private static ArrayList<Teachers> teachers;
    private static ArrayList<course> courses;
    private static ArrayList<Assistant> assistants;
    public Management(){
        super("course");
        students=new ArrayList<>();
        teachers=new ArrayList<>();
        courses=new ArrayList<>();
        assistants=new ArrayList<>();
    }
    public ArrayList<Student> getStudents(){return students;}
    public ArrayList<Teachers> getTeachers(){return teachers;}
    public ArrayList<course> getCourses(){return courses;}
    public ArrayList<Assistant> getAssistants(){return assistants;}
    public course getCourseViaUUID(UUID uuid){
        course x = null;
        for(int i=0;i<courses.size();i++)
            if(courses.get(i).getUUID().equals(uuid))
                x=courses.get(i);
        return x;
    }
}
