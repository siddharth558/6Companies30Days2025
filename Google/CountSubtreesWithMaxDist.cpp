class Solution {
public:
    int solve(int mask, vector<vector<int>>& dist, int n){
        int node = 0; 
        int edge = 0; 
        int maxi = 0; 

        for(int i = 0; i < n; i++){
            if((mask>>i) & 1){
                node++; 
                for(int j = i+1; j < n; j++){
                    if((mask >> j)&1 == 1){
                        if(dist[i][j] == 1) edge++;
                        maxi = max(maxi, dist[i][j]);
                    }
                }
            }
        }
        if(node == edge+1)  return maxi; 
        else return -1;
    }

    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        vector<int> a(n-1, 0);
        vector<vector<int>> dist(15, vector<int>(15, INT_MAX)); 
        
        for(auto i : edges){
            dist[i[0]-1][i[1]-1] = dist[i[1]-1][i[0]-1] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(dist[j][i] != IN_MAX and dist[i][k] != INT_MAX){
                        dist[j][k] = dist[k][j] = min(dist[j][k], dist[j][i] + dist[i][k]); 
                    }
                }
            }
        }

        for(int i = 0; i < (1<<n); i++){
           int ans = solve(i , dist , n); 
           if(ans > 0)  a[ans-1]++; 
        }

        return a; 
    }
};