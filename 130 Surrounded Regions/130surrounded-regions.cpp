class Solution {
    // int m=board.size(),n= board[0].size();
    // int n= board[0].size();
    void dfs(vector<vector<char>>& board ,int i ,int j){
        int n=board.size(),m= board[0].size();
        board[i][j]='t';
        // while(i>=0 && i<n && j>=0 && j<n){
            if(i+1<n && i+1>=0 && board[i+1][j]=='O') dfs(board,i+1,j);
            if(i-1<n && i-1>=0 && board[i-1][j]=='O') dfs(board,i-1,j);
            if(j+1<m && j+1>=0 && board[i][j+1]=='O') dfs(board,i,j+1);
            if(j-1<m && j-1>=0 && board[i][j-1]=='O') dfs(board,i,j-1);
        // }
    }
    
    void solveboundary(vector<vector<char>>& board){
        int n=board.size(),m= board[0].size();
        for(int i=0;i<n;i++){
            int j=0;
            if(board[i][j]=='O') dfs(board,i,j);
            j=m-1;
            if(board[i][j]=='O') dfs(board,i,j);
        }
        for(int j=1;j<m-1;j++){
            int i= 0;
            if(board[i][j]=='O') dfs(board,i,j);
            i = n-1;
            if(board[i][j]=='O') dfs(board,i,j);
        }
    }
    
    void checksolve(vector<vector<char>>& board){
       int n=board.size(),m= board[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='t') board[i][j]='O';
            }
        }
        // for(auto &&i:board){
        //     for(auto j:i){
        //         if(j=='O'){
        //             j='X';
        //         }
        //         else if (j=='t'){
        //             j='O'; 
        //         }
        //     }
        // }
        // for(auto it:board){
        //     for(auto c:it){
        //         if(c=='O'){
        //         c='X';
        //         }
        //         else if(c=='t') {
        //             c='O';
        //         }
        //     }
        // }
    }
    
public:
    void solve(vector<vector<char>>& board) {
        // int x,int o;
        solveboundary(board);
        checksolve(board);
    }
};