class Solution {
    private: vector <int> val(int n){
        // int highbit =1;
        // if(n==0) return dp 0;
        // int dp[10001]={0};
        vector <int> dp(n+1,0);
        
        // if(n==0) return dp[0]= 0;
        if((dp[n]!=0)){
            return dp;
        }
        for(int i=1;i<=n;i++){
            // if(highbit * 2 ==i){
            //     highbit=i;
            // }
            // dp[i] = 1+dp[i-highbit];
            dp[i]=dp[i/2]+i%2;
        }
        return dp;
    }
        
public:
    vector<int> countBits(int n) {
       //  int highbit =1;
       //  vector <int> ans;
       // //  dp[0]=0;
       // //  if((dp[n]!=-1)){
       // //      return dp;
       // //  }
       //  for(int i=0;i<=n;i++){
       //      ans.push_back(val(i));
       //      }
       // //      dp[i] = 1+dp[i-highbit];
       // //  }
       // //  return dp;
       // // memset(dp, -1, sizeof dp);
       //  return ans;
        return val(n);
    }
};

// class Solution {
//     private: int value (long long int i,  int count){
//         // if(i<0){return count;}
//         cout<<" count value is "<<count<<" i value is "<<i<<"  aaaaaaaaaaaaaaa"<<endl;
//         if (i<=0){return count;}
//         if(i%2==1){
//             count++;
//         }
//         cout<<" count value is "<<count<<" i value is "<<i<<"  bbbbbbbbbbb"<<endl;
//         value(i/2,count);
//         cout<<" count value is "<<count<<" i value is "<<i<<"  ccccccccccccc"<<endl;
//         return count;
//         cout<<" count value is "<<count<<" i value is "<<i<<"  dddddddddddddd "<<endl;
//     }
// public:
//     vector<int> countBits(int n) {
//         vector <int> ans;
//         for(int i=n;i<=n;i++){
//             // int count=0,k=i;
//             // while(k>0){
//             //     if(k%2==1){
//             //     count++;
//             //     }
//             //     k=k/2;
//             // }
//             int val= value(i,0);
//             ans.push_back(val);
//         }
//         return ans;
//         }
// };