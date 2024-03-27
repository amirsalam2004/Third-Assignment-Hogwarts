import java.util.ArrayList;
import java.util.UUID;

public class Hogwarts extends Management{
        public boolean addCommentFromStudent(String comment,String teacherUser,String studentUser){
                ArrayList<Teachers> teachers=getTeachers();
                for(int i=0;i<teachers.size();i++)
                        if(teachers.get(i).getUsername().equals(teacherUser)) {
                                teachers.get(i).addComment(comment,studentUser);
                                return true;
                        }
                return false;
        }
        public course getCourseViaUUID(UUID uuid){
                ArrayList<course> courses=new ArrayList<>(getCourses());
                for(int i=0;i<courses.size();i++)
                        if(courses.get(i).getUUID().equals(uuid))
                                return courses.get(i);
                return null;
        }
        public void gradeStudent(String studentUser,int score,String course){
                ArrayList<Student> students=getStudents();
                for(int i=0;i<students.size();i++)
                        if(students.get(i).getUsername().equals(studentUser)) {
                                students.get(i).garde(course,score);
                        }
        }
        public void gradeTeacher(String teacherUsername,float score){
                int index=viewAllTeachers().indexOf(teacherUsername);
                getTeachers().get(index).addScore(score);
        }
        public ArrayList<String> getStudentsOfCourse(String courseName){
                ArrayList<course> courses=new ArrayList<>(getCourses());
                for(int i=0;i<courses.size();i++)
                        if(courses.get(i).getCourseName().equals(courseName))
                                return courses.get(i).getStudents();
                return null;
        }
        public void addAssistant(){
                Assistant newAssistant=new Assistant();
                getAssistants().add(newAssistant);
        }
        public String getTeacherViaCourseName(String courseName){
                int index=viewAllCourses().indexOf(courseName);
                return getCourses().get(index).getTeacher();
        }
        public String getDayViaCourseName(String courseName){
                int index=viewAllCourses().indexOf(courseName);
                return getCourses().get(index).getCoursDay();
        }
        public void setTeacherViaCourseName(String teacher,String courseName){
                int index=viewAllCourses().indexOf(courseName);
                getCourses().get(index).setTeacher(teacher);
        }
}
