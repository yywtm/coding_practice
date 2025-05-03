// 某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。

// 要求实现时间复杂度为 O(n) 的算法。

 

// 示例 1：

// 输入：sales = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：[4,-1,2,1] 此连续四天的销售总额最高，为 6。
// 示例 2：

// 输入：sales = [5,4,-1,7,8]
// 输出：23
// 解释：[5,4,-1,7,8] 此连续五天的销售总额最高，为 23。 
 

// 提示：

// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
/**
 * 动态规划，dp为当前日子能获取得到的连续天数最大利润
 */
class Solution {
    public int maxSales(int[] sales) {
        int[] dp = new int[sales.length];
        dp[0] = sales[0];
        int max = dp[0];
        for(int i = 1 ; i< sales.length;i++){
            dp[i] = Math.max(dp[i-1]+sales[i],sales[i]);
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
        
    }
}