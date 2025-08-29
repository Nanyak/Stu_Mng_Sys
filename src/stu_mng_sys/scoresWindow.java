package stu_mng_sys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class scoresWindow extends JFrame {
    private final JLabel scoresLabel = new JLabel("Scores Management");
    private final JButton modifyScoresButton = new JButton("Modify Scores");
    String[][] scoresInit = {};
    String[] scoresAttributes = {"Student ID", "Student Name", "Class ID", "Subject ID", "Attendance Score", "Process Score", "Midterm Score", "Final Score", "GPA"};
    private final JTable scoresTable = new JTable(scoresInit, scoresAttributes);
    private final JLabel studentFilterLabel = new JLabel("Search for Student ID");
    private final JTextField studentFilterTextField = new JTextField();
    private final JButton studentFilterButton = new JButton("Search");
    private final JFrame modifyScoresFormFrame = new JFrame("Modify Scores");
    private final Stu_Mng_Sys mainApp;

    public scoresWindow(Stu_Mng_Sys mainApp) {
        //Create student management function window
        super("Scores Management");
        this.mainApp = mainApp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        //Create contents in this window
        //Window's label
        scoresLabel.setFont(new Font("Arial", Font.BOLD, 40));
        scoresLabel.setBounds(440, 50, 500, 60);
        add(scoresLabel);

        //Add new student function button
        modifyScoresButton.setBounds(50, 150, 200, 30);
        modifyScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!modifyScoresFormFrame.isVisible()) {
                    modifyScoresFormFrame.setVisible(true); //Show add new subject window
                    modifyScoresForm();
                }
            }
        });
        add(modifyScoresButton);

        //Students' subjects table, import from data file
        JScrollPane studentScrollPane = new JScrollPane(scoresTable); //Create students' subjects table
        add(studentScrollPane);
        studentScrollPane.setBounds(40, 200, 1200, 420);

        //Student filter
        studentFilterLabel.setFont(new Font("Arial", Font.BOLD, 15));
        studentFilterLabel.setBounds(350, 150, 200, 30);
        add(studentFilterLabel);

        studentFilterTextField.setBounds(530, 150, 200, 30);
        add(studentFilterTextField);

        studentFilterButton.setBounds(750, 150, 200, 30);
        studentFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Find all records match with the correspond student ID

            }
        });
        add(studentFilterButton);

        //Modify scores window
        modifyScoresFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyScoresFormFrame.setSize(640, 480);
        modifyScoresFormFrame.setLayout(null);
        modifyScoresFormFrame.setLocationRelativeTo(null);
        modifyScoresFormFrame.setResizable(false);
    }

    public void modifyScoresForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setSize(640, 480);
        modifyScoresFormFrame.add(formPanel);

        JLabel modifyScoresFormLabel = new JLabel("Modify Student's Scores");
        modifyScoresFormLabel.setFont(new Font("Arial", Font.BOLD, 30));
        modifyScoresFormLabel.setBounds(140, 20, 400, 40);
        formPanel.add(modifyScoresFormLabel);

        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        studentIDLabel.setBounds(100, 80, 150, 30);
        formPanel.add(studentIDLabel);

        JLabel subjectIDLabel = new JLabel("Subject ID:");
        subjectIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subjectIDLabel.setBounds(100, 130, 150, 30);
        formPanel.add(subjectIDLabel);

        JLabel attendanceScoreLabel = new JLabel("Attendance Score:");
        attendanceScoreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        attendanceScoreLabel.setBounds(100, 180, 150, 30);
        formPanel.add(attendanceScoreLabel);

        JLabel processScoreLabel = new JLabel("Process Score:");
        processScoreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        processScoreLabel.setBounds(100, 230, 150, 30);
        formPanel.add(processScoreLabel);

        JLabel midtermScoreLabel = new JLabel("Mid-term Score:");
        midtermScoreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        midtermScoreLabel.setBounds(100, 280, 150, 30);
        formPanel.add(midtermScoreLabel);

        JLabel finalScoreLabel = new JLabel("Final Score:");
        finalScoreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        finalScoreLabel.setBounds(100, 330, 150, 30);
        formPanel.add(finalScoreLabel);

        JTextField studentIDField = new JTextField();
        studentIDField.setBounds(250, 80, 290, 30);
        formPanel.add(studentIDField);

        JTextField subjectIDField = new JTextField();
        subjectIDField.setBounds(250, 130, 290, 30);
        subjectIDField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When the student ID and subject ID match the data in data file, return all scores in their correspond text field

            }
        });
        formPanel.add(subjectIDField);

        JTextField attendanceScoreField = new JTextField();
        attendanceScoreField.setBounds(250, 180, 290, 30);
        formPanel.add(attendanceScoreField);

        JTextField processScoreField = new JTextField();
        processScoreField.setBounds(250, 230, 290, 30);
        formPanel.add(processScoreField);

        JTextField midtermScoreField = new JTextField();
        midtermScoreField.setBounds(250, 280, 290, 30);
        formPanel.add(midtermScoreField);

        JTextField finalScoreField = new JTextField();
        finalScoreField.setBounds(250, 330, 290, 30);
        formPanel.add(finalScoreField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBounds(220, 380, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When no field is null, save information to the data file and show a message "Modified successfully"

            }
        });
        formPanel.add(submitButton);
    }
}
