class Solution {
public:
    int strStr(string haystack, string needle) {
        int len1= haystack.length(), len2 = needle.length();
        for (int i = 0; i < len1-len2+1; i++)
        {
            if(haystack.at(i)==needle[0]){
                if (needle == haystack.substr(i,len2)){
                    return i;
                }
            }
        }
        return -1;
    }
};