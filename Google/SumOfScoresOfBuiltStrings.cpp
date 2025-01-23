class Solution {
public:
    vector<int> zMatch(string s){
        vector<int> z(s.size(), 0);
        int l = 0, r = 0;
        for(int i = 1; i < s.size(); i++){
            if(i < r){
                z[i] = min(z[i-l], r-i);
            }
            
            while(i + z[i] < s.size() && s[z[i]] == s[i+z[i]]) z[i]++;
            if(i + z[i] > r){
                l = i;
                r = i + z[i];
            }
        }
        return z;
    }

    long long sumScores(string s) {
        long long sum = 0;
        vector<int> ans = zMatch(s); 
        for(int i : ans){
            sum += i; 
        }
        return sum + s.size(); 
    }
};