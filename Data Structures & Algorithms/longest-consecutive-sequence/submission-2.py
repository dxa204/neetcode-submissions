class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        nums.sort()
        best = cur = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:          # duplicate: skip it
                continue
            if nums[i] == nums[i - 1] + 1:      # streak continues
                cur += 1
            else:                               # streak broken: restart
                cur = 1
            best = max(best, cur)
        return best