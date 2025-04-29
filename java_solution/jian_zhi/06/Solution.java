// 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。

 

// 示例 1：

// 输入：head = [3,6,4,1]

// 输出：[1,4,6,3]
 

// 提示：

// 0 <= 链表长度 <= 10000

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
 * 递归 (巧妙的初始化res，降低时间复杂度)
 */
class Solution {
    int[] res;
    int len = 0;
    int index = 0;
    public int[] reverseBookList(ListNode head) {
        dsf(head);
        return res;
    }
    public void dsf(ListNode head){
        if(head == null){
            //初始化结果的容量
            res = new int[len];
            return;
        }
        len++;
        dsf(head.next);
        res[index] = head.val;
        index++;
    }
}