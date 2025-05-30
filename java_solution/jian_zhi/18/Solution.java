// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

// 返回删除后的链表的头节点。

// 示例 1：

// 输入：head = [4,5,1,9], val = 5
// 输出：[4,1,9]
// 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 示例 2：

// 输入：head = [4,5,1,9], val = 1
// 输出：[4,5,9]
// 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 

// 说明：

// 题目保证链表中节点的值互不相同
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点

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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tail = head.next;
        ListNode pre = head;
        if(head.val==val){
            if(head.next!=null){
                return head.next;
            }
            return null;
        }
        while(tail!= null){
            
            if(tail.val == val){
                if(tail.next!=null){
                    pre.next = tail.next;
                    return head;
                }
                pre.next = null;
            }
            pre = tail;
            tail = tail.next;
        }
        return head;
    }
}