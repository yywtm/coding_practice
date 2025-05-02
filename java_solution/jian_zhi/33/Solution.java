// 请实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。

 

// 示例 1：



// 输入: postorder = [4,9,6,5,8]
// 输出: false 
// 解释：从上图可以看出这不是一颗二叉搜索树
// 示例 2：



// 输入: postorder = [4,6,5,9,8]
// 输出: true 
// 解释：可构建的二叉搜索树如上图
 

// 提示：

// 数组长度 <= 1000
// postorder 中无重复数字

/**
 * 递归，最右边是根节点root，从左往右第一个大于root的，其左边不包括自身为root的左子树，其右边包括自身除去root节点为root的右子树
 */
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        if(postorder.length==0){
            return true;
        }
        return recur(0,postorder.length-1,postorder);
        
    }
    public boolean recur(int left, int right, int[] postorder){
        if(left >= right){
            return true;
        }
        int mid = left;
        int root = postorder[right];
        while(postorder[mid]<root){
            mid++;
        }
        int t = mid;
        while(t<right){
            if(postorder[t]<root){
                return false;
            }
            t++;
        }
        return recur(left,mid-1,postorder)&&recur(mid,right-1,postorder);
    }
}