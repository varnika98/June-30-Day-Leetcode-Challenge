/*
Problem : 
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
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
    public int countNodes(TreeNode root) {
        int height = findDep(root);
        return dfs(root, height);
    }
    
    private int dfs(TreeNode root, int height) {
        if (root == null) {
            return 0;
        }

        if (findDep(root.right) == height - 1) {
            return dfs(root.right, height - 1) + (1 << (height - 1));
        } else {
            return dfs(root.left, height - 1) + (1 << (height - 2));
        }
    }
    
    private int findDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + findDep(root.left);
    }
}

// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root == null)
//             return 0;
//         return 1 + countNodes(root.left) + countNodes(root.right);
//     }
// }