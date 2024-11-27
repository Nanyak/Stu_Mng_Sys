/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        String res;

        String[] dob = this.DoB.trim().split("/");
        int YoB = Integer.parseInt(dob[2].substring(2,4));
        String courseYear = String.valueOf((YoB+18)%100);

        String[] major = this.Major.trim().split("\\s++");
        StringBuilder majorTitle = new StringBuilder();
        for(int i=0; i<=1; i++){
            majorTitle.append(major[i].charAt(0));
        }

        res = "B" + courseYear + "DC" + majorTitle + String.format("%04d",index);
        return res.toUpperCase(); 
    }
    
    public String convertFullName(String fullName){
        String[] name = fullName.trim().split("\\s++");
        StringBuilder res = new StringBuilder();
        for (String s : name) {
            res.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).append(" ");
        }
        return res.toString();
    }

    public String setDoB(String s){
        if(s.charAt(1) == '/') s = "0" + s; 
        if(s.charAt(4) == '/') s = s.substring(0,3) + "0" + s.substring(3); 
        return s;  
    }
    
    public String convertEmail(){ // convert to get Email for student
        StringBuilder res = new StringBuilder();

        String[] name = this.fullName.trim().split("\\s++");
        String firstname = name[name.length-1];
        res.append(firstname);

        for(int i=0; i<name.length-1; i++){
            res.append(name[i].charAt(0));
        }
        res.append(".").append(getStudentID()).append("@stu.ptit.edu.vn");
        return res.toString().toLowerCase();
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
