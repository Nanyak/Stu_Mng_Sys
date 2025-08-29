package stu_mng_sys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class studentWindow extends JFrame {
    private final JLabel studentLabel = new JLabel("Student Management");
    private final JButton addStudentButton = new JButton("Add New Student");
    private final JButton modifyInfoButton = new JButton("Modify Information");
    String[][] studentInit = {};
    String[] studentAttributes = {"Student ID", "Full Name", "Date of Birth", "Gender", "Address", "Email", "Phone Number", "Class", "Major"};
    private final JTable studentTable = new JTable(studentInit, studentAttributes);
    private final JLabel studentFilterLabel = new JLabel("Search for Student ID");
    private final JTextField studentFilterTextField = new JTextField();
    private final JButton studentFilterButton = new JButton("Search");
    private final JFrame newStudentFormFrame = new JFrame("Add New Student");
    private final JFrame modifyInformationFormFrame = new JFrame("Modify Student's Information");
    private final Stu_Mng_Sys mainApp;

    public studentWindow(Stu_Mng_Sys mainApp) {
        //Create student management function window
        super("Student Management");
        this.mainApp = mainApp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        //Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1280, 720);
        add(mainPanel);

        //Create contents in this window
        //Window's label
        studentLabel.setFont(new Font("Arial", Font.BOLD, 40));
        studentLabel.setBounds(440, 50, 500, 60);
        mainPanel.add(studentLabel);

        //Add new student function button
        addStudentButton.setBounds(50, 150, 200, 30);
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newStudentFormFrame.isVisible()) {
                    newStudentFormFrame.setVisible(true); //Show add new student window
                    newStudentForm();
                }
            }
        });
        mainPanel.add(addStudentButton);

        //Students' information table, import from data file
        JScrollPane studentScrollPane = new JScrollPane(studentTable); //Create students' information table
        mainPanel.add(studentScrollPane);
        studentScrollPane.setBounds(40, 200, 1200, 420);

        //Student filter text field
        studentFilterLabel.setFont(new Font("Arial", Font.BOLD, 15));
        studentFilterLabel.setBounds(350, 150, 200, 30);
        mainPanel.add(studentFilterLabel);

        studentFilterTextField.setBounds(530, 150, 200, 30);
        mainPanel.add(studentFilterTextField);

        studentFilterButton.setBounds(750, 150, 200, 30);
        studentFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Find the record matches with the correspond student ID

            }
        });
        mainPanel.add(studentFilterButton);

        //Modify information function button
        modifyInfoButton.setBounds(1030, 150, 200, 30);
        modifyInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!modifyInformationFormFrame.isVisible()) {
                    modifyInformationFormFrame.setVisible(true); //Show add new student window
                    modifyInformationForm();
                }
            }
        });
        mainPanel.add(modifyInfoButton);

        //Add new student window
        newStudentFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newStudentFormFrame.setSize(640, 480);
        newStudentFormFrame.setLayout(null);
        newStudentFormFrame.setLocationRelativeTo(null);
        newStudentFormFrame.setResizable(false);

        //Modify student's information
        modifyInformationFormFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyInformationFormFrame.setSize(640, 480);
        modifyInformationFormFrame.setLayout(null);
        modifyInformationFormFrame.setLocationRelativeTo(null);
        modifyInformationFormFrame.setResizable(false);
    }

    public void modifyInformationForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setSize(640, 480);
        modifyInformationFormFrame.add(formPanel);

        JLabel newStudentFormLabel = new JLabel("Modify Student's Information");
        newStudentFormLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newStudentFormLabel.setBounds(110, 20, 500, 40);
        formPanel.add(newStudentFormLabel);

        JLabel studentIDLabel = new JLabel("Student ID");
        studentIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        studentIDLabel.setBounds(100, 90, 100, 30);
        formPanel.add(studentIDLabel);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        fullNameLabel.setBounds(100, 125, 100, 30);
        formPanel.add(fullNameLabel);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.BOLD, 15));
        dobLabel.setBounds(100, 160, 100, 30);
        formPanel.add(dobLabel);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 15));
        genderLabel.setBounds(100, 195, 100, 30);
        formPanel.add(genderLabel);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        addressLabel.setBounds(100, 230, 100, 30);
        formPanel.add(addressLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setBounds(100, 265, 100, 30);
        formPanel.add(phoneLabel);

        JLabel classIDLabel = new JLabel("Class ID:");
        classIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        classIDLabel.setBounds(100, 300, 100, 30);
        formPanel.add(classIDLabel);

        JLabel majorLabel = new JLabel("Major: ");
        majorLabel.setFont(new Font("Arial", Font.BOLD, 15));
        majorLabel.setBounds(100, 335, 100, 30);
        formPanel.add(majorLabel);

        JTextField studentIDTextField = new JTextField();
        studentIDTextField.setBounds(250, 90, 290, 30);
        studentIDTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When the student ID match the data in data file, return all scores in their correspond text field

            }
        });
        formPanel.add(studentIDTextField);

        JTextField fullNameField = new JTextField();
        fullNameField.setBounds(250, 125, 290, 30);
        formPanel.add(fullNameField);

        JTextField dobField = new JTextField();
        dobField.setBounds(250, 160, 290, 30);
        formPanel.add(dobField);

        JTextField genderField = new JTextField();
        genderField.setBounds(250, 195, 290, 30);
        formPanel.add(genderField);

        JTextField addressField = new JTextField();
        addressField.setBounds(250, 230, 290, 30);
        formPanel.add(addressField);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(250, 265, 290, 30);
        formPanel.add(phoneField);

        JTextField classIDField = new JTextField();
        classIDField.setBounds(250, 300, 290, 30);
        formPanel.add(classIDField);

        JTextField majorField = new JTextField();
        majorField.setBounds(250, 335, 290, 30);
        formPanel.add(majorField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBounds(220, 380, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When no field is null, save information to the data file and show a message "Added successfully"
                //Update table by pushing the data from data file again

            }
        });
        formPanel.add(submitButton);
    }

    public void newStudentForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setSize(640, 480);
        newStudentFormFrame.add(formPanel);

        JLabel newStudentFormLabel = new JLabel("Add New Student");
        newStudentFormLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newStudentFormLabel.setBounds(190, 20, 300, 40);
        formPanel.add(newStudentFormLabel);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        fullNameLabel.setBounds(100, 80, 100, 30);
        formPanel.add(fullNameLabel);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.BOLD, 15));
        dobLabel.setBounds(100, 120, 100, 30);
        formPanel.add(dobLabel);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 15));
        genderLabel.setBounds(100, 160, 100, 30);
        formPanel.add(genderLabel);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        addressLabel.setBounds(100, 200, 100, 30);
        formPanel.add(addressLabel);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setBounds(100, 240, 100, 30);
        formPanel.add(phoneLabel);

        JLabel classIDLabel = new JLabel("Class ID:");
        classIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        classIDLabel.setBounds(100, 280, 100, 30);
        formPanel.add(classIDLabel);

        JLabel majorLabel = new JLabel("Major: ");
        majorLabel.setFont(new Font("Arial", Font.BOLD, 15));
        majorLabel.setBounds(100, 320, 100, 30);
        formPanel.add(majorLabel);

        JTextField fullNameField = new JTextField();
        fullNameField.setBounds(250, 80, 290, 30);
        formPanel.add(fullNameField);

        JTextField dobField = new JTextField();
        dobField.setBounds(250, 120, 290, 30);
        formPanel.add(dobField);

        JTextField genderField = new JTextField();
        genderField.setBounds(250, 160, 290, 30);
        formPanel.add(genderField);

        JTextField addressField = new JTextField();
        addressField.setBounds(250, 200, 290, 30);
        formPanel.add(addressField);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(250, 240, 290, 30);
        formPanel.add(phoneField);

        JTextField classIDField = new JTextField();
        classIDField.setBounds(250, 280, 290, 30);
        formPanel.add(classIDField);

        JTextField majorField = new JTextField();
        majorField.setBounds(250, 320, 290, 30);
        formPanel.add(majorField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBounds(220, 380, 200, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When no field is null, save information to the data file and show a message "Added successfully"
                //Update students table by pushing the data from data file again

            }
        });
        formPanel.add(submitButton);
    }
}
