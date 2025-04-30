// 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。原库存表按商品 id 升序排列。现因突发情况需要进行商品紧急调拨，管理员将这批商品 id 提前依次整理至库存表最后。请你找到并返回库存表中编号的 最小的元素 以便及时记录本次调拨。

 

// 示例 1：

// 输入：stock = [4,5,8,3,4]
// 输出：3
// 示例 2：

// 输入：stock = [5,7,9,1,2]
// 输出：1
 

// 提示：

// 1 <= stock.length <= 5000
// -5000 <= stock[i] <= 5000
/**
 * 遍历最小值
 */
class Solution {
    public int inventoryManagement(int[] stock) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< stock.length;i++){
            min = Math.min(stock[i],min);
        }
        return min;
    }
}
/**
 * 二分法
 * 二分目的是判断 m 在哪个排序数组中，从而缩小区间。而在 stock[m]>stock[i]情况下，无法判断 m 在哪个排序数组中。本质上是由于 j 初始值肯定在右排序数组中； i 初始值无法确定在哪个排序数组中。
 */

class Solution {
    public int inventoryManagement(int[] stock) {
        int i = 0;
        int j = stock.length-1;
        while(i<j){
            int m = (i+j)/2;
            if(stock[m]>stock[j]){
                i = m+1;
            }else if(stock[m]<stock[j]){
                j = m;
            }else{
                j--;
            }
        }
        return stock[i];
    }
}