package linkedlist;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 设置一个虚拟节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        // 2. 设置快慢指针
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 3. 需要将n+1,为了slow与fast之间距离三个元素单位，
        // 假设要删除n=2，就需要找到他的前一个元素，所以让fast多走一步
        n++;
        // 4. 先让fast指针行前移动3步
        while (n > 0 && fast != null){
            n--;
            fast = fast.next;
        }
        // 5.然后快慢指针一起移动，当fast为null时，就是slow指向目标元素的前一个元素
        while (fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 6. 然后删除元素
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
