package BinaryTree;


public class TreeNode {
    int val;
    TreeNode left,right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
    }

  public  void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print( " " + root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }

}


