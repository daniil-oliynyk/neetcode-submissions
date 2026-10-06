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
    HashMap<Integer,List<Integer>> hm = new HashMap<>();
    int mincol = 0;
    int maxcol = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        bfs(root);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = mincol; i <= maxcol; i++) {
            res.add(hm.get(i));
        }
        return res;
    }

    public void bfs(TreeNode node) {
        
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(node, 0));

        while(!queue.isEmpty()) {

            int qlen = queue.size();

            for(int i = 0; i < qlen; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode n = p.getKey();
                int col = p.getValue();

                if (hm.containsKey(col)) {
                    List<Integer> temp = hm.get(col);
                    temp.add(n.val);
                    hm.put(col, temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(n.val);
                    hm.put(col, temp);
                }
                mincol = Math.min(mincol, col);
                maxcol = Math.max(maxcol, col);
                if (n.left != null) {
                    queue.add(new Pair<>(n.left, col-1));
                }
                if (n.right != null){
                    queue.add(new Pair<>(n.right, col+1));
                }
            }
        }
    }
}