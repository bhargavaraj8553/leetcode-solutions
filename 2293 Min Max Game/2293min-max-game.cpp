class Solution
{
private:
    int getval(vector<int> &nums)
    {
        vector<int> newNums;
        int n=nums.size();
        if (nums.size() == 1)
            {
                return nums[0];
            }
        for (int i = 0; i < n / 2; i++)
        {
            
            if (i % 2 == 0)
            {
                newNums.push_back(min(nums[2 * i], nums[2 * i + 1]));
            }
            else
            {
                newNums.push_back(max(nums[2 * i], nums[2 * i + 1]));
            }
        }
        return getval(newNums);
        return -1;
    }

public:
    int minMaxGame(vector<int> &nums)
    {
        return getval(nums);
    }
};