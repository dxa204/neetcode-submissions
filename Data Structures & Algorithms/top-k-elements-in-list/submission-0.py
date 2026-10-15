from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 1. Build the frequency map
        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1

        # 2. Create the bucket array
        # The maximum frequency of any element is the length of the array.
        # We create an array of empty lists where the INDEX represents the frequency.
        freq_buckets = [[] for _ in range(len(nums) + 1)]
        
        for num, c in count.items():
            freq_buckets[c].append(num)

        # 3. Extract the top k elements
        # Scan the buckets from right to left (highest frequency to lowest)
        res = []
        for i in range(len(freq_buckets) - 1, 0, -1):
            for num in freq_buckets[i]:
                res.append(num)
                if len(res) == k:
                    return res