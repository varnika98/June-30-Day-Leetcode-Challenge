/*
Problem : 
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

Example 1:
Input: "banana"
Output: "ana"

Example 2:
Input: "abcd"
Output: ""
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public String longestDupSubstring(String S) {
        int left = 0;
        int right = S.length() - 1;
        
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            
            if (isDuplicatePresent(S, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return findDuplicate(S, left);
    }
    
    private boolean isDuplicatePresent(String S, int length) {
        if (length == 0)
            return true;
        
        return findDuplicate(S, length) != null;
    }
    
    private String findDuplicate(String S, int length) {        
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < length; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (S.charAt(i) - 'a');
        }
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);
        
        for (int i = length; i < S.length(); i++) {
            hash = hash * prime + (S.charAt(i) - 'a');
            hash -= firstEntryPower * (S.charAt(i - length) - 'a');
            
            if (map.containsKey(hash)) {
                int index = map.get(hash);
                return S.substring(index, index + length);
            }
            
            map.put(hash, i - length + 1);
        }
        
        return null;
    }
}