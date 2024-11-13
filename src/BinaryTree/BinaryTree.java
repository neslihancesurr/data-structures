package BinaryTree;
import Basics.Node;
import Queue.QueueLinked;
import Stack.StackLinked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }


    public TreeNode iterativeSearch(int value) {
        TreeNode tmp = root;

        while (tmp != null) {
            if (tmp.data == value) {
                return tmp;
            } else if (tmp.data < value) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        return null;
    }

    public void insert(TreeNode newNode) {
        TreeNode parent = null;
        TreeNode tmp = root;


        while (tmp != null) {
            parent = tmp;

            if (newNode.data > tmp.data) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }

        if (parent == null) {
            root = newNode;
        } else if (newNode.data > parent.data) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }

    public void delete(int value) {
        TreeNode parent = null;
        TreeNode current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.data != value) {
            parent = current;
            if (value < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the node was not found, return (value not in the tree)
        if (current == null) {
            System.out.println("Value not found in the tree.");
            return;
        }

        // Case 1: Node to be deleted has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case 2: Node to be deleted has only one child
        else if (current.left == null || current.right == null) {
            // get the child of the deleted node
            TreeNode child;
            if (current.left != null) {
                child = current.left;
            } else {
                child = current.right;
            }

            // if the deleted node is the root, make the only child the root
            // else find on which side and delete the child
            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // Case 3: Node to be deleted has two children
        else {
            TreeNode successorParent = current;
            TreeNode successor = current.right;

            // Find the in-order successor (smallest node in the right subtree)
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace current node's data with successor's data
            current.data = successor.data;

            // Delete the successor node
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
    }

    public int nodeCountStack(){
        if (root == null){
            return 0;
        }

        Stack<TreeNode> externalStack = new Stack<>();
        externalStack.push(root);

        int count = 0;
        while (!externalStack.isEmpty()){
            TreeNode node = externalStack.pop();
            count++;

            if (node.left != null){
                externalStack.push(node.left);
            }
            if (node.right != null){
                externalStack.push(node.right);
            }
        }
        return count;
    }


    public int nodeCountQueue(){
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count;
    }



}
