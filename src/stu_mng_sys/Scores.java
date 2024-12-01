
package stu_mng_sys;
import java.util.*;
import java.io.*;
public class Scores implements Serializable{
    private float attendanceScore, processScore, midtermScore, finalScore;
    private Student student; // Associate with Student class
    private Subject subject;// Compostion with Subject

    public Scores(){
        
    }
    
    public Scores (float attendanceScore, float processScore, float midtermScore, float finalScore, Student student, Subject subject){
        this.attendanceScore = setAttendanceScore(attendanceScore);
        this.processScore = setAttendanceScore(processScore); 
        this.midtermScore = setMidtermScore(midtermScore); 
        this.finalScore = setFinalScore(finalScore);
        this.student = student;
        this.subject = subject;
    }

    public Student getStudent() {
        return this.student;
    }

    public Subject getSubject() {
        return this.subject; 
    }
    
    
    
    public float setAttendanceScore(float d){
        if(d >= 0 && d <= 10) {
            this.attendanceScore = d;
            return this.attendanceScore;
        }
        else{
            System.out.println("Invalid attendance score. It must be between 0 and 10.");
            return 0;
        }
    }
    
    public float setProcessScore(float d){
        if(d >= 0 && d <= 10){
            this.processScore = d; 
            return this.processScore;
        }
        else{
            System.out.println("Invalid process score. It must be between 0 and 10.");
            return 0;
        }
    }
    
    
    public float setMidtermScore(float d){
        if(d >= 0 && d <= 10){
            this.midtermScore = d; 
            return this.midtermScore;
        }
        else{
            System.out.println("Invalid midterm score. It must be between 0 and 10.");
            return 0;
        }
    }
    
    public float setFinalScore(float d){
        if(d >= 0 && d <= 10){
            this.finalScore = d; 
            return this.finalScore;
        }
        else{
            System.out.println("Invalid final score. It must be between 0 and 10.");
            return 0;
        }
    }
    
    // Xem quá trình học tập
    public void viewLearningProcess(){
        System.out.println("Learning Process for " + student.getFullName() + " in " + subject.getSubjectName() + ":");
        System.out.println("Attendance Score: " + attendanceScore);
        System.out.println("Process Score: " + processScore);
        System.out.println("Midterm Score: " + midtermScore);
        System.out.println("Final Score: " + finalScore);
    }
    
    // Chỉnh sửa điểm
    public void ModifyScore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Modify scores for " + student.getFullName() + " in " + subject.getSubjectName());

        System.out.print("Enter new Attendance Score: ");
        float newAttendance = sc.nextFloat();
        setAttendanceScore(newAttendance);

        System.out.print("Enter new Process Score: ");
        float newProcess = sc.nextFloat();
        setProcessScore(newProcess);

        System.out.print("Enter new Midterm Score: ");
        float newMidterm = sc.nextFloat();
        setMidtermScore(newMidterm);

        System.out.print("Enter new Final Score: ");
        float newFinal = sc.nextFloat();
        setFinalScore(newFinal);

        System.out.println("Scores updated successfully!");
    }
    

    public String toString(){   
        return this.attendanceScore + " " + this.processScore + " " + this.midtermScore + " " + this.finalScore + " " + " " + this.student + " " + subject.getSubjectName(); 
    }
    
}
// BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("Scores.in"));
        ArrayList<Scores> scoresList = (ArrayList<Scores>)o.readObject();
        while (true) {
            System.out.println("1. Add new score");
            System.out.println("2. View all scores");
            System.out.println("3. Modify score");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Thêm điểm mới
                    // Nhập thông tin điểm
                    System.out.print("Enter attendance score: ");
                    float attendanceScore = sc.nextFloat();
                    System.out.print("Enter process score: ");
                    float processScore = sc.nextFloat();
                    System.out.print("Enter midterm score: ");
                    float midtermScore = sc.nextFloat();
                    System.out.print("Enter final score: ");
                    float finalScore = sc.nextFloat();
                    sc.nextLine(); // Đọc dòng mới

                    // Nhập thông tin sinh viên và môn học
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
                    System.out.print("Enter subject ID: ");
                    String subjectID = sc.nextLine();
                    System.out.print("Enter subject name: ");
                    String subjectName = sc.nextLine();
                    Subject subject = new Subject(subjectID,subjectName,newStudent); // Cung cấp các thông tin cần thiết

                    // Tạo đối tượng Scores và thêm vào danh sách
                    Scores newScore = new Scores(attendanceScore, processScore, midtermScore, finalScore, newStudent, subject);
                    scoresList.add(newScore);

                    // Ghi danh sách điểm vào file
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Scores.in"))) {
                        oos.writeObject(scoresList);
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                    System.out.println("Score added successfully!");
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Scores.in"));// ghi lai thong tin vao file 
                    oos.writeObject(classesList);
                    oos.close(); // Đóng ObjectOutputStream sau khi ghi
                    break;

                case 2: // Xem tất cả điểm
                    System.out.println("List of Scores:");
                    for (Scores score : scoresList) {
                        System.out.println(score);
                    }
                    break;

                case 3: // Sửa điểm
                    // Cần thêm logic để tìm và sửa điểm
                    System.out.print("Enter student full name to modify scores: ");
                    String studentNameToModify = sc.nextLine();
                    System.out.print("Enter subject name to modify scores: ");
                    String subjectNameToModify = sc.nextLine();

                    boolean found = false;
                    for(Scores score:scoresList){
                        if (score.getStudent().getFullName().equalsIgnoreCase(studentNameToModify) &&
                        score.getSubject().getSubjectName().equalsIgnoreCase(subjectNameToModify)) {
                        score.ModifyScore(); // Gọi phương thức sửa điểm
                        found = true;
                        break; // Kết thúc vòng lặp khi tìm thấy
                        }       
                    }

                    if (!found) {
                        System.out.println("No matching scores found for this student and subject.");
                    }
                    break;

                case 4: // Thoát
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
*/
