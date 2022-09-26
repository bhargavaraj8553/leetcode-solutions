class Solution {
public:
    // vector<vector<int>> ans;
    void pushvec(int i,int j,int s,int e, vector<int> &nums , vector<vector<int>> &ans){
        vector<int> a(4);
        a[0]=nums[i];a[1]=nums[j];a[2]=nums[s];a[3]=nums[e];
        ans.push_back(a);
    }
    
    vector<vector<int>> fourSum(vector<int>& nums, long long int target) {
        int n=nums.size();
        vector<vector<int>> ans;
        sort(nums.begin(),nums.end());
        
        if(n<4) return ans; 
        
        for(int i=0;i<n;i++){
            // if(nums[i]>0 && target <0) return ans;
            for(int j=i+1;j<n;j++){
                // if(nums[j]>target) return ans;
                int s=j+1,e=n-1;
                // if(((target-nums[i]-nums[j]) <INT_MIN/10) or ((target-nums[i]-nums[j]) >INT_MAX/10)){
                //     return ans;
                // }
                long long left = target-nums[i]-nums[j];
                while(s<e){
                    if(nums[s]+nums[e] == left){
                        pushvec(i,j,s,e,nums,ans);
                        while(nums[s+1]==nums[s] && s+1<e){s++;}s++;
                        while(nums[e-1]==nums[e] && s<e-1){e--;}e--;
                        }
                    else if(nums[s]+nums[e] > left){
                        while(nums[e-1]==nums[e] && s<e-1){e--;}e--;
                    }
                    else{
                        while(nums[s+1]==nums[s] && s+1<e){s++;}s++;
                    }
                }
                while(j<n-1 && nums[j+1]==nums[j]){j++;}
            }
            while(i<n-1 && nums[i+1]==nums[i]){i++;}
        }
        return ans;
    }
};