

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // If we find a duplicate, shrink the window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to the set
            set.add(s.charAt(right));
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}