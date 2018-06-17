
// lc 456. reference

/**
 * Definition of Node:
 * class Node {
 *     public int val;
 *     public Node(int val) {
 *         this.val = val;
 *     }
 * }
 */
public class ReferenceManager {
    public Node node;

    public void copyValue(Node obj) {
        // copy value from obj to node
        
        // node.value = obj.value;
        // node = new Node(obj.val);
        
        // corner cases:
        if (obj == null) return;
        if (node == null) {
            node = new Node(obj.val);
        }
        
        node.val = obj.val;
        
    }

    public void copyReference(Node obj) {
        // copy reference from obj to node
        node = obj;
    }
}


