class Solution {
    public: 
        int longestString(int x, int y, int z) {
            int mini = min(x, y);
            int extra = (x > y ? x-y : y-x) > 0 ? 1 : 0;
            int ans  = 2*(2*mini + extra + z);
            return ans;
        }
};