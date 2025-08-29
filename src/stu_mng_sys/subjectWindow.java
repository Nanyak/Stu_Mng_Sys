package stu_mng_sys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class subjectWindow extends JFrame {
    private final JLabel subjectLabel = new JLabel("Subject Management");
    private final JButton addNewSubjectButton = new JButton("Add New Subject");
    private final JButton newRegistrationButton = new JButton("New/Cancel Registration");
    String[][] subjectInit = {};
    String[] subjectAttributes = {"Student ID", "Student Name", "Class ID", "Subject ID", "Subject Name"};
    private final JTable subjectTable = new JTable(subjectInit, subjectAttributes);
    private final JLabel studentFilterLabel = new JLabel("Search for Student ID");
    private final JTextField studentFilterTextField = new JTextField();
    private final JButton studentFilterButton = new JButton("Search");
    private final JFrame newRegistrationFormFrame = new JFrame("New/Cancel Registration");
    private final JFrame newSubjectFormFrame = new JFrame("Add New Subject");
    private final Stu_Mng_Sys mainApp;

    public subjectWindow(Stu_Mng_Sys mainApp) {
        //Create student management function window
        super("Subject Management");
        this.mainApp = mainApp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        //Create contents in this window
        //Window's label
        subjectLabel.setFont(new Font("Arial", Font.BOLD, 40));
        subjectLabel.setBounds(440, 50, 500, 60);
        add(subjectLabel);

        //New/cancel registration function button
        newRegistrationButton.setBounds(50, 150, 200, 30);
        newRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newRegistrationFormFrame.isVisible()) {
                    newRegistrationFormFrame.setVisible(true); //Show new/cancel registration window
                    newRegistrationForm();
                }
            }
        });
        add(newRegistrationButton);

        //Students' subjects table, import from data file
        JScrollPane studentScrollPane = new JScrollPane(subjectTable); //Create students' subjects table
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

        //Add new subject function button
        addNewSubjectButton.setBounds(1030, 150, 200, 30);
        addNewSubjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newSubjectFormFrame.isVisible()) {
                    newSubjectFormFrame.setVisible(true); //Show add new subject window
                    newSubjectForm();
                }
            }
        });
        add(addNewSubjectButton);

        //New registration window
        newRegistrationFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newRegistrationFormFrame.setSize(640, 480);
        newRegistrationFormFrame.setLayout(null);
        newRegistrationFormFrame.setLocationRelativeTo(null);
        newRegistrationFormFrame.setResizable(false);

        //Add new subject window
        newSubjectFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newSubjectFormFrame.setSize(640, 480);
        newSubjectFormFrame.setLayout(null);
        newSubjectFormFrame.setLocationRelativeTo(null);
        newSubjectFormFrame.setResizable(false);
    }

    public void newRegistrationForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setSize(640, 480);
        newRegistrationFormFrame.add(formPanel);

        JLabel newRegistrationFormLabel = new JLabel("New/Cancel Registration");
        newRegistrationFormLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newRegistrationFormLabel.setBounds(140, 20, 400, 40);
        formPanel.add(newRegistrationFormLabel);

        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        studentIDLabel.setBounds(100, 180, 100, 30);
        formPanel.add(studentIDLabel);

        JLabel subjectIDLabel = new JLabel("Subject ID:");
        subjectIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subjectIDLabel.setBounds(100, 230, 100, 30);
        formPanel.add(subjectIDLabel);

        JTextField studentIDField = new JTextField();
        studentIDField.setBounds(250, 180, 290, 30);
        formPanel.add(studentIDField);

        JTextField subjectIDField = new JTextField();
        subjectIDField.setBounds(250, 230, 290, 30);
        formPanel.add(subjectIDField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBounds(220, 380, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When no field is null, save information and show a message "Added/cancelled successfully"
                //If the data exists, cancel registration. Otherwise, add to the data file
                //Update table by pushing the data from data file again

            }
        });
        formPanel.add(submitButton);
    }

    public void newSubjectForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setSize(640, 480);
        newSubjectFormFrame.add(formPanel);

        JLabel newSubjectFormLabel = new JLabel("Add New Subject");
        newSubjectFormLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newSubjectFormLabel.setBounds(200, 20, 300, 40);
        formPanel.add(newSubjectFormLabel);

        JLabel subjectNameLabel = new JLabel("Subject Name:");
        subjectNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subjectNameLabel.setBounds(100, 180, 150, 30);
        formPanel.add(subjectNameLabel);

        JLabel subjectIDLabel = new JLabel("Subject ID:");
        subjectIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        subjectIDLabel.setBounds(100, 230, 100, 30);
        formPanel.add(subjectIDLabel);

        JTextField subjectNameField = new JTextField();
        subjectNameField.setBounds(250, 180, 290, 30);
        formPanel.add(subjectNameField);

        JTextField subjectIDField = new JTextField();
        subjectIDField.setBounds(250, 230, 290, 30);
        formPanel.add(subjectIDField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBounds(220, 380, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When no field is null, save information to the data file and show a message "Added successfully"

            }
        });
        formPanel.add(submitButton);
    }
}
