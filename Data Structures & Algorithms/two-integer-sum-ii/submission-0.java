class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: one at the start, one at the end
        int left = 0;
        int right = numbers.length - 1;
        
        // Loop until the pointers meet
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                // Target found! Return 1-indexed positions
                return new int[] {left + 1, right + 1};
            } else if (currentSum < target) {
                // Sum is too small, move left pointer to the right to increase sum
                left++;
            } else {
                // Sum is too large, move right pointer to the left to decrease sum
                right--;
            }
        }
        
        // Return an empty array if no solution is found 
        // (Though the problem guarantees exactly one solution exists)
        return new int[0];
    }
}