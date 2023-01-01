class Solution {
public:
//     "abba"
// "dog dog dog dog"
    bool wordPattern(string pt, string s) {
        
        int n= pt.length(),i=0,j=0,cnt=0;
        map<char,string>mp;
        map<string,char>mp2;
        for(int i=0;i<n;i++){
            string t;
            while(j<s.size()){
                if(s[j]==' ' or j==s.size()){
                    cnt++;
                    j++;
                    break;
                }
                t+=s[j];
                j++;
            }
            // cout<<t<<"\n";
            if(mp.find(pt[i])!=mp.end() and mp[pt[i]]!=t)
                return false;
            if(mp2.find(t)!=mp2.end() and mp2[t]!=pt[i])
                return false;
            
            mp[pt[i]]=t;
            mp2[t]=pt[i];
        }
        // cout<<cnt;/
        if(cnt+1!=n)
            return false;
        return true;
    }
};