//old question
// it should be learned that max heap is same as priority queue.
// and map can be easily used to store freqencies
// also if we want to store in particular sorted order then use priority queue

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int finalval=0;
        map<char,int> mp;
        for(auto it:tasks) mp[it]++;
        

        priority_queue<int> pq;
        for(auto v: mp) pq.push(v.second);
        

        while(!pq.empty()){
            int time=0;
            vector<int> temp;
            for (int i = 0; i <=  n; i++)
            {
                if(!pq.empty()){
                temp.push_back(pq.top()-1);
                pq.pop();
                time++;
                }
                
            }
            for(auto a:temp){
                if(a) pq.push(a);
            }
            // finalval+= pq.empty() ?time :n+1;
            if(pq.empty()){
                finalval+=time;
            }
            else{
                finalval+=n+1;
            }
        }
        
return finalval;
    }
};