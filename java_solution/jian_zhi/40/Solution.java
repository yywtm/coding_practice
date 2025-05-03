// 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。

 

// 示例 1：

// 输入：stock = [2,5,7,4], cnt = 1
// 输出：[2]
// 示例 2：

// 输入：stock = [0,2,3,6], cnt = 2
// 输出：[0,2] 或 [2,0]
 

// 提示：

// 0 <= cnt <= stock.length <= 10000

// 	0 <= stock[i] <= 10000
/**
 * 快速选择，在快速排序的时候，当基准值的下标等于最小个数-1的时候，此时基准值及其左边的值为前n小的值
 */
class Solution {
    int len;
    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] res = new int[cnt];
        len = cnt;
        quick(res,0,stock.length-1,stock);
        return res;
        
    }
    public void quick(int[] res, int l, int r, int[] stock){
        if(l>r){
            return;
        }
        int i = l;
        int j = r;
        int base = stock[l];
        while(i<j){
            while(i<j&&stock[j]>=base){
                j--;
            }
            swap(stock,i,j);
            if(i>=j){
                break;
            }
            i++;
            while(i<j&&stock[i]<=base){
                i++;
            }
            swap(stock,i,j);
            j--;
        }
        if(i == len-1){
            for(int k = 0; k<= i; k++){
                res[k] = stock[k];
            }
            return;
        }
        quick(res,l,i-1,stock);
        quick(res,i+1,r,stock);
    }
    public void swap(int[] stock, int i , int j){
        int temp = stock[i];
        stock[i] = stock[j];
        stock[j] = temp;
    }
}


