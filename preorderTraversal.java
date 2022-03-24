/**
 * taken from: https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        printInOrder(root);
        return list;
    }
    
    LinkedList<Integer> list = new LinkedList<>();
    
    void printInOrder(TreeNode node) {
            // check not null
            if (node == null) {
                return;
            }
            
            // print root
            list.add(node.val);
            
            // left subtree
            printInOrder(node.left);
            
            // right subtree
            printInOrder(node.right);
    }
}