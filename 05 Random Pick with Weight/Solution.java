/*
Problem : 
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    
    Random rand;
    int[] weights;

    public Solution(int[] w) {
        this.rand = new Random();
        for(int i=1; i<w.length; i++)
            w[i] += w[i-1];
        this.weights = w;
    }
    
    public int pickIndex() {
        int val = rand.nextInt(weights[weights.length-1])+1;
        int l = 0;
        int r = weights.length;
        while(l<r){
            int m = l + (r-l)/2;
            if(weights[m] == val)
                return m;
            else if(weights[m] < val)
                l = m+1;
            else
                r = m;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */