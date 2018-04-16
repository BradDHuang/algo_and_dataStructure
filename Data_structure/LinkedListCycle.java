package com.company;

// lc 102. Linked List Cycle

// 这个问题可以用数学归纳法来思考。
// 首先，由于链表是环形，所以相遇的过程可以看作是快指针从后边追赶慢指针的过程。
// 那么做如下思考：
// 1：快指针与慢指针之间差一步。此时继续往后走，慢指针前进一步，快指针前进两步，两者相遇。
// 2：快指针与慢指针之间差两步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差一步，转化为第一种情况。
// 3：快指针与慢指针之间差N 步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差(N+1-2)-> N-1步。

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;

        slow = head;
        fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode a = new ListNode(1);

        a.next = new ListNode(2);
//        ListNode b = a.next;
//        b.next = new ListNode(3);
        ListNode c = a.next;
        c.next = new ListNode(3);
        
        c.next.next = a;
        
        System.out.println(hasCycle(a));

    }
}