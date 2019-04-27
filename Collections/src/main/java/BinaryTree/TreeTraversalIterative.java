package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.Stack;

public class TreeTraversalIterative {

    static TreeNode constructTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);

        root.right = new TreeNode(11);
        root.right.right = new TreeNode(17);

        return root;
    }


    static void IterativeMethodInOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        TreeNode temp;

        stack.push(current);
        current = root.left;

        while (!stack.empty()) {
            if (current != null) {
                stack.push(current);
            //    System.out.println("pushing " + current.val);
                current = current.left;
            }
            else {

                temp = stack.pop();
                System.out.println("Popped " + temp.val);
                current = temp.right;

                if (current != null) {
                    stack.push(current);
                 //   System.out.println("pushed " + current.val);
                    current = current.left;

                }


            }
        }
    }

//* Does not work */
    static void IterativeMethodPostOrder(TreeNode root) {

        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode temp = null;

        while ( current != null || !stack.empty()) {

            if ( current != null) {
                System.out.println("Push "+current.val);
                stack.push(current);
                current = current.left;
            }else {
                if (current == null) {
                    prev = stack.pop();
                    System.out.println(prev.val+ " ");
                    temp = stack.peek();

                    if (temp != null && temp.right != null) {
                       //z` stack.push(temp.right);
                        current = temp.right;
                    }
                }

            }

         }
    }




    public static void main(String[] args) {

        TreeNode root = constructTree();
        root.inOrder(root);
        System.out.println();
        IterativeMethodInOrder(root);
        root.postOrder(root);
        System.out.println("\nPostOrder");
        IterativeMethodPostOrder(root);
    }
}
