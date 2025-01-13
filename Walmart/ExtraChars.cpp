class Solution {
public:
    unordered_map<string, int> um; 
    unordered_map<int, int> memo; 
    int solve(string& s, int pos){
        if(pos >= s.size()){
            return 0; 
        }
        if(memo.find(pos) != memo.end()){
            return memo[pos];
        }
        int extra = INT_MAX; 
        string temp = "";

        for(int i = pos; i < s.size(); i++){
            temp += s[i];
            if(um.find(temp) != um.end()){
                extra = min(extra, solve(s, i+1));
            }
        }

        extra = min(extra, 1 + solve(s, pos+1));
        memo[pos] = extra;
        return extra; 
    }
    int minExtraChar(string s, vector<string>& dictionary) {
        for(auto& val : dictionary){
            um[val]++; 
        }

        return solve(s, 0);
    }
};