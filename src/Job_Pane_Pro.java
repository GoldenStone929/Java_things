import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Job_Pane_Pro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Job_Pane_Pro::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Job Pane Pro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setMaximumSize(new Dimension(1024, 768));
        frame.setPreferredSize(new Dimension(800, 600));

        // Parameter name field
        JLabel nameLabel = new JLabel("Name (String):");
        frame.add(nameLabel);
        JTextField nameField = new JTextField(10);
        frame.add(nameField);

        nameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c) || nameField.getText().length() > 20) {
                    e.consume();
                    JOptionPane.showMessageDialog(frame, "Please enter a valid name");
                }
            }
        });

        // Age field
        JLabel ageLabel = new JLabel("Age (Int):");
        frame.add(ageLabel);
        JTextField ageField = new JTextField(3);
        frame.add(ageField);

        ageField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (ageField.getText().length() >= 3) {
                    e.consume();
//                    System.out.println("Please enter age between 1 and 100!");
                    JOptionPane.showMessageDialog(frame, "Do you not know your own Age?");
                } else if (!Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(frame, "Do you not know your own Age?");
                }
            }
        });

        // Income field
        JLabel incomeLabel = new JLabel("Income (Int):");
        frame.add(incomeLabel);
        JTextField incomeField = new JTextField(10);
        frame.add(incomeField);

        incomeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || incomeField.getText().length() > 12) {
                    e.consume();
                    JOptionPane.showMessageDialog(frame, "Get serious, what is your income?");
                }
            }
        });

        // Gender field with dropdown list
        JLabel genderLabel = new JLabel("Gender:");
        frame.add(genderLabel);
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderSelector = new JComboBox<>(genders);
        frame.add(genderSelector);

        // Boolean radio buttons
        JLabel booleanLabel = new JLabel("Are you satisfied:");
        frame.add(booleanLabel);
        ButtonGroup group = new ButtonGroup();
        JRadioButton trueButton = new JRadioButton("Yes I am");
        group.add(trueButton);
        frame.add(trueButton);
        JRadioButton falseButton = new JRadioButton("Nope, not at all");
        group.add(falseButton);
        frame.add(falseButton);

        // Submit button
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
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
        });

        frame.add(submitButton);
        frame.pack();
        frame.setVisible(true);
    }
}
