
class Solution {
  public:
    string encode(string s) {
        stack<char> stk;
        string ans; 
        for(char ch : s){
            if(stk.empty() || stk.top() == ch){
                stk.push(ch);
            }
            else{
                char currch = stk.top();
                int cnt = 0;
                while (!stk.empty()) {
                    stk.pop();
                    cnt++;
                }
                ans += currch + to_string(cnt);
                stk.push(ch);
            }
        }
        
        if (!stk.empty()) {
            char currch = stk.top();
            int cnt = 0;
            while (!stk.empty() && stk.top() == currch) {
                stk.pop();
                cnt++;
            }
            ans += currch + to_string(cnt);
        }
        return ans;
    }
};