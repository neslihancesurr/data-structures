package BinaryTree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    // This is a method which operates one TreeNode level, using the data, right and left attributes.
    // It doesn't matter from which node you begin. You don't have to start at the root.
    // Before searching the right or left nodes, make sure the current node has children.
    public TreeNode recursiveSearch(int value) {
        if (data == value) {
            return this;

        } else if (data < value) {
            if (right != null)
                return right.recursiveSearch(value);
            else
                return null;

        } else if (left != null)
            return left.recursiveSearch(value);
        else
            return null;
    }

    public TreeNode iterativeMinSearch(){
        TreeNode tmp = this;

        while (tmp.left != null){
            tmp = tmp.left;
        }

        return tmp;
    }

    public TreeNode iterativeMaxSearch(){
        TreeNode tmp = this;

        while (tmp.right != null){
            tmp = tmp.right;
        }
        return tmp;
    }

    public TreeNode recursiveMinSearch(){

        if (left == null){
            return this;
        } else {
            return left.recursiveMinSearch();
        }
    }

    public TreeNode recursiveMaxSearch(){

        if (right == null){
            return this;
        } else {
            return right.recursiveMaxSearch();
        }
    }

    // recursive preorder. should be called from the root node of a tree.
    public void preorder(){
        System.out.println(data);

        if (left != null){
            left.preorder();
        }
        if (right != null){
            right.preorder();
        }
    }

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }

    public void postorder(){
        if (left != null){
            left.postorder();
        }
        if (right != null){
            right.postorder();
        }
        System.out.println(data);
    }



}

