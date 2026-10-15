class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate current width
            int width = right - left;
            
            // Find the height of the current container (bottlenecked by the shorter line)
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate area and update maxWater if we found a larger one
            int currentWater = currentHeight * width;
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}