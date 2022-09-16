class Solution {
public:
    void rotate(vector<vector<int>>& mat) {
        int m=mat.size(),n=mat[0].size(),i=0,j=0;
        
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                swap(mat[i][j],mat[j][i]);
            }
        }
        
        for(int i=0;i<m;i++){
            int k=0,j=n-1;
                while(j>k){
                swap(mat[i][k],mat[i][j]);
                    k++;j--;
                }
        }
        
    }
};