class Solution {
public:
    int mod = 1e9 + 7; 
    int dp[4002][1002];
    int solve(int start, int end, int k){
        if(k == 0){
            if(start == end)    return 1; 
            return 0; 
        }

        if(dp[start + 1000][k] != -1){
            return dp[start+1000][k];
        }
        int fwd = solve(start+1, end, k-1); 
        int bwd = solve(start-1, end, k-1);
        return dp[start+1000][k] = (fwd+bwd)%mod;
    } 
    int numberOfWays(int startPos, int endPos, int k) {
        if(abs(endPos - startPos) > k)  return 0; 
        memset(dp, -1, sizeof(dp));
        return solve(startPos, endPos, k);
    }
};