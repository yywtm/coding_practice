// 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从左到右的顺序返回每一层彩灯编号，每一层的结果记录于一行。

 

// 示例 1：



// 输入：root = [8,17,21,18,null,null,6]
// 输出：[[8],[17,21],[18,6]]
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
class Solution {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        while(!temp.isEmpty()){
            int curlen = temp.size();
            List<Integer> r = new ArrayList<>();
            for(int i = 0; i<curlen; i++){
                TreeNode t = temp.remove(0);
                r.add(t.val);
                if(t.left!=null){
                    temp.add(t.left);
                }
                if(t.right!=null){
                    temp.add(t.right);
                }
            }
            res.add(r);
        }
        return res;
    }
}