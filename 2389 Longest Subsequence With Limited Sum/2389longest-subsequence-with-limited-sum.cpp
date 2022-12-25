// class Solution {
// public:
//     vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
//         sort(nums.begin(),nums.end());
//         vector<int> ans;
//         for(int j=0;j<queries.size();j++){
//             int i=0,sum=0,count=0,n=queries.size();
//             while(i<nums.size() && sum<queries[j]){
//                 sum= sum+nums[i];
//                 if(sum>queries[j]){
//                     break;
//                 }
//                 i++;
//                 count++;
//                 // cout<<j<<" j "<<sum<<" sum "<<count<<" count "<<endl;
//             }
//             ans.push_back(count);
//             // cout<<sum<<" sum "<<count<<" count "<<endl<<endl;
//         }
//         return ans;
//     }
// };

class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        // Sort 'nums'
        sort(nums.begin(), nums.end());
        
        // For each query, collect numbers from lowest to highest.
        // If their sum exceeds the limit 'query', move on to the next query.
        vector<int> ans;
        for (auto query : queries) {
            int count = 0;
            for (auto num : nums) {
                if (query >= num) {
                    query -= num;
                    count++;
                }
                else {
                    break;
                }
            }
            ans.push_back(count);
        }
        
        return ans;
    }
};