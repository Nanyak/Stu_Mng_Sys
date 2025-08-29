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

    // ghi thong tin vao file nhi phan
    public static void writeScoreToFile(String fileName, Scores score) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            os.writeObject(score);
            System.out.println("Scores information saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    // Doc danh sach diem tu file nhi phan
    public static ArrayList<Scores> readScoresFromFile(String fileName) throws ClassNotFoundException {
        ArrayList<Scores> scoresList = new ArrayList<>();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                Scores score = (Scores) is.readObject();
                scoresList.add(score);
            }
        } catch (EOFException e) {
            // Khi gap EOF, khong con gi de doc nua
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
        }
        return scoresList;
    }

    @Override
    public String toString(){
        return this.attendanceScore + " " + this.processScore + " " + this.midtermScore + " " + this.finalScore + " " + " " + this.student + " " + subject.getSubjectName();
    }

}
// BE PHAN DUOI NAY VAO HAM MAIN NEU CAN
/*
        Scanner sc = new Scanner(System.in);
        ArrayList<Subject> subjectList = new ArrayList<>();
        String fileName = "Subjects.in";

        // Kiểm tra xem file có tồn tại và có dữ liệu không
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try {
                subjectList.addAll(Subject.readSubjectFromFile(fileName));
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found exception: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("1. Add new subject");
            System.out.println("2. View all subjects");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // them mon hoc moi
                    System.out.print("Enter subject ID: ");
                    String subjectID = sc.nextLine();
                    System.out.print("Enter subject name: ");
                    String subjectName = sc.nextLine();

                    Subject newSubject = new Subject(subjectID, subjectName);
                    subjectList.add(newSubject);
                    Subject.writeSubjectToFile(fileName, newSubject); // Ghi môn học vào file
                    System.out.println("Subject added successfully!");
                    break;

                case 2: // xem danh sach mon hoc
                    System.out.println("List of Subjects:");
                    for (Subject subject : subjectList) {
                        System.out.println(subject);
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