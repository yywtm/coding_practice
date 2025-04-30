// LCR 131. 砍竹子 I
// 中等
// 相关标签
// 相关企业
// 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。

 

// 示例 1：

// 输入: bamboo_len = 12
// 输出: 81
// 提示：
// 2 <= bamboo_len <= 58

class Solution {
    public int cuttingBamboo(int bamboo_len) {
        if(bamboo_len<=1){
            return bamboo_len;
        }
        int max = 0;
        for(int i = 2; i<bamboo_len; i++){
            int temp = calculate(i,bamboo_len);
            if(temp>max){
                max = temp;
            }else{
                break;
            }
        }
        return max;
    }
    public int calculate(int i, int len){
        int n = len%i;
        // 这里必须分段，所以余1的情况需要前面有至少2段才能把剩下1加入前一段里面
        if(n==1 && len/i>1){
            return (int)Math.pow(i,(len/i-1))*(n+i);
        }
        if(n==0){
            return (int)Math.pow(i,(len/i));
        }
        return (int)Math.pow(i,(len/i))*n;
    }
}