class Solution {
public:
    vector<vector<int>> rowsarr;
    void func(vector<int> &prev,int numRows){
        if(prev.size()==numRows) return;
        int n=prev.size();
        vector<int> temp(n+1,1);
        // temp[0]=1;temp[n]=1;
        for(int i=1;i<n;i++){
            temp[i]=prev[i-1]+prev[i];
        }
        rowsarr.push_back(temp);
        prev=temp;
        func(temp,numRows);
    }
    
    vector<vector<int>> generate(int numRows) {
        vector<int> a;
        a.push_back(1);
        rowsarr.push_back(a);
        func(a,numRows);
        return rowsarr;
    }
};