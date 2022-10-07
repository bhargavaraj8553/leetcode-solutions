class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        int n = nums.size();
        vector<vector<int>> final;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n - 2; i++)
        {

            if (i == 0 || i > 0 && nums[i] != nums[i - 1])
            {
                // while(i>0 && i<n-1 &&  nums[i]==nums[i-1]){i++;}
                int s = i + 1, e = n - 1;
                int val = -nums[i];
                while (s < e)
                {
                    // cout<<nums[i]<<" numsi "<<nums[s]<<" s "<<nums[e]<<" e "<<endl;
                    // while(s>i+1  && nums[s]==nums[s-1]){
                    //     s++;
                    //     if(s>e) break;
                    // }
                    // while(e<n-1 && nums[e]==nums[e+1]){
                    //     e--;
                    //     if(s>e) break;
                    // }
                    // if(s>=e)break;
                    if (nums[s] + nums[e] == val)
                    {
                        vector<int> temp;
                        temp.push_back(nums[i]);
                        temp.push_back(nums[s]);
                        temp.push_back(nums[e]);
                        final.push_back(temp);
                        s++;
                        e--;

                        while (nums[s] == nums[s - 1])
                        {
                            s++;
                            if (s > e)
                                break;
                        }
                        while (nums[e] == nums[e + 1])
                        {
                            e--;
                            if (s > e)
                                break;
                        }
                        if (s >= e)
                            break;
                    }
                    
                    else if (nums[s] + nums[e] < val)
                    {
                        s++;
                    }
                    
                    else
                    {
                        e--;
                    }
                    
                }
                
            }
            
        }
        return final;
    }
};