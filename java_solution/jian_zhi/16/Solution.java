// 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

 

// 示例 1：

// 输入：x = 2.00000, n = 10
// 输出：1024.00000
// 示例 2：

// 输入：x = 2.10000, n = 3
// 输出：9.26100
// 示例 3：

// 输入：x = 2.00000, n = -2
// 输出：0.25000
// 解释：2-2 = 1/22 = 1/4 = 0.25
 

// 提示：

// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104

/**
 * 二分法，直接遍历可能会超时，采用二分法把x的n方转换为x的2次方的n/2次方，这里需要处理n/2能否整除
 */
class Solution {
    public double myPow(double x, int n) {
        
        if(x==0.0f){
            return 0.0d;
        }
        if(n==0){
            return 1.0d;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return dsf(x,n);
    }
    public double dsf(double x,int n){
        if(n/2==0){
            return x;
        }
        int t = n%2;
        double ex;
        if(t==0){
            ex = 1.0d;
        }else{
            ex = x;
        }
        return dsf(x*x,n/2)*ex;
    }
}