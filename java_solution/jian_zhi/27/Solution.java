// 给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。

 

// 示例 1：



// 输入：root = [5,7,9,8,3,2,4]
// 输出：[5,9,7,4,2,3,8]
 

// 提示：

// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100

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
/**
 * 递归
 */
class Solution {
    public TreeNode flipTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = flipTree(root.right);
        root.right = flipTree(temp);
        return root;
    }
}