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
    public int kthSmallest(TreeNode root, int k) {
        
        int[] tmp = new int[2];
        tmp[1] = k;
        dfs(root, tmp);
        return tmp[0];


    }

    public void dfs(TreeNode node, int[] tmp){
        if (node == null) {
            return;
        } 

        dfs(node.left,tmp);
        tmp[1] -= 1;
        if(tmp[1] == 0) {
            tmp[0] = node.val;
            return;
        }
        dfs(node.right,tmp);

    }
}
