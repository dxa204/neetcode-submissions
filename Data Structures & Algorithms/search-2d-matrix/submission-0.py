class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])

        # 1) Binary search over rows to find the one that could hold target
        top, bot = 0, ROWS - 1
        while top <= bot:
            row = (top + bot) // 2
            if target > matrix[row][-1]:      # bigger than this row's last -> go down
                top = row + 1
            elif target < matrix[row][0]:     # smaller than this row's first -> go up
                bot = row - 1
            else:                             # target falls inside this row's range
                break

        if not (top <= bot):                  # no row can contain it
            return False

        # 2) Normal binary search inside that row
        l, r = 0, COLS - 1
        while l <= r:
            m = (l + r) // 2
            if matrix[row][m] == target:
                return True
            elif matrix[row][m] < target:
                l = m + 1
            else:
                r = m - 1
        return False