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

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {

                    tempList.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
            
                }
            }
            if (tempList.size() != 0) {
                res.add(tempList);
            }
            
        }
        return res;


    }
}
