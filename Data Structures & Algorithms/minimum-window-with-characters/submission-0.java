class Solution {
    public String minWindow(String s, String t) {
        // Edge cases
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map for target string 't'
        // Using size 128 to cover all ASCII characters
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        // Count how many UNIQUE characters we need to match
        int requiredChars = 0;
        for (int count : targetFreq) {
            if (count > 0) requiredChars++;
        }

        int left = 0, right = 0;
        int formedChars = 0; // Tracks how many unique characters meet the required frequency
        int[] windowFreq = new int[128];

        // Stores the result: {length, left_index, right_index}
        int[] minWindow = {-1, 0, 0}; 

        while (right < s.length()) {
            // Add the right character to the window
            char c = s.charAt(right);
            windowFreq[c]++;

            // If this character's frequency now matches the target frequency, we formed one requirement
            if (targetFreq[c] > 0 && windowFreq[c] == targetFreq[c]) {
                formedChars++;
            }

            // Try and shrink the window until it ceases to be 'desirable'
            while (left <= right && formedChars == requiredChars) {
                c = s.charAt(left);

                // Save the smallest window until now
                if (minWindow[0] == -1 || right - left + 1 < minWindow[0]) {
                    minWindow[0] = right - left + 1;
                    minWindow[1] = left;
                    minWindow[2] = right;
                }

                // The character at the left pointer is no longer a part of the window
                windowFreq[c]--;
                if (targetFreq[c] > 0 && windowFreq[c] < targetFreq[c]) {
                    formedChars--;
                }
                
                // Move the left pointer ahead to look for a smaller window
                left++;
            }

            // Keep expanding the window
            right++;
        }

        return minWindow[0] == -1 ? "" : s.substring(minWindow[1], minWindow[2] + 1);
    }
}