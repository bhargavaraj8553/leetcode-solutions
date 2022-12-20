class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        unordered_set<int> visited;
        visited.insert(0);  // start from room 0
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int room = q.front();
            q.pop();
            for (int key : rooms[room]) {
                if (visited.count(key) == 0) {
                    visited.insert(key);
                    q.push(key);
                }
            }
        }
        return visited.size() == n;  // return true if all rooms have been visited
    }
};
