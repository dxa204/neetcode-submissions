class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;                   // Pointer starting at the beginning
        int j = cleanedString.length() - 1;      // Pointer starting at the end
        
        // Loop until the pointers meet or cross
        while (i < j) {
            // Compare characters directly from the string
            if (cleanedString.charAt(i) != cleanedString.charAt(j)) {
                return false; // Mismatch found, not a palindrome
            }
            i++; // Move left pointer forward
            j--; // Move right pointer backward
        }
        return true;
    }
}