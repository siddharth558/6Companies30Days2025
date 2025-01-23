class Solution {
public:
    int maximizeSquareHoleArea(int n, int m, vector<int>& hBars, vector<int>& vBars) {
        int hlen = hBars.size(); 
        int vlen = vBars.size(); 

        sort(hBars.begin(), hBars.end()); 
        sort(vBars.begin(), vBars.end()); 

        int max_h = 1, max_v = 1, curr = 1; 

        for(int i = 1; i < hlen; i++){
            if(hBars[i] == hBars[i-1] + 1){
                curr++; 
            }else{
                curr = 1; 
            }
            max_h = max(max_h, curr); 
        }
        curr = 1; 
        for(int i = 1; i < vlen; i++){
            if(vBars[i] == vBars[i-1] + 1){
                curr++; 
            }else{
                curr = 1; 
            }
            max_v = max(max_v, curr); 
        }

        return min(max_h+1, max_v+1) * min(max_h+1, max_v+1);
        
    }
};