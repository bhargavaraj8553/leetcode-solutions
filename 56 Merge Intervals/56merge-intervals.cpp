class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> final;
        int n=intervals.size();
        
        if(n<=1) return intervals;
        
        sort(intervals.begin(),intervals.end());
        final.push_back(intervals[0]);
        
        for(int i=1;i<n;i++){
            // vector<int> a(2,-1);
            // for(int j=i+1;j<n;j++){
                if(final.back()[1]>=intervals[i][0]){
                    final.back()[1]=max(final.back()[1],intervals[i][1]);
                    // a[0]= min(intervals[i][0],intervals[j][0]);
                    // a[1]= max(intervals[j][1],intervals[i][1]);
                    // i++;
                    // if(a[0]!=-1) final.push_back(a);
                }
            
                    else final.push_back(intervals[i]);
            
        }
        return final;
    }
};



// class Solution {
// public:
//     vector<vector<int>> final;
//     vector<vector<int>> merge(vector<vector<int>>& intervals) {
//         int n=intervals.size();
//         if(n<=1) return intervals;
//         vector<int> temp={};
//         int i=0;
//        while(i<n-1){
//                 if(intervals[i][1]>=intervals[i+1][0]){
//                     temp.push_back(intervals[i][0]);
//                     temp.push_back(intervals[i+1][1]);
//                     i++;
//                 }
//             if(temp.size()!=0){
//                 final.push_back(temp);
//             }
//             else{
//                 i++;
//                 final.push_back(intervals[i]);
//                 // i++;
//                 }
//             // i++;
//             // i--;
//             temp={};
//         }
//         return final;
//     }
// };