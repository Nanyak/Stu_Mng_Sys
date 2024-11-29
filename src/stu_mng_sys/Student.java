package stu_mng_sys;
import java.util.*;

public class Student {
    private String studentID, fullName, DoB, Gender, Address, Email, phoneNo, classID,Major;
    public int index = 0;
    private static ArrayList<Student>studentList = new ArrayList<>();
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

    
    
    public void addNewStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter student date of birth: ");
        String DoB = sc.nextLine();
        System.out.print("Enter student gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter student address: ");
        String address = sc.nextLine();
        System.out.print("Enter student phone number: ");
        String phoneNo = sc.nextLine();
        System.out.print("Enter student class ID: ");
        String classID = sc.nextLine();
        System.out.print("Enter student major: ");
        String major = sc.nextLine();

        // Check the information of student are exist or not.
        Student newStudent = new Student(fullName,DoB,gender,address,phoneNo,classID,major);
        String studentID = newStudent.getStudentID();
        for(Student student:studentList){
            if(student.getStudentID().equals(studentID)){
                System.out.println("The StudentID is exists");
                return;
            }
        }
        // Add new student to the list
        studentList.add(newStudent);
    }

    public void viewModifyInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter studentID: ");
        String searchID = sc.nextLine();
        //Find the information of student in the list
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
        //Display the information of student
        System.out.println("Student information:");
        System.out.println(foundStudent.toString());

        //Modify the information of student
        System.out.println("Do you want to modify the student information? (y/n) ");
        String option = sc.nextLine();
        if(option.equalsIgnoreCase("y")){
            System.out.print("Enter new full name: ");
            String newFullName = sc.nextLine();

            System.out.print("Enter new date of birth (dd/MM/yyyy): ");
            String newDoB = sc.nextLine();

            System.out.print("Enter new gender: ");
            String newGender = sc.nextLine();

            System.out.print("Enter new address: ");
            String newAddress = sc.nextLine();

            System.out.print("Enter new phone number: ");
            String newPhoneNo = sc.nextLine();

            System.out.print("Enter new class ID: ");
            String newClassID = sc.nextLine();

            System.out.print("Enter new major: ");
            String newMajor = sc.nextLine();

            //Update the information of student to the list;
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                if (student.getStudentID().equals(foundStudent.getStudentID())) {
                    String name = student.convertFullName(newFullName);
                    String birth = student.setDoB(newDoB);
                    String gender = this.Gender = newGender;
                    this.Address = newAddress;
                    this.phoneNo = newPhoneNo;
                    this.classID = newClassID;
                    this.Major = newMajor;
                    // studentList.add(new Student(name,birth,gender,this.Address,this.phoneNo,this.classID,this.Major));
                    studentList.set(i,student);
                    break;
                }
            }

            System.out.println("Student information updated successfully!");
        }

    }

    public String toString(){
        this.DoB = setDoB(DoB);
        this.studentID = getStudentID();
        this.Email = convertEmail();
        this.fullName = convertFullName(fullName);
        return this.studentID + " " + this.fullName + " " + this.DoB + " " + this.phoneNo + " " + this.Email + " " + this.Gender + " " + this.Address + " " + this.Major + " " + this.classID;
    }

}
