package linkedlist;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {
    /**
     * 第一种方法：(版本一)先行移动长链表实现同步移动
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 然后while循环分别计算出两个链表的长度
        int lenA = 0, lenB =0;
        while(curA!=null){
            lenA++;
            curA = curA.next;
        }
        while(curB!=null){
            lenB++;
            curB = curB.next;
        }
        //再把指针调回最初的头结点
        curA = headA;
        curB = headB;
        int diffLen;
        if(lenA > lenB){
            diffLen = lenA - lenB;
            while(diffLen>0){
                diffLen--;
                curA = curA.next;
            }
        }else{
            diffLen = lenB - lenA;
            while(diffLen > 0){
                diffLen--;
                curB = curB.next;
            }
        }
        while(curA!=null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * (版本二) 合并链表实现同步移动
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
