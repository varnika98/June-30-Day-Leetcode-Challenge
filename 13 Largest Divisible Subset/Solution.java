/*
Problem : 
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        int n = nums.length;
        int[] count = new int[n];
        Arrays.sort(nums);
        Arrays.fill(count, 1);
        
        for(int i=1; i<n; i++)
            for(int j=i-1; j>=0; j--)
                if(nums[i] % nums[j] == 0)
                    count[i] = Math.max(count[i], count[j]+1);
        
        int maxIndex = 0;
        for(int i=1; i<n; i++)
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        
        int temp = nums[maxIndex];
        int currentCount = count[maxIndex];
        List<Integer> res = new ArrayList<>();
        
        for(int i=maxIndex; i>=0; i--){
            if(temp % nums[i] == 0 && count[i] == currentCount){
                res.add(nums[i]);
                currentCount--;
            }
        }
        return res;
    }
}