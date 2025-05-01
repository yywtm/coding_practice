// 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。

 

// 示例 1：

// 输入：head = [2,4,7,8], cnt = 1
// 输出：8
 

// 提示：

// 1 <= head.length <= 100
// 0 <= head[i] <= 100
// 1 <= cnt <= head.length

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * 快慢双指针，关键点是慢指针行动的时机
 */
class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast= head;
        ListNode slow = head;
        int i = 0;
        while(fast != null){
            fast = fast.next;
            i++;
            if(i>cnt){
                slow = slow.next;
            }
        }
        return slow;
    }
}