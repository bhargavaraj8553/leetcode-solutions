//final solution
class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int n=colors.length(),val=0,j=0,i=1;
        while(i<n){
            if(colors[i]==colors[j]){
                if(neededTime[i]<neededTime[j]){
                    val+=neededTime[i];
                    i++;
                }
                else{
                    val+=neededTime[j];
                    
                    i++;
                    j=i-1;
                }
            }
            else{
                i++;
                j=i-1;
            }
        }
        return val;
    }
};