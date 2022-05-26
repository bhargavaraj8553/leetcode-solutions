class Solution {
public:
    bool isHappy(int n) 
    {
       set<int> nums;
        while(n!=1)
        {
          int temp=0;
          while(n)
          {
              temp+=(n%10)*(n%10);
              n=n/10;
          }
          n=temp;
          if(nums.count(n)==0)
              nums.insert(n);
          // else if(n==1)
          //     return true;
          else
              return false;
              
        }
        return true;
    }
};

// class Solution {
//     private: int sqsum(int n){
//         int sq=0;
//         while(n>0){
//             sq+= (n%10 * n%10);
//             n=n/10;
//         }
//         return sq;
//     }
    
//     int ispresent(vector<int> arr,int n){
//         for (auto it:arr){
//             if (it==n){
//                 return 1;
//             }
//         }    
//         return 0;
//     }
    
// public:
//     bool isHappy(int n) {
       
//         vector<int> arr(n+1);
        
//         if (n== 1){
//             return true;
//         }
//         if (ispresent(arr,n)==1){
//             return false;
//         }
//         arr.push_back(n);
//         return isHappy(sqsum(n));
//        // return false; 
//     }
// };





















// class Solution {

//     private: bool sqsum(int n){
//         int sq,sum=0;
//         // if(sum)
//         if (n==1){
//             return true;
//         }
//         if(n<4 && (n!=0)){
//             return false;
//         }
//         while(n>0){
//         sq= (n%10) * (n%10);
//         sum+=sq;
//         n=n/10;
//         }
        
        
        
//         return sqsum(sum);
//         return false;
//     }
    
// public:
//     bool isHappy(int n) {
//         return sqsum(n);
//     }
// };
