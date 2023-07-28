import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newTree extends JFrame {
    // The tree model is the data object that holds the tree structure., JFrame is the top-level container for the tree.
/*JFrame 是 Java Swing 组件库中的一个类，用于创建一个顶级窗口，这个窗口有标题和边框，可以最小化和关闭。在 Java GUI（图形用户界面）编程中，通常我们会创建一个继承自 JFrame 的类来创建一个窗口。

在你的代码中，public class newTree extends JFrame 表示创建了一个新的类（类名为 newTree），这个类是 JFrame 的子类。这意味着 newTree 类拥有 JFrame 的所有属性和方法，因此它可以被视为一个窗口。你可以在这个 newTree 类中添加组件（例如按钮、文本框等），设置布局，响应事件等等，来构建你的 GUI 程序。

总的来说，JFrame 是创建 Java 图形用户界面的基础，任何你想在窗口中显示的元素都应该被添加到 JFrame 中。*/
    private final DefaultTreeModel treeModel; // The tree model is the data object that holds the tree structure.

    public newTree() {
        setTitle("New Tree");
        setSize(2500, 2500); // set the size of the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        String response = JOptionPane.showInputDialog("Enter the number of folders:");
        int folderCount = -1;
        while (folderCount < 0) {
            try {
                String response = JOptionPane.showInputDialog("Enter non-negative number of folders:");
                if (Integer.parseInt(response) > 99) {
                    folderCount = 99; // limit folder Max_size to 99
                } else {
                    folderCount = Integer.parseInt(response); // valid input
                }
            /*
folderCount = Math.min(Integer.parseInt(response), 99);
          the Math.min() function to assign the smaller of the parsed integer and 99 to folderCount.
          This is a more concise way to achieve the same result.
          * /
*/

            } catch (NumberFormatException e) {
                //avoid special character input
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }



        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        createFolders(root, 1, folderCount);

        // Create the tree model and assign it to the JTree
        treeModel = new DefaultTreeModel(root); // The tree model is the data object that holds the tree structure.
        JTree tree = new JTree(treeModel); // The JTree is the visual representation of the tree model.
        tree.setEditable(true); // Allow the user to edit the tree nodes
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); // Allow only one node to be selected at a time
        tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer())); // Use the default cell editor and renderer

        // Create the "Delete" button and its action listener
        JButton deleteButton = new JButton("Delete this Folder"); // Create the "Delete" button
        deleteButton.addActionListener(e -> {
            // Get the current selection path
            TreePath currentSelection = tree.getSelectionPath(); // Get the current selection path
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
        JPanel panel = new JPanel(); // Create a panel to hold the tree and the button
        panel.setLayout(new BorderLayout()); // Use a border layout
        panel.add(new JScrollPane(tree), BorderLayout.CENTER); // Add the tree to the center of the panel
        panel.add(deleteButton, BorderLayout.SOUTH); // Add the button to the bottom of the panel

        add(panel); // Add the panel to the JFrame
        setVisible(true); // Make the JFrame visible
    }

    private void createFolders(DefaultMutableTreeNode parent, int current, int folderCount) {
        if (current <= folderCount) {
            DefaultMutableTreeNode folder = new DefaultMutableTreeNode("Folder " + current);
            for (int i = 1; i <= 2; i++) {
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
