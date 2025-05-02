// 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：

// 第一层按照从左到右的顺序记录
// 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
 

// 示例 1：



// 输入：root = [8,17,21,18,null,null,6]
// 输出：[[8],[21,17],[18,6]]
 

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
 * 上下层顺序相反那就插入的方向相反
 */
class Solution {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        boolean isReverse = false;
        while(!temp.isEmpty()){
            int curlen = temp.size();
            List<Integer> r = new ArrayList<>();
            if(!isReverse){
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

            }else{
                for(int i = 0; i<curlen; i++){
                    TreeNode t = temp.remove(temp.size()-1);
                    r.add(t.val);
                    if(t.right!=null){
                        temp.add(0,t.right);
                    }
                    if(t.left!=null){
                        temp.add(0,t.left);
                    }
                }
            }
            
            res.add(r);
            isReverse = !isReverse;
        }
        return res;
    }
}