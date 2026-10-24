/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (subroot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (sameTree(root,subroot)) {
            return true;
        }

        return isSubtree(root.left,subroot) || isSubtree(root.right, subroot);
        

    }

    public boolean sameTree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if ((root == null && subroot != null) || (root != null && subroot == null)){
            return false;
        }

        if (root.val == subroot.val && sameTree(root.left,subroot.left) && sameTree(root.right,subroot.right)) {
            return true;
        }
        return false;
    }
}
