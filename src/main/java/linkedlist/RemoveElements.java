package linkedlist;
public class RemoveElements {
    /**
     * 1.不带虚节点的情况1
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        // 用一个指针指向头节点
        ListNode node = head;
        // 在判断依次head是否为null,因为可能删除的元素正好是头节点，然后就没有元素了
        while (node!= null && node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else{
                // node代替下一个元素，类似下一个元素为头结点
                node = node.next;
            }
        }
        return head;
    }
    /**
     * 1.不带虚节点的情况2
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 2. 带头结点的方法
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        // 头节点不等于null，那就创建一个许你的节点，val不需要存值，只需要指向头结点即可
        ListNode pre = new ListNode();
        pre.next = head;
        // 设置一个指针
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
    // 数组转链表
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }

    // 打印链表，方便看结果
    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,2};
        ListNode list = createList(arr);
        System.out.println("没有删除之前");
        printList(list);
        int num = 2;
        ListNode listNode = removeElements2(list, num);
        System.out.println("删除" + num + "后的列表");
        printList(listNode);

    }
}
