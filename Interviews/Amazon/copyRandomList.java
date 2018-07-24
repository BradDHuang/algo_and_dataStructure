
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        // HashMap
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        // dummy node
        RandomListNode dummy = new RandomListNode(0);
        
        RandomListNode pre = dummy;
        RandomListNode newNode;
        
        // 在复制的时候要考虑到这个结点是否之前已经被处理过了
        //（因为有.random）
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            // deep copy
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode; // 结合前面的pre.next = newNode;
            // map.get(oldNode1).next = map.get(oldNode1.next)，
            //操作完就是newNode1.next = newNode2
            head = head.next;
        }

        return dummy.next;
    }
}






