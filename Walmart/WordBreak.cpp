class Solution {
public:
    unordered_map<string, int> um;
    bool solve(string& s, int pos, vector<int>& dp){
        if(pos == s.size()) return true; 
        if(dp[pos] != -1) return    dp[pos];

        bool ans = false;
        string temp = "";
        for(int i = pos; i < s.size(); i++){
            temp += s[i];
            if(um.find(temp) != um.end()){
                ans |= solve(s, i+1, dp);
            }
        }
        return dp[pos] = ans; 
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        for(auto& w : wordDict){
            um[w]++;
        }
        vector<int> dp(s.size(), -1);
        return solve(s, 0, dp);
    }
};