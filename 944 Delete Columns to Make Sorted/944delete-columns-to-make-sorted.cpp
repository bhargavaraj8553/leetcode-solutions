class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int n=strs[0].size(),count=0;
        
        for(int col=0;col<n;col++){
            for(int row=1;row<strs.size();row++){
                if(strs[row][col]<strs[row-1][col]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
};



// class Solution {
// public:
//     int minDeletionSize(vector<string>& strs) {
//         int n=strs.size(),i=0,count=0;
//         while(i<n){
//             for(int j=2;j<strs[i].size();j++){
//                 if((strs[i][j]>strs[i][j-1] && strs[i][j-1]<strs[i][j-2]) || (strs[i][j]<strs[i][j-1] && strs[i][j-1]>strs[i][j-2])){
//                     count++;
//                     break;
//                 }
//             }
//             i++;
//         }
//         return count;
//     }
// };