// 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。

 

// 示例 1：

// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
 

// 示例 2：

// 输入：head = [1,2]
// 输出：[2,1]
 

// 示例 3：

// 输入：head = []
// 输出：[]
 

// 提示：

// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000

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
class Solution {
    public ListNode trainningPlan(ListNode head) {
        ListNode start = null;
        while(head!=null){
            ListNode temp = new ListNode(head.val);
            head = head.next;
            if(start == null){
                start = new ListNode(temp.val);
                start.next = null;
                continue;
            }else{
                temp.next = start;
            }
            start = temp;
        }
        return start;
    }
}