class Solution {
private: 
    vector<string> combine(string& letters, vector<string>& ansTillNow){
        vector<string> ans; 
        for(char ch : letters){
            for(auto& component : ansTillNow){
                ans.push_back(component + ch);
            }
        }

        return ans;
    }
public:
    vector<string> letterCombinations(string digits) {
        vector<string> letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> res; 
        if(digits.empty())  return res;
        res.push_back("");
        for(char digit : digits){
            res = combine(letters[digit - '0'], res);
        }

        return res;
    }
};