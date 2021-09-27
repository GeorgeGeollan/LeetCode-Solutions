class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) == 1)
                    return -1;
        }

        int row = 0, col = 0, cntrow = 0, cntcol = 0;

        for(int i = 0; i < n; i++)
        {
            row += board[0][i];
            col += board[i][0];

            if(board[0][i] != i % 2)
                cntrow++;

            if(board[i][0] != i % 2)
                cntcol++;
        }

        if(row < n / 2 || row > (n + 1) / 2)
            return -1;

        if(col < n / 2 || col > (n + 1) / 2)
            return -1;

        int res = 0;

        if(n % 2 == 0)
        {
            res += Math.min(cntrow, n - cntrow);
            res += Math.min(cntcol, n - cntcol);
        }

        else
        {
            if(cntrow % 2 == 1)
                cntrow = n - cntrow;
            
            if(cntcol % 2 == 1)
                cntcol = n - cntcol;

            res = cntrow + cntcol;
        }

        return res / 2;
    }
}
