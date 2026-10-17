class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = prices[0]
        best = 0
        for p in prices[1:]:
            best = max(best, p - min_price)
            min_price = min(min_price, p)
        return best