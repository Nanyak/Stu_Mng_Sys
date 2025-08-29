package stu_mng_sys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Stu_Mng_Sys extends JFrame {
    private final studentWindow stWindow;
    private final classesWindow clWindow;
    private final subjectWindow suWindow;
    private final scoresWindow scWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stu_Mng_Sys::new); //Make this program thread-safe (?)
    }

    public Stu_Mng_Sys() {
        super("Student Management System");

        //Create windows for all functions
        stWindow = new studentWindow(this);
        clWindow = new classesWindow(this);
        suWindow = new subjectWindow(this);
        scWindow = new scoresWindow(this);

        //Create main program frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        //Create homepage
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1280, 720);
        add(mainPanel);

        //Create contents in homepage
        JLabel mainLabel = new JLabel("Student Management System"); //homepage label
        mainLabel.setFont(new Font("Arial", Font.BOLD, 60));
        mainLabel.setBounds(230, 80, 1000, 100);
        mainPanel.add(mainLabel);

        JButton studentButton = new JButton("Student Management"); //Student management button
        studentButton.setFont(new Font("Arial", Font.BOLD, 25));
        studentButton.setBounds(160, 280, 400, 100);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stWindow.setVisible(true); //Student management window visible when pressing the button
            }
        });
        mainPanel.add(studentButton);

        JButton classesButton = new JButton("Classes Management"); //Classes management button
        classesButton.setFont(new Font("Arial", Font.BOLD, 25));
        classesButton.setBounds(720, 280, 400, 100);
        classesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clWindow.setVisible(true); //Classes management window visible when pressing the button
            }
        });
        mainPanel.add(classesButton);

        JButton subjectButton = new JButton("Subject Management"); //Subject management button
        subjectButton.setFont(new Font("Arial", Font.BOLD, 25));
        subjectButton.setBounds(160, 450, 400, 100);
        subjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suWindow.setVisible(true); //Subject management window visible when pressing the button
            }
        });
        mainPanel.add(subjectButton);

        JButton scoresButton = new JButton("Scores Management"); //Scores management button
        scoresButton.setFont(new Font("Arial", Font.BOLD, 25));
        scoresButton.setBounds(720, 450, 400, 100);
        scoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scWindow.setVisible(true); //Scores management window visible when pressing the button
            }
        });
        mainPanel.add(scoresButton);
    }
}
