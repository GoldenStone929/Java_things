import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newTree extends JFrame {
    private final DefaultTreeModel treeModel;

    public newTree() {
        setTitle("Tree Viewer");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String response = JOptionPane.showInputDialog("Enter the number of folders:");
        int folderCount = Integer.parseInt(response);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        createFolders(root, 1, folderCount);

        // Create the tree model and assign it to the JTree
        treeModel = new DefaultTreeModel(root);
        JTree tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));

        // Create the "Delete" button and its action listener
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            // Get the current selection path
            TreePath currentSelection = tree.getSelectionPath();
            if (currentSelection != null) {
                // Get the last node in the path (the selected node)
                DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
                MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
                if (parent != null) {
                    // Remove the current node from the tree model
                    treeModel.removeNodeFromParent(currentNode);
                }
            }
        });

        // Create a panel to hold the tree and the button
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(tree), BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void createFolders(DefaultMutableTreeNode parent, int current, int folderCount) {
        if (current <= folderCount) {
            DefaultMutableTreeNode folder = new DefaultMutableTreeNode("Folder " + current);
            for (int i = 1; i <= 3; i++) {
                DefaultMutableTreeNode file = new DefaultMutableTreeNode("File " + i);
                folder.add(file);
            }
            parent.add(folder);
            createFolders(parent, current + 1, folderCount);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(newTree::new);
    }
}
