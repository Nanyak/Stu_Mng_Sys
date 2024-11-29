
package stu_mng_sys;
import java.util.*;
public class Subject {
    private String subjectID;
    private String subjectName;
    private ArrayList<Student> enrolledStudents; // Danh sách sinh viên đã đăng ký

    // Constructor
    public Subject(String subjectID, String subjectName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.enrolledStudents = new ArrayList<>();
    }
    
    // Thêm môn học
    public void addNewProject(String projectName) {
        System.out.println("Project '" + projectName + "' has been added to subject " + subjectName);
    }
    
    public String getSubjectName(){
        return this.subjectName;
    }
    
    // Xem và sửa thông tin môn học
    public void viewModifySubjectInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Subject ID: " + subjectID);
        System.out.println("Subject Name: " + subjectName);
        
        System.out.print("Do you want to modify the subject name? (y/n) ");
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.print("Enter new subject name: ");
            this.subjectName = sc.nextLine();
            System.out.println("Subject name updated successfully!");
        }
    }
    
    // Đăng ký môn học cho sinh viên
    public void subjectRegistering(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getFullName() + " has been registered for subject " + subjectName);
        } else {
            System.out.println("Student " + student.getFullName() + " is already registered for this subject.");
        }
    }
    
    // Hủy đăng ký môn học cho sinh viên
    public void subjectCanceling(Student student) {
        if (enrolledStudents.remove(student)) {
            System.out.println("Student " + student.getFullName() + " has been canceled from subject " + subjectName);
        } else {
            System.out.println("Student " + student.getFullName() + " is not registered for this subject.");
        }
    }

    @Override
    public String toString() {
        StringBuilder studentNames = new StringBuilder();
        for (Student student : enrolledStudents) {
            studentNames.append(student.getFullName()).append(", ");
        }
        return "Subject ID: " + subjectID + ", Subject Name: " + subjectName + ", Enrolled Students:  + studentNames.toString() + ";
    }
}
