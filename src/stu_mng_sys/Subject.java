
package stu_mng_sys;
import java.util.*;
import java.io.*;
public class Subject implements Serializable{
    private String subjectID;
    private String subjectName;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();
    // Constructor
    public Subject(String subjectID, String subjectName,Student student) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        enrolledStudents.add(student); 
    }
    
    // Thêm môn học
    public static Subject addNewProject(Scanner sc,Student student) {
        System.out.print("Enter subject ID: ");
        String subjectID = sc.nextLine();
        System.out.print("Enter subject name: ");
        String subjectName = sc.nextLine();
        return new Subject(subjectID, subjectName,student);
    }

    public String getSubjectName() {
        return this.subjectName;
    }
    
    
    
    public void viewSubjectInfo(){
        System.out.println("Subject ID:" + subjectID);
        System.out.println("Subject Name: " + subjectName);
        System.out.println("Enrolled Students: ");
        for(Student student:enrolledStudents){
            System.out.println(student.getStudentID() + ": " + student.getFullName());
        }
        System.out.println("");
    }
    
    // Xem và sửa thông tin môn học
    public void modifySubjectInfo(Scanner sc) {
        System.out.print("Do you want to modify the subject name? (y/n) ");
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.print("Enter new subject name: ");
            this.subjectName = sc.nextLine();
            System.out.println("Subject name updated successfully!");
        }
    }

    public String getSubjectID() {
        return this.subjectID; 
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
            studentNames.append(student.getStudentID() + ": " + student.getFullName() + " ");
        }
        return "Subject ID: " + subjectID + ", Subject Name: " + subjectName + ", Enrolled Students:"  + studentNames.toString();
    }
}
// BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("Subject.in"));
        ArrayList<Subject> subjectList = new ArrayList<>();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter Gender: ");
        String Gender = sc.nextLine();
        System.out.print("Enter Address: ");
        String Address = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Class ID: ");
        String classID = sc.nextLine();
        System.out.print("Enter Major: ");
        String Major = sc.nextLine(); 

        // Tạo đối tượng Student với thông tin nhập từ người dùng
        Student newStudent = new Student(fullName, dateOfBirth, Gender, Address,phoneNumber, classID,Major);

        while (true) {
            System.out.println("1.Add new subject");
            System.out.println("2.View all subjects");
            System.out.println("3.Modify Subject Information");
            System.out.println("4.Register for a subject");
            System.out.println("5.Cancel subject registration");
            System.out.println("6.Exit");
            System.out.print("Choose an option:");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: // add new Subject
                    Subject newSubject = Subject.addNewProject(sc,newStudent);
                    subjectList.add(newSubject);
                    /ghi lai danh sach diem vao file
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Subject.in"));// ghi lai thong tin vao file 
                    oos.writeObject(classesList);
                    oos.close(); // Đóng ObjectOutputStream sau khi ghi
                    break; 

                case 2: // display the list of subject
                    System.out.println("List of Subjects:");
                    for (Subject subject : subjectList) {
                        System.out.println(subject);
                    }
                    break;

                case 3: // Modify the information of the subject
                    System.out.print("Enter subject ID to modify");
                    String modifyID = sc.nextLine();
                    for(Subject subject:subjectList){
                        if(subject.getSubjectID().equals(modifyID)){
                            subject.modifySubjectInfo(sc);
                            break; 
                        }
                    }
                    break;
                
                case 4: // Register a subject
                    System.out.print("Enter subject ID to register: ");
                    String registerID = sc.nextLine();
                    for(Subject subject:subjectList){
                        if(subject.getSubjectID().equals(registerID)){
                            subject.subjectRegistering(newStudent);
                            break;
                        }
                    }
                    break;
                
                case 5: // Cancel subject registration
                    System.out.print("Enter subjectID to cancel registration: ");
                    String cancelID = sc.nextLine();
                    for(Subject subject:subjectList){
                        if(subject.getSubjectID().equals(cancelID)){
                            subject.subjectCanceling(newStudent);
                            break; 
                        }
                    }
                    break;
                
                case 6: //Quit
                    System.out.print("Exiting...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
*/
