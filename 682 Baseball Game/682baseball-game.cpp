class Solution {
public:
    int calPoints(vector<string>& ops) {
        vector<int> val;
        for(auto it: ops){
            // int sum=0;
            if(it=="C")
                val.pop_back();
            else if(it=="D"){
                int l= val[val.size()-1];
                val.push_back(2*l);
            }
            else if(it=="+"){
                int l=val.size()-1;
                int sum= val[l]+val[l-1];
                val.push_back(sum);
            }
            else val.push_back(stoi(it));
            // }
           
        }
        int value=0;
        for(auto i:val){
            value+=i;
        }
        return value;
    }
};