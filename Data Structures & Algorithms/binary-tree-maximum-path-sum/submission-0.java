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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        int leftgain=Math.max(0,dfs(root.left));
        int rightgain=Math.max(0,dfs(root.right));
        int val=root.val+leftgain+rightgain;
        max=Math.max(val,max);
        return root.val+Math.max(leftgain,rightgain);
    }
}
