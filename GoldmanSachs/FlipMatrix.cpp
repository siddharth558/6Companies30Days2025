class Solution {
public:
    int mx = 0; 
    int r = 0; 
    int c = 0; 
    unordered_set<int> v;
    Solution(int m, int n) {
        mx = m*n;
        r = m; 
        c = n; 
    }
    
    vector<int> flip() {
        if(v.size() == mx)  return {};
        int r = rand() % mx; 
        while(v.count(r)){
            r = (r+1)%mx;
        }
        v.insert(r);
        return {r/c, r%c};
    }
    
    void reset() {
        v = {};
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(m, n);
 * vector<int> param_1 = obj->flip();
 * obj->reset();
 */