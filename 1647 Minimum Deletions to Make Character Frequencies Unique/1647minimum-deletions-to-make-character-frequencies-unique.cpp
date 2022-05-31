class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq(26);
        for(auto c: s){
            freq[c-'a']++;
        }
        sort(freq.begin(),freq.end(),greater<int>());
        
        int maxf= freq[0],val=0;
        // cout<<maxf;
        for(auto it: freq){
            if(it==0){
                break;
            }
            // if(maxf==0 && it>=maxf){
            //         val+=it;
            //     }
            // else{
            //     val+=it-maxf;
            //     maxf = min(maxf-1,it-1);
            // }
            if(it> maxf){
                if (maxf==0) val+=it;
                else val+=it-maxf,maxf--;
            }
            else{
                maxf=it-1;
            }
            // maxf = min(maxf-1,it-1);
            // cout<<" v is  "<<val<<" maxf is "<<maxf<<" it is "<<it<<endl;
        }
       return val; 
    }
};