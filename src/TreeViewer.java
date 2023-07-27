// Import the necessary classes from the Swing library
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

// Define a public class TreeViewer that extends JFrame
public class TreeViewer extends JFrame {

    // The constructor for TreeViewer
    public TreeViewer() {
        // Set the title of the JFrame
        setTitle("Tree Viewer");
        // Set the initial size of the JFrame
        setSize(1800, 1024);
        // Specify the operation when the JFrame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a dialog box to get the number of folders from the user
        String response = JOptionPane.showInputDialog("Enter the number of folders:");
        // Convert the user's response to an integer
        int folderCount = Integer.parseInt(response);

        // Create the root node for the JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Call the recursive method to create the folder structure in the JTree
        // Starting from the first folder (current = 1)
        createFolders(root, 1, folderCount);

        // Create the JTree with the root node
        JTree tree = new JTree(root);
        // Make the JTree nodes editable
        tree.setEditable(true);
        // Set a cell editor to handle changes to the node values
        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));

        // Add the JTree to a JScrollPane and add it to the JFrame
        add(new JScrollPane(tree));

        // Make the JFrame visible
        setVisible(true);
    }

    // Define a recursive method to create the folders in the JTree
    private void createFolders(DefaultMutableTreeNode parent, int current, int folderCount) {
        // If the current folder number is less than or equal to the total number of folders...
        if (current <= folderCount) {
            // Create a new folder node
            DefaultMutableTreeNode folder = new DefaultMutableTreeNode("Folder " + current);

            // Add three file nodes to the folder
            for (int i = 1; i <= 3; i++) {
                DefaultMutableTreeNode file = new DefaultMutableTreeNode("File " + i);
                folder.add(file);
            }

            // Add the folder to the parent node (initially, this is the root node)
            parent.add(folder);

            // Recursively call this method to create the rest of the folders
            createFolders(parent, current + 1, folderCount);
        }
    }

    // The main method that launches the application
    public static void main(String[] args) {
        // Start the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(TreeViewer::new);
    }
}
