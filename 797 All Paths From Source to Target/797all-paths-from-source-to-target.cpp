class Solution {
    private: void dfs(vector<vector<int>>& graph,vector<vector<int>>& result , vector<int>& path ,int i){
        // if(!visited[i]){
        path.push_back(i);
        // }
        // visited[i]=true;
        if(i==graph.size()-1){
                result.push_back(path);
                // path.clear();
            }
        else {
        for(auto it: graph[i]) {dfs(graph,result,path,it);}
            }
        
        path.pop_back();
    }
            // if(!visited[it]){
                // visited[it]=false;
            // path.push_back(it);
            // if(it==graph.size()){
                // result.push_back(path);
                // path.clear();
            // }
            // else {
            // dfs(graph,visited,result,path,it);
            // if(it==graph.size()-1)
            //     result.push_back(path);
            // path.clear();
            // for(auto v:visited){
            //     v=false;
            // }
            // }
            // }
            // result.push_back(path);
            // path.pop_back();
        // }
    // }
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int n = graph.size();
        // vector<bool> visited(n,false);
       vector<vector<int>> result;
        vector<int> path; 
        dfs(graph,result,path,0);
        return result;
    }
};