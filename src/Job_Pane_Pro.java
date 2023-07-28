import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Job_Pane_Pro {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Input Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Parameter name field
        JLabel nameLabel = new JLabel("Name (String):");
//        - This line of code creates a new JLabel object with the text "Age (Int):".
//        The text within the parentheses is what will be displayed as the label.
        frame.add(nameLabel);
/* This line adds the ageLabel object to the JFrame object represented by the variable frame.
The add method is used to place components within a container (in this case, the JFrame).*/

        JTextField nameField = new JTextField(10); //
        frame.add(nameField);

        // Age field
        JLabel ageLabel = new JLabel("Age (Int):"); // create a label
        frame.add(ageLabel); // add it to the frame

        JTextField ageField = new JTextField(3);
//        the '3' argument means the text field is sized to display 10 characters wide.
        frame.add(ageField); // add it to the frame


        // income field
        JLabel incomeLabel = new JLabel("Income (Int):");
        frame.add(incomeLabel);

        JTextField incomeField = new JTextField(3);
        frame.add(incomeField);

        /* Income field
        JLabel incomeLabel = new JLabel("Income (Int):");
        frame.add(incomeLabel);

        JTextField incomeField = new JTextField(3);
        frame.add(incomeField);
        note: case sensitive, wrong spell will lead to error
        */




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
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }
}
