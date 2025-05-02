// 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

// 叶子节点 是指没有子节点的节点。

 

// 示例 1：



// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// 输出：[[5,4,11,2],[5,8,4,5]]
// 示例 2：



// 输入：root = [1,2,3], targetSum = 5
// 输出：[]
// 示例 3：

// 输入：root = [1,2], targetSum = 0
// 输出：[]
 

// 提示：

// 树中节点总数在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

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
 * 回溯
 */
class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<>();
        }
        int sum  = 0;
        List<Integer> temp = new ArrayList<>();
        res = new ArrayList<>();
        recur(sum,root,target,temp);
        return res;
    }

    public void recur(int sum, TreeNode tree,int target,List<Integer> temp){
        sum+=tree.val;
        temp.add(tree.val);
        if(tree.left==null&&tree.right==null&&sum != target){
            temp.remove(temp.size()-1);
            sum -= tree.val;
            return;
        }else if(sum == target && tree.left==null&&tree.right==null){
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            sum -= tree.val;
            return;
        }
        
        if(tree.left!=null){
            recur(sum,tree.left,target,temp);
        }
        if(tree.right!=null){
            recur(sum,tree.right,target,temp);
        }
        temp.remove(temp.size()-1);
        sum -= tree.val;
    }
}