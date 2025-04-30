// 实现一个十进制数字报数程序，请按照数字从小到大的顺序返回一个整数数列，该数列从数字 1 开始，到最大的正整数 cnt 位数字结束。

 

// 示例 1：

// 输入：cnt = 2
// 输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99]
/**
 * 非大数方案
 */
class Solution {
    public int[] countNumbers(int cnt) {
        int max = 1;;
        for(int i = 0;i<cnt;i++){
            max*=10;
        }
        max-=1;
        int[] res = new int[max];
        for(int i = 0; i<max;i++){
            res[i] = i+1;
        }
        return res;
    }

}

/**
 * 大数方案：全排列（回溯，深度优先遍历）,不需要考虑使用过数字的情况,注意这里需要大于0
 */
class Solution {
    char[] input = {'0','1','2','3','4','5','6','7','8','9'};
    int len;
    public int[] countNumbers(int cnt) {
        len = cnt;
        StringBuilder sb = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        dsf(res,0,sb);
        int[] result = new int[res.size()];
        int i = 0;
        for(Integer num: res){
            result[i] = num;
            i++;

        }
        return result;

    }
    public void dsf(List<Integer> res, int depth,StringBuilder sb){
        if(depth==len){
            Integer num = Integer.valueOf(sb.toString());
            if(num>0){
                res.add(num);
            }
            return;
        }
        for(int i = 0; i<10;i++){
            char t = input[i];
            sb.append(t);
            dsf(res,depth+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }


}

