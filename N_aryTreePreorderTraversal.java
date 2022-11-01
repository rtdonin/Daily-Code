/**
 * Taken from: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 */

/*

// Definition for a Node. (provided by leetcode)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        // Left order traversal.
        // Create Array.
        // Add current child
        // If the next value is null (comes first in the method but the third step)
        // go to each child
        traverse(root);
    
        return list;
    }

    List<Integer> list = new ArrayList<>();

    void traverse(Node node) {
        // check if null
        if (node == null){
            return;
        }

        // add value
        list.add(node.val);

        // subtree
        Iterator<Node> iterator = node.children.listIterator();
        while(iterator.hasNext()){
            traverse(iterator.next());
        }
    }
    
}