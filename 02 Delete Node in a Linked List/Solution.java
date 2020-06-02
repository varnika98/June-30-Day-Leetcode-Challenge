/*
Problem : 
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]

*/

/*
Analysis ::
Time Complexity :: O(1)
Space Complexity :: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}