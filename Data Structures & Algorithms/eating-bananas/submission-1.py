class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lower, upper = 1, max(piles)
        while lower < upper:
            k = (lower + upper) // 2
            hours = 0
            for p in piles:
                hours += (p + k - 1) // k   # ceil(p / k)
            if hours <= h:
                upper = k        # k works, try smaller
            else:
                lower = k + 1    # too slow, go faster
        return lower