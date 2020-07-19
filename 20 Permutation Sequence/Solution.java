/*
Problem : 
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    int steps=0;
    String ans = "";
    public String getPermutation(int n, int k) {       
        genPerm(n, k, new boolean[n+1], new StringBuilder());
        return ans;
    }
    
    private void genPerm(int n, int k, boolean[] chosen, StringBuilder curPerm){
        if(curPerm.length()==n&&++steps==k){
            ans = curPerm.toString();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!chosen[i]){
                chosen[i] = true;
                curPerm.append(i);
                genPerm(n,k,chosen,curPerm);
                chosen[i]=false;
                curPerm.deleteCharAt(curPerm.length()-1); 
            }
        }
    }
}