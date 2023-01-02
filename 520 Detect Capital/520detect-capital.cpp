class Solution {
public:
    bool detectCapitalUse(string word) {
        int n= word.size();
        for(int i=1;i<n;i++){
           if((65<=word[i] && word[i]<=90 )&& (97<=word[i-1] && word[i-1]<= 122)){
               return false;
           }
            if((i!=1 && 97<=word[i] && word[i]<= 122) && (65<=word[i-1] && word[i-1]<= 90)){
                return false;
            }
        }   
        return true;
    }
};