package linkedlist;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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
}
