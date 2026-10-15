class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Populate the frequency map for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Calculate initial matches
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) {
                matches++;
            }
        }

        // Slide the window across the rest of s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches == 26) {
                return true;
            }

            // The character entering the window from the right
            int rightCharIndex = s2.charAt(i + s1.length()) - 'a';
            windowCount[rightCharIndex]++;
            if (windowCount[rightCharIndex] == s1Count[rightCharIndex]) {
                matches++;
            } else if (windowCount[rightCharIndex] == s1Count[rightCharIndex] + 1) {
                matches--;
            }

            // The character leaving the window from the left
            int leftCharIndex = s2.charAt(i) - 'a';
            windowCount[leftCharIndex]--;
            if (windowCount[leftCharIndex] == s1Count[leftCharIndex]) {
                matches++;
            } else if (windowCount[leftCharIndex] == s1Count[leftCharIndex] - 1) {
                matches--;
            }
        }

        // Check the final window
        return matches == 26;
    }
}