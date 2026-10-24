package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    // 无参构造
    ListNode() {}
    // 只给值
    ListNode(int val) {
        this.val = val;
    }
    // 值 + 下一个节点
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
