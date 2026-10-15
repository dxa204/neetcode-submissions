class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [1] * n
        suffix = [1] * n
        for i in range (1, len(nums)):
            prefix[i] = prefix[i-1] * nums[i-1]
        for j in range (n-2, -1, -1):
            suffix[j] = suffix[j+1] * nums[j+1]
        output = [1] * n
        for i in range (0, len(nums)):
            output[i] = prefix[i] * suffix[i]
        return output 

        