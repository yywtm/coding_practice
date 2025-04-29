
/**
 * 设备中存有 n 个文件，文件 id 记于数组 document。
 * 若文件 id 相同，则定义该文件存在副本。
 * 请返回任一存在副本的文件 id。
 * 提示：
 * 0 ≤ documents[i] ≤ n-1
 * 2 <= n <= 100000
 */

/**
 * 置换法
 */
public class Solution {
    public int findRepeatDocument(int[] document) {
        int i = 0;
        while(i<document.length){
            if(document[i]==i){
                i++;
                continue;
            }
            if(document[i]==document[document[i]]){
                return document[i];
            }
            int temp = document[i];
            document[i] = document[temp];
            document[temp] = temp;
        }
        return -1;
    }
}
/**
 * HashSet
 */
public class Solution {
    public int findRepeatDocument(int[] document) {
        Set<Integer> set = new HashSet<>();
        int size = 0;
        for(int i = 0; i < document.length; i++){
            set.add(Integer.valueOf(document[i]));
            if(size == set.size()){
                return document[i];
            }
            size = set.size();

        }
        return -1;
    }
}

