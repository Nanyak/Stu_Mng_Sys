
package stu_mng_sys;
import java.util.*;
public class Classes {
    private String classID, Major;
    private ArrayList<Student> students; //Composition: A class has many students. 
    
    Classes(String classID, String Major,ArrayList<Student> student){
        this.classID = classID;
        this.Major = Major;
        this.students = student;
    }

    public void addNewClass(Student student){
        students.add(student);
        System.out.println("Student " + student.getFullName() + " has been added to class " + classID);
    }
    
    public void viewClassInfor(){
        System.out.println("Students in this class:");
        for (Student student : students) {
            System.out.println(" - " + student);
        }
    }  
}
