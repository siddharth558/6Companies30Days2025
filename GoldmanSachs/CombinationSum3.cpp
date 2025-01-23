class Solution {
public:
    void helper(int idx, vector<int> &nums, int k, int n, vector<vector<int>> &ans, vector<int> &subset){
        if(subset.size() == k && n == 0){
            ans.push_back(subset); 
            return;
        }
        if(idx >= nums.size() || n < 0) return;
        subset.push_back(nums[idx]);
        helper(idx+1, nums, k, n-nums[idx], ans, subset);
        subset.pop_back(); 

        helper(idx+1, nums, k, n, ans, subset);
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans; 
        vector<int> subset; 
        vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        helper(0, nums, k, n, ans, subset);
        return ans;
    }
};