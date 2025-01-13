class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n = s.size();
        vector<int> diff(s.size());
        for(int i=0;i<n;i++){
            diff[i] = abs(s[i] - t[i]);

        }
      
        int i=0;
        int j=0;
        int sum = 0;
        int maxlen = 0;
        while(i<n && j<n){
                sum += diff[j];
                if(sum <= maxCost){
                    maxlen = max(maxlen, j - i + 1);
                }
                while(sum > maxCost){
                    sum -= diff[i]; 
                    i++; 
                }
                j++;
        }
        return maxlen;
    }
};