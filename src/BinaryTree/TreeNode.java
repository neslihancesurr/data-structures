package BinaryTree;

import Basics.Node;

import java.util.LinkedList;

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

    public static boolean isIdentical(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null){
            return true;
        }

        if (node1 == null || node2 == null){
            return false;
        }

        if (node1.data != node2.data){
            return false;
        }

        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.left);
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

    public void pathList(LinkedList<Integer> list){
        list.add(this.data);

        if (this.data % 2 == 0){
            if (right != null){
                right.pathList(list);
            }
        } else {
            if (left != null){
                left.pathList(list);
            }
        }
    }
}

