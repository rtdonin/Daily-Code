/**
 * taken from: https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        printInOrder(root);
        return list;
    }
    
    LinkedList<Integer> list = new LinkedList<>();
    
    void printInOrder(TreeNode node) {
        // check if null
        if (node == null) {
            return;
        }
        
        // left subtree
        printInOrder(node.left);
        
        // root
        list.add(node.val);
        
        // right subtree
        printInOrder(node.right);
        
    }
}