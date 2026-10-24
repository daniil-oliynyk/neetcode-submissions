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
    public int goodNodes(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,-101));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode,Integer> temp = q.poll();
                TreeNode node = temp.getKey();
                Integer maxVal = temp.getValue();
                if (node.val >= maxVal) {
                   res++;
                   maxVal = node.val;
                }
                if (node.left != null) {
                    q.add(new Pair<>(node.left,maxVal));
                }  
                if (node.right != null) {
                    q.add(new Pair<>(node.right,maxVal));
                }
            }
        }



        return res;
    }
}
