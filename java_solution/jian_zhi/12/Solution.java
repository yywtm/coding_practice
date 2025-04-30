// 字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。
// 注意：寻找单词时 必须 按照字母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。

 


// 示例 1：

// 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "ABCCED"
// 输出：true
// 示例 2：

// 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "SEE"
// 输出：true
// 示例 3：

// 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "ABCB"
// 输出：false
 

// 提示：

// m == grid.length
// n = grid[i].length
// 1 <= m, n <= 6
// 1 <= target.length <= 15
// grid 和 target 仅由大小写英文字母组成
/**
 * 回溯+剪枝
 */
class Solution {
    int len;
    public boolean wordPuzzle(char[][] grid, String target) {
        char[] chars = target.toCharArray();
        len = target.length();
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(dsf(grid,chars,i,j,0)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dsf(char[][] grid,char[] target,int i, int j, int key){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]!=target[key]){
            return false;
        }
        if(key==target.length-1){
            return true;
        }
        grid[i][j] = '\0';
        boolean res = dsf(grid,target,i+1,j,key+1)||dsf(grid,target,i-1,j,key+1)||dsf(grid,target,i,j+1,key+1)||dsf(grid,target,i,j-1,key+1);
        grid[i][j] = target[key];
        return res;


    }
}