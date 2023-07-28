import javax.swing.*;
import java.io.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

public class Job_pane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Job_pane::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Input Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Parameter name field
        JLabel nameLabel = new JLabel("Name (String):");
        frame.add(nameLabel);
        JTextField nameField = new JTextField(10);
        frame.add(nameField);

        // Age field
        JLabel ageLabel = new JLabel("Age (Int):");
        frame.add(ageLabel);
        JTextField ageField = new JTextField(3);
        frame.add(ageField);

        ageField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (ageField.getText().length() > 3) {
                    e.consume();
                    System.out.println("Please enter age between 1 and 100!");
                } else if (!Character.isDigit(c)) {
                    e.consume();
                    System.out.println("Please enter a number!");
                }
            }
        });

        // income field
        JLabel incomeLabel = new JLabel("Income (Int):");
        frame.add(incomeLabel);
        JTextField incomeField = new JTextField(10);
        frame.add(incomeField);

       incomeField.addKeyListener(new KeyAdapter() {
//           @Override
           public void keyTyped(KeyEvent e) {
               char c = e.getKeyChar();
               if (!Character.isDigit(c) || incomeField.getText().length() < 0 || incomeField.getText().length() > 12) {
                   e.consume();
                   System.out.print("Get serious and enter your real income");
               }
           }
       }); // Input filed rule


        // Gender field with dropdown list
        JLabel genderLabel = new JLabel("Gender:");
        frame.add(genderLabel);
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderSelector = new JComboBox<>(genders);
        frame.add(genderSelector);

        // File input
        JLabel fileLabel = new JLabel("Input File:");
        frame.add(fileLabel);
        JButton fileButton = new JButton("Choose File");
        frame.add(fileButton);
        JFileChooser fileChooser = new JFileChooser();
        fileButton.addActionListener(e -> fileChooser.showOpenDialog(frame));

        // Boolean radio buttons
        JLabel booleanLabel = new JLabel("Boolean Value:");
        frame.add(booleanLabel);
        ButtonGroup group = new ButtonGroup();
        JRadioButton trueButton = new JRadioButton("True");
        group.add(trueButton);
        frame.add(trueButton);
        JRadioButton falseButton = new JRadioButton("False");
        group.add(falseButton);
        frame.add(falseButton);

        // Submit button
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(frame, "Invalid name. Only alphabets are allowed.");
                    return;
                }

                String age = ageField.getText();
                try {
                    Integer.parseInt(age);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid age. Only integers are allowed.");
                    return;
                }

                String gender = (String) genderSelector.getSelectedItem();

                // Show submitted data
                JOptionPane.showMessageDialog(frame,
                        "Name: " + name + "\n" +
                                "Age: " + age + "\n" +
                                "Gender: " + gender);

                // Clear the fields
                nameField.setText("");
                ageField.setText("");
                genderSelector.setSelectedIndex(0);
            }
        });

        submitButton.addActionListener(e -> {
            try {
                // Show the save dialog
                int returnValue = fileChooser.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();

                    // Get the information you want to save
                    String infoToSave = ageField.getText();

                    // Use a BufferedWriter to write the information to the file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile, true))) {
                        writer.write(infoToSave);
                        writer.newLine();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        frame.add(submitButton);
        frame.pack();
        frame.setVisible(true);
    }
}
