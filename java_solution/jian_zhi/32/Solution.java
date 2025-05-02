// 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。

 

// 示例 1：



// 输入：root = [8,17,21,18,null,null,6]
// 输出：[8,17,21,18,6]
 

// 提示：

// 节点总数 <= 1000

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
 * 广度优先遍历
 */
class Solution {
    public int[] decorateRecord(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.remove(0);
            res.add(t.val);
            if(t.left!=null){
                queue.add(t.left);
            }
            if(t.right!=null){
                queue.add(t.right);
            }
        }
        int[] result = new int[res.size()];
        for(int i= 0 ; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
        
    }
}