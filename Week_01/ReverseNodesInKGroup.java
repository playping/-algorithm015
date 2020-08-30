package leetcode.editor.cn;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 703 👎 0

import leetcode.common.ListNode;

public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode a = new ListNode();
        a.val = 1;
        ListNode b = new ListNode();
        b.val = 2;
        a.next = b;
//        ListNode c = new ListNode();
//        c.val = 3;
//        b.next = c;
//        ListNode d = new ListNode();
//        d.val = 4;
//        c.next = d;
//        ListNode e = new ListNode();
//        e.val = 5;
//        d.next = e;
        ListNode f = solution.reverseKGroup(a,2);
        while (f != null) {
            System.out.println(f.val);
            f = f.next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode zero = new ListNode();
        ListNode outPre = zero;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempCurr = curr;
            int i  = 0;//
            int j = k + 2;
            while (tempCurr != null) {
                tempCurr = tempCurr.next;
                i++;
                if (i == k) {
                    j = 1;
                    break;
                }
            }
            if (i == k) {
                ListNode pre = null;
                while (j <= k && curr != null) {
                    ListNode temp = curr.next;
                    curr.next = pre;
                    pre = curr;
                    curr = temp;
                    j++;
                }
                while ( pre != null) {
                    outPre.next = pre;
                    outPre = outPre.next;
                    pre = pre.next;
                }
            }
            else {
                outPre.next = curr;
                break;
            }
        }
        return zero.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}