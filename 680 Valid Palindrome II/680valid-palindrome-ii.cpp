class Solution {
    private: bool checkPalindrome(string s, int i, int j){
        while(i<j){
        if(s[i++]!=s[j--]){
            return false;
        }
        }
        return true;
    }
public:
    bool validPalindrome(string s) {
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s[i]!=s[j]){
            return checkPalindrome(s, i+1,j) || checkPalindrome(s,i,j-1);
        }       
            i++;
            j--;
        }
        return true;          
            }
};
                // cout<<s[i]<<" ith "<<s[j]<<" jth "<<s[i+1]<<"  "<<s[j-1]<<endl;
            // if(count>=1){
            //     return false;
            // }
            // if (s[i+1]==s[j] && s[i]==s[j-1]){
            //     // if(s[i+2]==s[j-1]){
            //     //     i++;
            //     // }
            //     // else{
            //     // j--;
            //     // }
            // if 
            //     // count++;
            // }
            // else if(s[i+1]==s[j]){
            //      i++; 
            //     // s.erase(s.begin()+i);
            //     count++;
            // }
            // else if (s[i]==s[j-1]){
            //     j--;
            //     // s.erase(s.begin()+j);
            //     count++;
            // }
            // else{
            // return false;
            // }
            // }
        //     i++;
        //     j--;
        // }
        // cout<<s<<endl;
        // return true;
//     }
// };