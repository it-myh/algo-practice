package linkedlist;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    /**
     * 双指针法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            // 用于存储下个节点的地址
            ListNode temp = cur.next;
            // 然后在将cur指向pre,这里就是反转链表
            cur.next = pre;
            // 然后先移动pre，在移动cur
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归版
     * @param cur
     * @param pre
     * @return
     */
    public ListNode reverse(ListNode cur, ListNode pre){
        if(cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp, cur);
    }
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }
}
