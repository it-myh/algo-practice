package linkedlist;
/**
 * 两两交换链表中的节点
 */
public class SwapLinkedElement {
    public ListNode swapPairs(ListNode head) {
        // 1.创建一个虚拟的头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 2.遍历我们的链表然后两两互换
        // 需要一个cur指针来遍历
        ListNode cur = dummyHead;
        // 只有两个元素都不为null时，才能进行交换
        while(cur.next != null && cur.next.next != null){
            // 要交换元素中的第一个元素
            ListNode temp1 = cur.next;
            // 这是cur第一个元素换位置后指向后面的第三个元素
            ListNode temp2 = cur.next.next.next;
            // 让虚拟头结点指向要交换的第二个元素
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            // 交换后cur指针移动
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
