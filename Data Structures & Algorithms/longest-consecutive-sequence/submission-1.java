
class Solution {
    public int longestConsecutive(int[] nums) {
        // Handle edge case of an empty array
        if (nums.length == 0) {
            return 0;
        }

        // 1. Put all numbers into a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // 2. Iterate through the set to find sequences
        for (int num : set) {
            // 3. Only start counting if 'num' is the START of a sequence
            // (meaning the number right below it doesn't exist)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 4. Count upwards as high as the sequence goes
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 5. Update our longest streak record
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}