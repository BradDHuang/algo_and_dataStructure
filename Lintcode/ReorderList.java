package com.company;

// lc 99. Reorder List

// 在这里返回值类型与LC 不同：ListNode 而不是void.

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static ListNode reorderList(ListNode head) {
        // write your code here

        // 思路eg:
        // 1->2->3->4->null
        // 拆成1->2; 3->4->null
        // reverse第二块得到4->3->null
        // 再merge：1->4->2->3->null.

        if (head == null || head.next == null) {
             return head;
//            return;
        }

        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);

        mid.next = null;

//        merge(head, tail);
        return merge(head, tail);
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private static ListNode merge(ListNode head, ListNode tail) {
        ListNode d = new ListNode(0);

        ListNode dummy = d;

        int index = 0;

        while (head != null && tail != null) {
            if (index % 2 == 0) {
                dummy.next = head;
                head = head.next;
            } else {
                dummy.next = tail;
                tail = tail.next;
            }
            dummy = dummy.next;
            index++;
        }

        if (head != null) {
            dummy.next = head;
        } else {
            dummy.next = tail;
        }

        return d.next;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(1);

        a.next = new ListNode(2);
//        ListNode b = a.next;
//        b.next = new ListNode(3);
        ListNode c = a.next;
        c.next = new ListNode(3);
        c.next.next = new ListNode(4);

        ListNode res = reorderList(a);

        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);

    }
}