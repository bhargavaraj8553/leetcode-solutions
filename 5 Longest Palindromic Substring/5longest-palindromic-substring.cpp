// class Solution {
// public:
//     string longestPalindrome(string s) {
//         if(s.length() <= 1) return s;
//         int max_len = 1;
//         int n = s.length();
//         int st = 0, end = 0;
        
//         // Odd length
//         for(int i = 0; i < n-1; ++i){
//             int l = i, r = i;
//             while(l >= 0 && r < n){
//                 if(s[l] == s[r]){
//                     l--; r++;
//                 }else
//                     break;
//             }
//             int len = r-l-1;
//             if(len > max_len){
//                 max_len = len;
//                 st = l+1;
//                 end = r-1;
//             }
//         }
        
//         // Even length
//         for(int i = 0; i < n-1; ++i){
//             int l = i, r = i+1;
//             while(l >= 0 && r < n){
//                 if(s[l] == s[r]){
//                     l--; r++;
//                 }else
//                     break;
//             }
//             int len = r-l-1;
//             if(len > max_len){
//                 max_len = len;
//                 st = l+1;
//                 end = r-1;
//             }
//         }
        
//         return s.substr(st, max_len);
        
//     }
// };


class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();
        if(n<=1) return s;
        int maxlen=0;
        string sf=s.substr(0,1);
        vector<vector<int>> dp(n+1,vector<int> (n+1,0));
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        // cout<<"hvhgvhgvhvh"<<dp[1][2]<<endl;
        
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                    if(s[i]==s[j]){
                        if(j==i || (j-i==1) || dp[i+1][j-1]==1){
                        dp[i][j]=1;
                        // cout<<dp[i][j]<<" i "<<i<<" j "<<j<<endl;
                        // maxlen= j-i+1;
                        if(j-i+1 >maxlen){
                            maxlen= j-i+1;
                            sf=s.substr(i,maxlen);
                        }
                        
                    }
                    }
                    // else dp[i][j]=0;
                
                // cout<<"wrefer"<<dp[0][4];
            }
        }
        return sf;
    }
};





// // //m 2 wrong answer not working properly
// class Solution {
// public:
//     string longestPalindrome(string s){
//         int n=s.length(),reslen=1,st=0,end=0;
//         if(n<=1) return s;
//         //for odd lengths palindrome
        
//         for(int i=0;i<n;++i){
//             int l,e;
//             // if(n%2==1){
//                 l=i;
//                 e=i;
//             // }
//             // else{
//                 // l=i;
//                 // e=i+1;
//             // }
            
//             while(l>=0 && e<n ){//a b a b a b c
//                 if(s[l]==s[e]){
//                     l--;
//                     e++;
//                 }else 
//                     break;
//             }
            
//             // cout<<l<<" left "<<e<<" right "<<reslen<<" len "<<endl;;
            
//             int len = e-l-1;
//             if(len > reslen){
//                 reslen = len;
//                 st = l+1;
//                 end = e-1;
//             }
//         }
//     //actually the problem i was facing was that i was only considering the odd length strings but to also consider even lengths strings we need to consider both the conditions simulatenously instead of using or we should use and instead
        
//         // for even lengths palindrome
//         for(int i=0;i<n;++i){
//             int l,e;
//             // if(n%2==1){
//                 // l=i;
//                 // e=i;
//             // }
//             // else{
//                 l=i;
//                 e=i+1;
//             // }
            
//             while(l>=0 && e<n ){//a b a b a b c
//                 if(s[l]==s[e]){
//                     l--;
//                     e++;
//                 }else 
//                     break;
//             }
            
//             // cout<<l<<" left "<<e<<" right "<<reslen<<" len "<<endl;;
            
//             int len = e-l-1;
//             if(len > reslen){
//                 reslen = len;
//                 st = l+1;
//                 end = e-1;
//             }
//         }
        
//             // if(e-l-1>=reslen){
//             //     reslen=e-l-1;
//             //     cout<< reslen<<endl;
//             //     st=l+1;
//             //     end=e-1;
//             //     // sf=s.substr(l,e-l+1);
//             // }
            
//         // }
//          return s.substr(st,reslen);
//         }
//     };
    // }
    // string longestPalindrome(string s) {
    //     // int n=s.length();
    //     // string sf=s.substr(0,1);
    //     // string sf="";
    //     return checkpalindrome(s);
  





// // m1 brute force tle giving

// // // class Solution {
// // // public:
// // //     void ispalindrome(string s1,vector<string> &all){
// // //         int l=s1.length();
// // //         if(l==1){
// // //             all.push_back(s1);
// // //             return;}
// // //         for(int i=0;i<l/2;i++){
// // //             if(s1[i]!=s1[l-i-1]) return;//i 4-i avaava
// // //         }
// // //         all.push_back(s1);
// // //     }
    
// // //     answer(string s,int i,int j){
// // //         if( s1.substr(0,1))
        
// // //     }
    
// // //     string longestPalindrome(string s) {
// // //         vector<string> all;
// // //         int n=s.length();
// // //         for(int i=0;i<n;i++){
// // //             for(int j=i;j<n;j++){
// // //             ispalindrome(s.substr(i,j-i+1),all);
// // //             }
// // //         }
// // //         int maxi=0;
// // //         string sf="";
// // //         for(int i=0;i<all.size();i++){
// // //             if(all[i].length()>maxi){
// // //                 maxi= all[i].length();
// // //                 sf= all[i];
// // //             }
            
// // //         }
// // //     return sf;
// // //     }
// // // };