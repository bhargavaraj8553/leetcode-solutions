class Solution {
public:
    bool searchMatrix(vector<vector<int>>& mat, int target) {
        
        int m = mat.size(),n=mat[0].size();
        if(mat[m-1][n-1]<target) return false;
        for(int i=0;i<m;i++){
            int s=0,e=n-1;
            // 
            if(target<mat[i][s]) return false;
            while(mat[i][e]<target){i++;}
                while(s<=e){
                    int mid=(s+e)/2;
                    if(mat[i][mid]==target){return true;}
                    else if(mat[i][mid]>target){e=mid-1;}
                    else{s=mid+1;}
                }
        }
        return false;
        
        
        
        // for(auto r:mat){
        //     for(auto c:r){
        //         if(c==target) return true;
        //     }
        // }
        // return false;
    }
};