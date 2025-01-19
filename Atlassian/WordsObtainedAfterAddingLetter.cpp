
class Solution {
public:
    int getBitMask(string& s){
        int bitmask = 0; 
        
        for(char ch : s){
            bitmask |= (1 << (ch - 'a'));
        }
        return bitmask; 
    }
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        unordered_set<int> startmasks; 
        for(string& s : startWords){
            startmasks.insert(getBitMask(s));
        }
        int count = 0; 
        for(string& temp : targetWords){
            int targetmask = getBitMask(temp); 
            bool possible = false;
            
            for(char ch : temp){
                int modifiedTarget = targetmask & ~(1 << (ch - 'a'));
                if(startmasks.count(modifiedTarget)){
                    possible = true; 
                    break;
                }
            }
            if(possible)    count++;
        }
        
        return count;
        
    }
};