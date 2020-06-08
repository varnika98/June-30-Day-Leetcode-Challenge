/*
Problem : 
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true 

Example 2:
Input: 16
Output: true

Example 3:
Input: 218
Output: false

*/

/*
Analysis ::
Time Complexity :: O(1)
Space Complexity :: O(1)
*/

// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         while(n > 1 && n%2 == 0)
//             n = n>>1;
//         return n == 1 ? true : false;
//     }
// }

// AND of a number and it's complement is the number itself
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n&(-n)) == n;
    }
}