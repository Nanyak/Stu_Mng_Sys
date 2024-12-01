
package stu_mng_sys;
import java.util.*;
import java.io.*;
public class Classes implements Serializable{
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

// BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("Classes.in"));
        ArrayList<Classes> classesList = (ArrayList<Classes>) o.readObject();
        
        while (true) {
            System.out.println("1. Add new class");
            System.out.println("2. View classes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1: // Thêm lớp mới
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
                    Student newStudent = new Student(fullName, dateOfBirth, Gender, Address,phoneNumber, classID,Major);
                    ArrayList<Student> students = new ArrayList<>();
                    students.add(newStudent); 
                    Classes newClass = new Classes(classID, Major, students);
                    classesList.add(newClass);
                    
                    //ghi lai danh sach lop vao file
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Classes.in"));// ghi lai thong tin vao file 
                    oos.writeObject(classesList);
                    oos.close(); // Đóng ObjectOutputStream sau khi ghi
                    break;
                case 2: // Xem thông tin lớp
                    System.out.println("List of Classes:");
                    for (Classes classObj : classesList) {
                        classObj.viewClassInfor();
                    }
                    break;

                case 3: // Thoát
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
*/
