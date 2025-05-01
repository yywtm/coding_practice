// 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
// 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。

 

// 示例 1：

 



 

// 输入：tree1 = [1,7,5], tree2 = [6,1]
// 输出：false
// 解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
// 示例 2：



// 输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
// 输出：true
// 解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。


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
    
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||A==null){
            return false;
        }
        /**
         * preOrder(A,B)A,B为相同根节点时
         * isSubStructure(A.left,B)，B在A的左子树上
         * isSubStructure(A.right,B)B在A的右子树上
         */
        return preOrder(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        
    }
    public boolean preOrder(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null||A.val!=B.val){
            return false;
        }
        return preOrder(A.left,B.left)&&preOrder(A.right,B.right);
    }
}