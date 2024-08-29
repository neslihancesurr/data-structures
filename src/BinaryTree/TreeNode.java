package BinaryTree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public TreeNode recursiveSearch(int value) {
        // This is a method which operates one TreeNode level, using the data, right and left attributes.
        // It doesn't matter from which node you begin. You don't have to start at the root.
        // Before searching the right or left nodes, make sure the current node has children.

        if (data == value) {
            return this;
        } else if (data < value) {
            if (right != null)
                return right.recursiveSearch(value);
              else
                return null;
        } else
            if (left != null)
                return left.recursiveSearch(value);
            else
                return null;

    }
}

