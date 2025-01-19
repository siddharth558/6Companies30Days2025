class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        int n = nums.size(); 
        int qlen = queries.size(); 
        vector<int> ans;
        
        for(auto& x : queries){
            priority_queue<pair<string, int>> pq;
            for(int i = 0; i < nums.size(); i++){
                int temp = nums[i].size() - x[1];
                string str = nums[i].substr(temp, x[1]);
                if(pq.size() < x[0])    pq.push({str, i});
                else{
                    if(pq.top().first > str){
                        pq.pop(); 
                        pq.push({str, i});
                    }
                }
            }
            ans.push_back(pq.top().second);
        }
        
        return ans;
    }
};