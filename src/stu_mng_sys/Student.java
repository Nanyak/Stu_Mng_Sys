package stu_mng_sys;
import java.util.*;
import java.io.*;

public class Student implements Serializable{
    private String studentID, fullName, DoB, Gender, Address, Email, phoneNo, classID,Major;
    public int index = 0;
    Student(String fullName, String DoB, String Gender, String Address,String phoneNo, String classID,String Major){
        this.fullName = fullName;
        this.DoB = DoB;
        this.Gender = Gender;
        this.Address = Address;
        this.Email = "";
        this.phoneNo = phoneNo;
        this.classID = classID;
        this.Major = Major;
        this.studentID = "";
        index++;
    }

    public String getStudentID(){ // convert to get studentID;
        String res = "";
        int DoB = Integer.valueOf(this.DoB.substring(6)) + 18;
        String x = String.valueOf(DoB%100);
        String word[] = this.Major.trim().split("\\s++");
        String majorTitle = "";
        for(int i = 0;i < 2;i++){
            majorTitle += word[i].substring(0,1);
        }
        res = "B"+x.substring(x.length()-2,x.length()) + "DC" + majorTitle + String.format("%04d",index);
        return res.toUpperCase();
    }

    public String convertFullName(String fullName){
        String word[] = fullName.trim().split("\\s++");
        String res = "";
        for(int i = 0;i < word.length;i++){
            res = res + word[i].substring(0,1).toUpperCase() + word[i].substring(1).toLowerCase() + " ";
        }
        return res;
    }

    public String setDoB(String s){
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0,3) + "0" + s.substring(3);
        return s;
    }

    public String convertEmail(){ // convert to get Email for student
        String res = "";
        String word[] = this.fullName.trim().split("\\s++");
        res = word[word.length-1];
        for(int i = 0;i < word.length-1;i++){
            res += word[i].substring(0,1);
        }
        res = res + "." + getStudentID() + "@stu.ptit.edu.vn";
        return res.toLowerCase();
    }

    public String getFullName() {
        return this.fullName;
    }

    
    public void modifyStudentInfo(){ // modify student Information
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new full name: ");
        this.fullName = convertFullName(sc.nextLine()); 

        System.out.print("Enter new date of birth (dd/MM/yyyy): ");
        this.DoB = setDoB(sc.nextLine()); 

        System.out.print("Enter new gender: ");
        this.Gender = sc.nextLine();

        System.out.print("Enter new address: ");
        this.Address = sc.nextLine();

        System.out.print("Enter new phone number: ");
        this.phoneNo = sc.nextLine();

        System.out.print("Enter new class ID: ");
        this.classID = sc.nextLine();

        System.out.print("Enter new major: ");
        this.Major = sc.nextLine();

        // Cập nhật lại thông tin Email và studentID
        this.Email = convertEmail();
        this.studentID = getStudentID();
    }
    

    public void viewModifyInfor(ArrayList<Student>studentList){ // view the modified Student Information 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter studentID to modify: ");
        String searchID = sc.nextLine();
        // Find the information of student in the list
        Student foundStudent = null;
        for(Student student:studentList){
            if(student.getStudentID().equals(searchID)){
                foundStudent = student;
                break; 
            }
        }
        if(foundStudent == null){
            System.out.println("Student information not found");
            return;
        }
        // Display the information of student
        System.out.println("Current information");
        System.out.println(foundStudent);
        // Call the method to modify information
        foundStudent.modifyStudentInfo();
        System.out.println("Student information updated successfully");
    }
    
    // lay thong tin student tu file nhi phan dua vao lop studentList

    public String toString(){
        this.DoB = setDoB(DoB);
        this.studentID = getStudentID();
        this.Email = convertEmail();
        this.fullName = convertFullName(fullName);
        return this.studentID + " " + this.fullName + " " + this.DoB + " " + this.phoneNo + " " + this.Email + " " + this.Gender + " " + this.Address + " " + this.Major + " " + this.classID;
    }

}

//BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("Student.in")); 
        ArrayList<Student> studentList = (ArrayList<Student>)o.readObject(); 

        while (true) {
            System.out.println("1. Add new student");
            System.out.println("2. View all students");
            System.out.println("3. Modify information");
            System.out.println("4.Exit ");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Thêm sinh viên mới
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
                    studentList.add(newStudent);
                    System.out.println("Student added successfully!");

                    // Ghi lại danh sách sinh viên vào file
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.in"));
                    oos.writeObject(studentList);
                    oos.close(); // Đóng ObjectOutputStream sau khi ghi
                    break;

                case 2:
                    // Xem danh sách sinh viên
                    System.out.println("List of Students:");
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    break;

                case 3:
                    //modify
                    System.out.print("Enter studentID to Modify: ");
                    String studentIDToModify = sc.nextLine();
                    for(Student student:studentList){
                        if(student.getStudentID().equals(studentIDToModify)){
                            student.viewModifyInfor(studentList);
                            break;
                        }
                    }
                    break; 
                
                case 4:
                    //quit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
*/
