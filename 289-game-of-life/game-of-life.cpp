class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int arr[26][26];
        int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
        int dy[8] = {1, -1, 0, 1, -1, 0, 1, -1};
        
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                if (board[i][j]) {
                    int sum = 0;
                    for (int l = 0; l < 8; l++) {
                        if (i + dx[l] < 0 || board.size() - 1 < i + dx[l] || j + dy[l] < 0 || board[0].size() - 1 < j + dy[l]) continue;
                        sum += board[i + dx[l]][j + dy[l]];
                    }

                    if (sum < 2) {
                        arr[i][j] = 0;
                    }
                    else if (sum == 2 || sum == 3) {
                        arr[i][j] = 1;
                    }
                    else if (3 < sum) {
                        arr[i][j] = 0;
                    }
                }
                else {
                    int sum = 0;
                    for (int l = 0; l < 8; l++) {
                        if (i + dx[l] < 0 || board.size() - 1 < i + dx[l] || j + dy[l] < 0 || board[0].size() - 1 < j + dy[l]) continue;
                        sum += board[i + dx[l]][j + dy[l]];
                    }

                    if (sum == 3)
                        arr[i][j] = 1;
                    else 
                        arr[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                board[i][j] = arr[i][j];
            }
        }
    }
};