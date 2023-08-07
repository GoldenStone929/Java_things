import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class serverRead_JobPane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(serverRead_JobPane::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("XY Scatter Plot Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Assuming you've fetched this from the server
        JobInfo jobInfo = fetchJobInfoFromServer();

        // Display name and details
        JLabel nameLabel = new JLabel(jobInfo.getName());
        frame.add(nameLabel);

        JLabel detailsLabel = new JLabel(jobInfo.getDetails());
        frame.add(detailsLabel);

        // Source field with browse button
        JLabel sourceLabel = new JLabel("Source:");
        frame.add(sourceLabel);

        JTextField sourceField = new JTextField(jobInfo.getSource());
        frame.add(sourceField);

        JButton browseButton = new JButton("Browse...");
        JFileChooser fileChooser = new JFileChooser();
        browseButton.addActionListener(e -> {
            int returnValue = fileChooser.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                sourceField.setText(fileChooser.getSelectedFile().getPath());
            }
        });
        frame.add(browseButton);

        // Other fields with labels above them
        JLabel xPropertyLabel = new JLabel("X Property:");
        frame.add(xPropertyLabel);
        JTextField xPropertyField = new JTextField(jobInfo.getXProperty());
        frame.add(xPropertyField);

        JLabel yPropertyLabel = new JLabel("Y Property:");
        frame.add(yPropertyLabel);
        JTextField yPropertyField = new JTextField(jobInfo.getYProperty());
        frame.add(yPropertyField);

        JLabel fileTypeLabel = new JLabel("File Type:");
        frame.add(fileTypeLabel);
        JComboBox<String> fileTypeSelector = new JComboBox<>(new String[]{jobInfo.getFileType()});
        frame.add(fileTypeSelector);

        JLabel tooltipLabel = new JLabel("Tooltip:");
        frame.add(tooltipLabel);
        JTextField tooltipField = new JTextField(jobInfo.getTooltip());
        frame.add(tooltipField);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Gather inputs
            jobInfo.setSource(sourceField.getText());
            jobInfo.setXProperty(xPropertyField.getText());
            jobInfo.setYProperty(yPropertyField.getText());
            jobInfo.setFileType((String) fileTypeSelector.getSelectedItem());
            jobInfo.setTooltip(tooltipField.getText());

            // Handle the updated jobInfo (e.g., send it back to the server)
            processJobInfo(jobInfo);
        });
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }

    private static JobInfo fetchJobInfoFromServer() {
        // Mock fetching from server by randomly selecting one of three examples
        Random rand = new Random();
        int exampleNumber = rand.nextInt(3) + 1;

        JobInfo jobInfo = new JobInfo();

        switch (exampleNumber) {
            case 1:
                jobInfo.setName("Sample Job 1");
                jobInfo.setDetails("Details for job 1");
                jobInfo.setSource("./data/sample1.txt");
                jobInfo.setXProperty("X1");
                jobInfo.setYProperty("Y1");
                jobInfo.setFileType("PDF");
                jobInfo.setTooltip("Tooltip 1");
                break;

            case 2:
                jobInfo.setName("Sample Job 2");
                jobInfo.setDetails("Details for job 2");
                jobInfo.setSource("./data/sample2.txt");
                jobInfo.setXProperty("X2");
                jobInfo.setYProperty("Y2");
                jobInfo.setFileType("TXT");
                jobInfo.setTooltip("Tooltip 2");
                break;

            case 3:
                jobInfo.setName("Sample Job 3");
                jobInfo.setDetails("Details for job 3");
                jobInfo.setSource("./data/sample3.txt");
                jobInfo.setXProperty("X3");
                jobInfo.setYProperty("Y3");
                jobInfo.setFileType("DOC");
                jobInfo.setTooltip("Tooltip 3");
                break;
        }

        return jobInfo;
    }

    private static void processJobInfo(JobInfo jobInfo) {
        // Handle the updated jobInfo here (e.g., send it back to the server)
        // For this example, I'll just display the updated data.
        JOptionPane.showMessageDialog(null, "Processed Job Info:\n" + jobInfo.toString());
    }
}

class JobInfo {
    private String name;
    private String details;
    private String source;
    private String xProperty;
    private String yProperty;
    private String fileType;
    private String tooltip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getXProperty() {
        return xProperty;
    }

    public void setXProperty(String xProperty) {
        this.xProperty = xProperty;
    }

    public String getYProperty() {
        return yProperty;
    }

    public void setYProperty(String yProperty) {
        this.yProperty = yProperty;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDetails: " + details + "\nSource: " + source + "\nX Property: " + xProperty + "\nY Property: " + yProperty + "\nFile Type: " + fileType + "\nTooltip: " + tooltip;
    }
}
