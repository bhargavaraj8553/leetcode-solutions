class Solution {
public:
vector<int> dailyTemperatures(vector<int>& temperatures) {
    vector<int> res(temperatures.size());
    for (int i = temperatures.size() - 1; i >= 0; --i) {
        int j = i+1;
        while (j < temperatures.size() && temperatures[j] <= temperatures[i]) {
            if (res[j] > 0) j = res[j] + j;
            else j = temperatures.size();
        }
        // either j == size || temperatures[j] > temperatures[i]
        if (j < temperatures.size()) res[i] = j - i;
    }
    return res;
}
    // vector<int> dailyTemperatures(vector<int>& temp) {
    //     int n= temp.size(),count = 0,j=0;
    //     vector<int> ans;
    //     map<int,int> mp;
    //     for(auto it:temp){
    //         mp[it]++;
    //     }
    //     for(int i=0;i<n;i++){
    //         count =0,j=i;
    //         while(j<n && temp[j]<=temp[i]){
    //                 count++;
    //                 j++;
    //         }
    //         if(j==n){
    //             count=0;
    //         }
    //         // cout<<i<<" iiii "<<j<<" jjjj "<<count<<endl;
    //         ans.push_back(count);
    //     }
    //     return ans;
    // }
};