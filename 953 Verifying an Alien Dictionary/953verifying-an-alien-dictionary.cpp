class Solution {
public:
    unordered_map<char , int> val;
    // bool comparewords(string a,string b){
    //     // if(a==b) return true;
    //     for(int i=0;i<min(a.length(),b.length());i++){
    //         if ((val[a[i]]) != (val[b[i]])){
    //             return ((val[a[i]]) < (val[b[i]]));
    //         }
    //     }
    //     if(b.length()>=a.length()){
    //         return true;
    //     }
    //     return true;
    //     // return false;
    // }
    bool isAlienSorted(vector<string>& words, string order) {
        // map<string , int> val;
        int n=order.size();
        for(int i=0;i<n;i++){
            val[order[i]]=i;
        }
        for(int j=1;j<words.size();j++){
            if(comparewords(words[j-1],words[j]) == false){
                return false;
            }
        }
        return true;
    }
    
    bool comparewords(string& a,string& b){
        // if(a==b) return true;
        for(int i=0;i<min(a.length(),b.length());i++){
            if ((val[a[i]]) != (val[b[i]])){
                return val[a[i]] < val[b[i]];
            }
        }
        // if(b.length()>=a.length()){
        //     return true;
        // }
        return b.length()>=a.length();
        // return false;
    }
};