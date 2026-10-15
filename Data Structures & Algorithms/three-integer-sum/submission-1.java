
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to use two pointers and handle duplicates
        Arrays.sort(nums); 
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Set up Two Pointers for the remainder of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet! Add it to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                    // Skip duplicate values for 'left'
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate values for 'right'
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to increase it
                    left++;
                } else {
                    // Sum is too large, move right pointer to decrease it
                    right--;
                }
            }
        }
        
        return result;
    }
}