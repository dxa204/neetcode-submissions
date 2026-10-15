class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create 3 arrays to track what we've seen.
        // Default value in a boolean array is 'false'
        boolean[][] seenInRow = new boolean[9][9];
        boolean[][] seenInCol = new boolean[9][9];
        boolean[][] seenInBox = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // 1. Convert the character '1'-'9' to an index 0-8
                // For example, '5' - '1' = 4. So the number 5 is stored at index 4.
                int num = board[r][c] - '1';

                // 2. Figure out which of the 9 boxes we are currently in (0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // 3. Have we seen this number before?
                if (seenInRow[r][num] || seenInCol[c][num] || seenInBox[boxIndex][num]) {
                    // Duplicate found! We can stop checking and fail immediately.
                    return false; 
                }

                // 4. Record that we have now seen this number
                seenInRow[r][num] = true;
                seenInCol[c][num] = true;
                seenInBox[boxIndex][num] = true;
            }
        }
        
        // If we check every cell and never trigger the 'return false', the board is valid!
        return true;
    }
}