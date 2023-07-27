import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeViewer extends JFrame {
    public TreeViewer() {
        setTitle("Tree Viewer");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String response = JOptionPane.showInputDialog("Enter the number of folders:");
        int folderCount = Integer.parseInt(response);

        // Create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Use recursion to create the folder structure
        createFolders(root, 1, folderCount);

        // Create the tree
        JTree tree = new JTree(root);
        tree.setEditable(true);  // Allow user to edit node names
        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));

        add(new JScrollPane(tree));

        setVisible(true);
    }

    private void createFolders(DefaultMutableTreeNode parent, int current, int folderCount) {
        if (current <= folderCount) {
            DefaultMutableTreeNode folder = new DefaultMutableTreeNode("Folder " + current);

            // Each folder contains a fixed number of files (3 in this case)
            for (int i = 1; i <= 3; i++) {
                DefaultMutableTreeNode file = new DefaultMutableTreeNode("File " + i);
                folder.add(file);
            }

            parent.add(folder);

            // Recursively create the rest of the folders
            createFolders(parent, current + 1, folderCount);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TreeViewer::new);
    }
}
