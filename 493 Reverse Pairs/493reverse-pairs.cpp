class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
public:
    long long int merge(vector<int> &nums, int s, int e)
    {
        // int count=0;
        long long int count = 0;
        int mid = (s + e) / 2;
        int k = s;
        int len1 = mid - s + 1;
        int len2 = e - mid;
        long long int num1[len1], num2[len2];

        int j= mid+1;
        // int j= s;
        for(int i=s;i<=mid;i++){
            while(j<= e && 2*long(nums[j])<long(nums[i])){
                j++;
            }
                count+= j-(mid+1);
        }
        
        // while ((2 * num2[p2] >= num1[i]) && i < len1)
        // {
        //     i++;
        //     if (i == len1)
        //         break;
        // }
        // i--;
        // count += len1 - i;

        for (int i = 0; i < len1; i++)
        {
            num1[i] = nums[k++];
        }
        // k= mid+s+1;
        for (int i = 0; i < len2; i++)
        {
            num2[i] = nums[k++];
        }
        int p1 = 0, p2 = 0;
        k = s;

        while (p1 < len1 && p2 < len2)
        {
            if (num1[p1] < num2[p2])
            {
                nums[s++] = num1[p1++];
            }
            else
            {
                nums[s] = num2[p2];
                // count++;
                // inv+=len1-p1;
                // int i=p1;
                // while(( 2* num2[p2]>= num1[i]) && i<len1){
                //     i++;
                //     if(i==len1)break;
                // }
                // // i--;
                // count+= len1-i;
                // while(i<len1){
                //     if(float(num2[p2])<float(num1[i])/2){
                //         count++;
                //         // cout<<count<<" hhhhgg ";
                //     }
                //     i++;
                // }

                s++;
                p2++;
            }
        }

        while (p1 < len1)
        {
            nums[s++] = num1[p1++];
            // count++;
        }
        while (p2 < len2)
        {
            nums[s++] = num2[p2++];
        }
        // cout<<count<<" iiii ";
        return count;
    }

    long long int mergesort(vector<int> &nums, int left, int right)
    {

        long long int count = 0;
        if (left < right)
        {
            int mid = (right + left) / 2;
            count += mergesort(nums, left, mid);
            // cout << count << " ff ";
            count += mergesort(nums, mid + 1, right);
            // cout << count << " rr ";11
            count += merge(nums, left, right);
            // cout << count << " gg ";
        }
        return count;
    }

    // long long int inversionCount(long long nums[], long long N)
    // {
    //     // Your Code Here
    //     return mergesort(nums,0,N-1);
    //     // return count;
    // }

    int reversePairs(vector<int> &nums)
    {
        int n = nums.size();
        return mergesort(nums, 0, n - 1);
    }
};
