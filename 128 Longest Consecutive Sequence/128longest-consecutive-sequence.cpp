class Solution
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        unordered_set<int> st;
        int n = nums.size(), maxcount = 0;
        for (int i = 0; i < n; i++)
        {
            st.insert(nums[i]);
        }

        for (int i = 0; i < n; i++)
        {
            int count = 1;
            int val = nums[i];
            if(st.find(val-1)!=st.end()){
                continue;
            }
            // while (st.find((val - 1)) != st.end())
            // {
            //     val--;
            // }
            while (st.find(val + 1) != st.end())
            {
                count++;
                st.erase(val+1);
                val++;
            }
            maxcount = max(count, maxcount);
            
            cout<<count<<" ccc "<<maxcount<<" mx " <<endl;
        }
        return maxcount;
    }
};





// class Solution
// {
// public:
//     int longestConsecutive(vector<int> &nums)
//     {
//         int n = nums.size(), count = 1, maxcount = 1;
//         if (nums.size() == 0)
//             return 0;
//         sort(nums.begin(), nums.end());
//         for (int i = 0; i < n - 1; i++)
//         {
//             // while (i < n - 1 && nums[i + 1] == nums[i])
//             // {
//             //     i++;
//             // }
//             if (i < n - 1 && nums[i + 1] == nums[i] + 1)
//             {
//                 count++;
//                 cout<<nums[i]<<" vvv "<<count<<" ccccc "<<endl;
//                 while (i < n - 2 && nums[i + 2] == nums[i+1])
//             {
//                 i++;
//             }
//                 if ((i < n - 2) && (nums[i + 2] != nums[i + 1] + 1))
//                 {
//                     maxcount = max(maxcount, count);
//                     count = 1;
//                     cout << maxcount << " mmm " << count << " ccc " << endl;
//                 }
//             }
//             maxcount = max(maxcount, count);
//         }
//         return maxcount;
//     }
// };