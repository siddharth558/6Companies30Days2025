class Solution {
public:
    void dfs(vector<vector<int>>& grid, int i, int j, vector<vector<int>>& visited){
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || visited[i][j] == 1 || grid[i][j] == 0){
            return; 
        }

        visited[i][j] = 1; 
        dfs(grid, i+1, j, visited); 
        dfs(grid, i-1, j, visited); 
        dfs(grid, i, j+1, visited); 
        dfs(grid, i, j-1, visited);
    }
    int islandCount(vector<vector<int>>& grid){
        int m = grid.size(); 
        int n = grid[0].size(); 

        vector<vector<int>> visited(m, vector<int>(n, 0));
        int islands = 0; 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands; 
    }
    int minDays(vector<vector<int>>& grid) {
        int islands = islandCount(grid); 
        if(islands > 1 || islands == 0) return 0;
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0; 
                    islands = islandCount(grid);
                    if(islands > 1 || islands == 0){
                        return 1;
                    }
                    grid[i][j] = 1; 
                }
            }
        }

        return 2; 
    }
};