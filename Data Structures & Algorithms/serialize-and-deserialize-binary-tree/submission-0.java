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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        build(root,sb);
        return sb.toString();
    }

    private void build(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        build(root.left,sb);
        build(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str=data.split(",");
        Queue<String> q=new LinkedList<>();

        for(String s:str)
        {
            q.offer(s);
        }

        return construct(q);
    }

    private TreeNode construct(Queue<String> q)
    {
        String val=q.poll();

        if(val.equals("#"))
            return null;
        
        TreeNode node=new TreeNode(Integer.parseInt(val));

        node.left=construct(q);
        node.right=construct(q);

        return node;
    }
}
