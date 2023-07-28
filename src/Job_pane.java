import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Job_pane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Input Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Parameter name field
        JLabel nameLabel = new JLabel("Name (String):");
        frame.add(nameLabel);

        JTextField nameField = new JTextField(10);
        frame.add(nameField);

        // Age field
        JLabel ageLabel = new JLabel("Age (Int):");
        frame.add(ageLabel);

        JTextField ageField = new JTextField(10);
        frame.add(ageField);

        // Gender field with dropdown list
        JLabel genderLabel = new JLabel("Gender:");
        frame.add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderSelector = new JComboBox<>(genders);
        frame.add(genderSelector);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
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
        frame.add(submitButton);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
