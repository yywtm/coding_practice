// 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。请返回库存表中数量大于 stock.length / 2 的商品 id。

 

// 示例 1：

// 输入：stock = [6, 1, 3, 1, 1, 1]
// 输出：1
 

// 提示：

// 1 <= stock.length <= 50000
// 给定数组为非空数组，且存在结果数字
/**
 * 记录每一个id的数量，存在map中
 */
class Solution {
    public int inventoryManagement(int[] stock) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< stock.length; i++){
            if(map.containsKey(stock[i])){
                Integer temp = map.get(stock[i])+1;
                map.put(stock[i],temp);
            }else{
                map.put(stock[i],1);
            }
        }
        int target = stock.length/2;
        for(Integer i : map.keySet()){
            if(map.get(i)>target){
                return i;
            }
        }
        return 0;

        
    }
}
/**
 * 投票法
 */
class Solution {
    public int inventoryManagement(int[] stock) {
        int vote = 0;
        int x = 0;
        for(int i =0 ; i< stock.length; i++){
            if(vote == 0){
                x = stock[i];
                vote++;
                continue;
            }else{
                if(x!=stock[i]){
                    vote--;
                }else{
                    vote++;
                }
            }
        }

        // 验证阶段（本题不需要）
        // int count = 0;
        // for(int i = 0 ; i<stock.length;i++){
        //     if(x==stock[i]){
        //         count++;
        //     }

        // }
        // if(count>stock.length/2){
        //     return x
        // }else{
        //     // 没有符合的id
        // }
        return x;

        
    }
}

