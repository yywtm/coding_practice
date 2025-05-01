// 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。

// 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。

 

// 示例 1：

// 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
// 输出：[1,2,3,4,5,6,7,8,9]
// 示例 2：

// 输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
// 输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 

// 限制：

// 0 <= array.length <= 100
// 0 <= array[i].length <= 100
/**
 * 模拟
 */
class Solution {
    public int[] spiralArray(int[][] array) {
        
        int m = array.length;
        if(m==0){
            return new int[0];
        }
        int n = array[0].length;
        int[] res = new int[m*n];
        int t = 0;
        int l = 0;
        int r = n-1;
        int b = m-1;
        int idx = 0;

        while(true){
            for(int i = l;i<=r;i++){
                res[idx++] = array[t][i]; 
            }
            if(++t>b) break;
            for(int i = t; i<=b;i++){
                res[idx++] = array[i][r];
            }
            if(--r<l) break;
            for(int i = r; i>=l;i--){
                res[idx++] = array[b][i];
            }
            if(--b<t) break;
            for(int i = b; i>=t;i--){
                res[idx++] = array[i][l];
            }
            if(++l>r)break;
        }
        return res;
    }
}