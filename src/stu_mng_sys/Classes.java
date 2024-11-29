
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
    
    // Ghi thong tin lop vao file nhi phan
    public static void writeClassToFile(String fileName, Classes classObj) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            os.writeObject(classObj);
        } catch (IOException e) {
            
        }
    }

    // Doc danh sach lop tu file nhi phan
    public static ArrayList<Classes> readClassesFromFile(String fileName) throws ClassNotFoundException {
        ArrayList<Classes> classesList = new ArrayList<>();
        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Classes classObj = (Classes) os.readObject();
                classesList.add(classObj);
            }
        } catch (EOFException e) {
            // Khi gap EOF, khong con gi de doc nua. 
        } catch (IOException e) {
            
        }
        return classesList;
    }
}

// BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ArrayList<Classes> classesList = new ArrayList<>();
        String fileName = "Classes.in";

        // Kiểm tra xem file có tồn tại và có dữ liệu không
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try {
                classesList.addAll(Classes.readClassesFromFile(fileName));
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("1. Add new class");
            System.out.println("2. View classes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: // them sinh vien vao lop
                    System.out.print("Enter class ID: ");
                    String classID = sc.nextLine();
                    System.out.print("Enter major: ");
                    String major = sc.nextLine();

                    ArrayList<Student> students = new ArrayList<>();
                    Classes newClass = new Classes(classID, major, students);
                    classesList.add(newClass);
                    Classes.writeClassToFile(fileName, newClass);
                    System.out.println("Class added successfully!");
                    break;
                case 2: // xem thong tin lop
                    System.out.println("List of Classes:");
                    for (Classes classObj : classesList) {
                        classObj.viewClassInfor();
                    }
                    break;
                case 3: // thoat
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
*/
