bool comp(vector<int> &a , vector<int> &b){
        return a[1]<b[1];
    }
class Solution {
public:
    
    int findMinArrowShots(vector<vector<int>>& points) {
        int n=points.size(),ans=1;
        sort(points.begin(),points.end(),comp);
    int end= points[0][1];
    for(int i=1; i<n; i++){
        if(points[i][0]>end){
            ans++;
            end= points[i][1];
        }
    }
    
    // void comp()
    // int findMinArrowShots(vector<int> &a , vector<int> &a){
    //     return a[1]<b[1];
    // }
//         1 6  2 8  7 12  10 16
        // 16 28 7 12 10 16 
     
        return ans;
    }
};