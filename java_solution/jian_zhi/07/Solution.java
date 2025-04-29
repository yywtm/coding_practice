// 某二叉树的先序遍历结果记录于整数数组 preorder，它的中序遍历结果记录于整数数组 inorder。请根据 preorder 和 inorder 的提示构造出这棵二叉树并返回其根节点。

 

// 注意：preorder 和 inorder 中均不含重复数字。

 

// 示例 1：



// 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

// 输出: [3,9,20,null,null,15,7]
 

// 示例 2:

// 输入: preorder = [-1], inorder = [-1]

// 输出: [-1]
 

// 提示:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
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
// 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
// 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。

/**
 * 分治法
 * 关键点：左右边界即左右边界相等为最后的子叶；左右子树根节点计算
 */
class Solution {
    Map<Integer,Integer> inorderMap = new HashMap();
    
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1,preorder);
    }

    public TreeNode recur(int pre_root_idx,int in_left,int in_right,int[] preorder){
        if(in_left>in_right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_root_idx]);
        int idx = inorderMap.get(root.val);
        // 左子树的根节点是根节点+1(pre_root_idx+1)
        root.left = recur(pre_root_idx+1,in_left,idx-1,preorder);
        // 右子树在前序遍历中的位置为左子树的长度(idx-in_left)+根节点下标+1(表示往右移动一位到右子树根节点)
        root.right = recur(idx-in_left+pre_root_idx+1,idx+1,in_right,preorder);
        return root;
    }

}