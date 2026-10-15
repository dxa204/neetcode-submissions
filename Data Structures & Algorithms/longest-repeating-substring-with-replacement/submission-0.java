class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxf = 0; // Tracks the highest frequency of a single character in the window
        
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to our frequency map
            counts[s.charAt(right) - 'A']++;
            
            // Update the historical max frequency
            maxf = Math.max(maxf, counts[s.charAt(right) - 'A']);
            
            // If the characters we need to replace exceeds k, shrink the window
            while ((right - left + 1) - maxf > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            
            // The window is guaranteed to be valid here
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}