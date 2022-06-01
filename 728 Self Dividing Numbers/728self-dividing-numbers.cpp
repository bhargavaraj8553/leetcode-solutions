class Solution {
    private:
        bool selfdivnumber(int n){
            int num=n,l;
        while(n){
            l= n%10;
            if(l==0 || num%l!=0)
                return false;
            n=n/10;
        }
            return true;
    }
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> finalval;
        int i=left;
        while(i<=right){
            if(selfdivnumber(i)==true){
                finalval.push_back(i);
            }
            i++;
        }
        return finalval;
    }
};