
package stu_mng_sys;
import java.util.*;
public class Scores  {
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
