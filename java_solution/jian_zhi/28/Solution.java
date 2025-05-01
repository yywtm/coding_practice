// 请设计一个函数判断一棵二叉树是否 轴对称 。

 

// 示例 1：



// 输入：root = [6,7,7,8,9,9,8]
// 输出：true
// 解释：从图中可看出树是轴对称的。
// 示例 2：



// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
// 解释：从图中可看出最后一层的节点不对称。
 

// 提示：

// 0 <= 节点个数 <= 1000

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
 * 对称：L.val = R.val;L.L.val = =R.R.val;L.R.val = R.l.val;
 */
class Solution {
    public boolean checkSymmetricTree(TreeNode root) {
        if(root==null){
            return true;
        }
        return preOrder(root.left,root.right);
    }
    public boolean preOrder(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return preOrder(left.left,right.right)&&preOrder(left.right,right.left);
    }
}