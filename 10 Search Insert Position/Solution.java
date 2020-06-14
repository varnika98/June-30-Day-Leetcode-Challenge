/*
Problem : 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m] == target)
                return m;
            else if(nums[m] < target)
                l = m+1;
            else
                r = m;
        }
        return l;
    }
}