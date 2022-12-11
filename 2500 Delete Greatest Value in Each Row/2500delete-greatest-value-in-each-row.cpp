class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        int result = 0; // this variable will hold the result

        // check if the grid is empty
        if (grid.empty() || grid[0].empty()) return result;

        // sort the rows of the grid
        for (auto& row : grid) sort(row.begin(), row.end());

        // sort the columns of the grid
        for (int j = 0; j < grid[0].size(); j++) {
            vector<int> col;
            for (int i = 0; i < grid.size(); i++) col.push_back(grid[i][j]);
            sort(col.begin(), col.end());
            grid[0][j] = col[col.size()-1];
        }

        // compute the answer by adding the elements in the first row
        for (int j = 0; j < grid[0].size(); j++) result += grid[0][j];

        return result;
    }
};
