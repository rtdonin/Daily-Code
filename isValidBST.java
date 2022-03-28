/**
 * Taken From : https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
    
        return testTree(root, min, max);
    }

    boolean testTree(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }
        
        if(node.val <= min || node.val >= max ){
             return false;
        } else {
            return testTree(node.left, min, node.val) && testTree(node.right, node.val,max);
        }
        
    }
    
}