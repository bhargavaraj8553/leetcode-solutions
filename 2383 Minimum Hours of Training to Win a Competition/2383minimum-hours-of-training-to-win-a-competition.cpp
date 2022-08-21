class Solution {
public:
    int minNumberOfHours(int initenergy, int initexp, vector<int>& energy, vector<int>& exp) {
        
        int n=exp.size(),m=energy.size();
        int count2=0,count1=0,sum=0;
        
        for(int i=0;i<m;i++){
           sum+=energy[i]; 
        }
        if(sum>=initenergy) count1= sum-initenergy+1;
        
        for(int i=0;i<n;i++){
            if(initexp<=exp[i]){
                count2+=exp[i]-initexp+1;
                initexp+=exp[i]-initexp+1;
            }
            initexp+=exp[i];
        }
        return count1+count2;
    }
};