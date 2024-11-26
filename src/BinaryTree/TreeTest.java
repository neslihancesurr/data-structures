package BinaryTree;

import java.util.LinkedList;

public class TreeTest {
    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(50);
        BinaryTree tree = new BinaryTree();
        tree.root = rootNode;

        tree.insert(new TreeNode(17));
        tree.insert(new TreeNode(12));
        tree.insert(new TreeNode(23));
        tree.insert(new TreeNode(9));
        tree.insert(new TreeNode(14));
        tree.insert(new TreeNode(19));
        tree.insert(new TreeNode(72));
        tree.insert(new TreeNode(54));
        tree.insert(new TreeNode(67));
        tree.insert(new TreeNode(76));

        LinkedList<Integer> linkedList = new LinkedList<>();

        rootNode.pathList(linkedList);
        int[] myarray = tree.pathList();

        System.out.println(linkedList);
        for (int path: myarray) {
            System.out.println(path);
        }

   /*
        int n1 = tree.nodeCountStack();
        tree.delete(50);
        int n2 = tree.nodeCountStack();

        System.out.println("N1:" + n1);
        System.out.println("N2:" + n2);

        tree.root.inorder();*//*

        TreeNode rootNode = new TreeNode(8);
        BinaryTree tree = new BinaryTree();
        tree.root = rootNode;

        tree.insert(new TreeNode(3));
        tree.insert(new TreeNode(10));
        tree.insert(new TreeNode(1));
        tree.insert(new TreeNode(6));
        tree.insert(new TreeNode(4));
        tree.insert(new TreeNode(7));
        tree.insert(new TreeNode(14));
        tree.insert(new TreeNode(13));

        rootNode.preorder();

        int n1 = tree.nodeCountStack();
        tree.delete(10);
        int n2 = tree.nodeCountQueue();

        System.out.println("N1:" + n1);
        System.out.println("N2:" + n2);*/



    }


}
