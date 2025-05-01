// 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。

 

// 示例 1：

// 输入：actions = [1,2,3,4,5]
// 输出：[1,3,5,2,4] 
// 解释：为正确答案之一
 

// 提示：

// 0 <= actions.length <= 50000
// 0 <= actions[i] <= 10000
/**
 * 线性遍历，重新放置数字
 */
class Solution {
    public int[] trainingPlan(int[] actions) {
        int left = 0;
        int right = actions.length-1;
        int[] res = new int[actions.length];
        for(int i = 0; i< actions.length;i++){
            if(actions[i]%2==0){
                res[right] = actions[i];
                right--;
            }else{
                res[left] = actions[i];
                left++;
            }
        }
        return res;
    }
}

/**
 * 双指针 ,注意及时判断左指针和右指针的位置
 */

class Solution {
    public int[] trainingPlan(int[] actions) {
        if(actions.length==0){
            return actions;
        }
        int left = 0;
        int right = actions.length-1;
        while(left<right){
            while(actions[left]%2==1&&left<right){
                left++;
            }
            while(actions[right]%2==0&&left<right){
                right--;
            }
            if(left>=right){
                break;
            }
            int temp = actions[left];
            actions[left] = actions[right];
            actions[right] = temp;
        }
        return actions;
    }
}