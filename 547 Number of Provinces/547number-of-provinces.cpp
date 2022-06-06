class Solution {
    // int count;
    void dfs(vector<vector<int>>& isConnected , int i , vector<bool> &visited){
        int n= isConnected.size();
        visited[i]=true;
        // isConnected[v][v]=0;
        // vector<int> check(n,0);
        // if(isConnected[i]==check){
        //     count++;
        // }
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && i!=j && !visited[j]){
              // count++;
                // isConnected[i][v]=0;
                dfs(isConnected,j,visited);
                // count++;
            }
        }
    }
    
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n= isConnected.size();
        vector<bool> visited(n,false);
        int count=0;
//         vector<list<int>> adj;
//         for(auto v: isConnected){
//             adj[i].push_
//         }
        // count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected, i , visited) ;
                count++;
            }
        }
        return count;
    }
};