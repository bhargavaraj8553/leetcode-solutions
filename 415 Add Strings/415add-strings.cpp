class Solution {
public:
    string addStrings(string num1, string num2){
        int len1= num1.length();
        int len2 = num2.length();
        // int len3= max(len1,len2);
        int sum=0;
        int i=len1-1,j=len2-1;
        
        
        string num3;
        while(i>=0 &&j>=0){
            sum+=(num1[i--]-'0')+(num2[j--]-'0');
            // carry--;
            // (num3[k]-'0')=(num3[k]-'0')%10;
            
            num3.push_back((sum%10+'0'));
            
            // if(((num3[k]-'0')/10)==1 ){
            //     carry++;
            // }
            sum= sum/10;
            // k--;
        }
        while(i>=0){
            // (num3[k--]-'0')=(num2[i--]-'0');
            sum+=(num1[i--]-'0');
            num3.push_back((sum%10+'0'));
            sum=sum/10;
        }
        
        while(j>=0){
            // (num3[k--]-'0')=(num2[j--]-'0');
            sum+=(num2[j--]-'0');
            num3.push_back((sum%10+'0'));
            sum=sum/10;
        }
        // while(i>=0){
        //     // (num3[k--]-'0')=(num2[i--]-'0');
        //     sum+=(num2[i--]-'0');
        //     num3.push_back(char(sum%10+'0'));
        //     sum=sum/10;
        // }
        if (sum>0){
            num3.push_back((sum%10+'0'));
        }
        // string s4;
        // for(auto it= num3.rbegin();it!=num3.rend();it++){
        //     s4.push_back(*it);
        // }
        reverse(num3.begin(),num3.end());
        return num3;
        // return s4;
    }
};