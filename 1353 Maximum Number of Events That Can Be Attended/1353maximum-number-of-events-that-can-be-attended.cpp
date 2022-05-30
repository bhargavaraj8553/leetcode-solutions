class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        sort(events.begin(),events.end());
        priority_queue <int , vector<int> , greater<int>> pq;
        int i=0,val=0,n=events.size(),d=0;
        while(i<n || pq.size()>0){
            if(pq.empty()){
            d=events[i][0];
            }
            while(i<events.size() && events[i][0]==d){
                pq.push(events[i][1]);
                i++;
            }
            pq.pop();
            val++,d++;
            while (pq.size() > 0 && pq.top() < d)
            {
                pq.pop();
            }            
        }
        return val;
    }
};