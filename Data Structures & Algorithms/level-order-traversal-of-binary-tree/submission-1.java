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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        q.add(root);
        while(!q.isEmpty()) {

            List<Integer> lvl = new ArrayList<>();
            
            for(int i = q.size(); i>0;i--){
                TreeNode temp = q.poll();
                if(temp != null){
                    lvl.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
                }        
           
            }
            if(lvl.size() > 0){
                 res.add(lvl);
            }
           

        }
        return res;
    }
}
