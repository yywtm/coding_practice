// m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：

// 每行中，每棵植物的右侧相邻植物不矮于该植物；
// 每列中，每棵植物的下侧相邻植物不矮于该植物。
 

// 请判断 plants 中是否存在目标高度值 target。

 

// 示例 1：

// 输入：plants = [[2,3,6,8],[4,5,8,9],[5,9,10,12]], target = 8

// 输出：true
 

// 示例 2：

// 输入：plants = [[1,3,5],[2,5,7]], target = 4

// 输出：false
 

// 提示：

// 0 <= n <= 1000
// 0 <= m <= 1000
/**
 * 右上角法
 */
class Solution {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        // 如果是空数组直接返回false
        int m = plants.length;
        if(m==0){
            return false;
        }
        int n = plants[0].length;
        // 初始化当前点位于右上角(0,n-1)
        int x = 0;
        int y = n-1;
        // target比当前点大，则往下移动，比当前点小往左移动
        while(x<m && y>=0){
            if(plants[x][y]>target){
                y--;
            }else if(plants[x][y]<target){
                x++;
            }else{
                return true;
            }
        }
        return false;

    }
}