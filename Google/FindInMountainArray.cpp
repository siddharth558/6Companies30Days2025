/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */

class Solution {
public:
        int findInMountainArray(int target, MountainArray &mountainArr) {
            int start = 0; 
            int end = mountainArr.length() - 1; 
            int mid = start + (end - start)/2; 
            
            int peakIndex = 0; 
            
            while(start < end){
                int midVal1 = mountainArr.get(mid - 1);
                int midVal2 = mountainArr.get(mid);
                int midVal3 = mountainArr.get(mid + 1);
                
                if(midVal2 > midVal1 && midVal3 < midVal2){
                    peakIndex = mid; 
                    break; 
                }
                
                if(midVal2 < midVal3){
                    start = mid+1; 
                }else{
                    end = mid; 
                }
                mid = start + (end - start)/2; 
            }
            
            start = 0;
            end = peakIndex - 1;
            mid = start + (end - start) / 2;
            while (start <= end) {
                int midVal4 = mountainArr.get(mid);
                if (target == midVal4) {
                    return mid;
                }
                if (target < midVal4) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = start + (end - start) / 2;
            }
            
            end = mountainArr.length() - 1;
            start = peakIndex + 1;
            mid = start + (end - start) / 2;
            int midVal5 = mountainArr.get(peakIndex);
            while (end >= start) {
                int midVal6 = mountainArr.get(mid);
                if (target == midVal6) {
                    if (target == midVal5) {
                        return peakIndex;
                    } else {
                        return mid;
                    }
                }
                if (midVal6 < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                mid = start + (end - start) / 2;
            }
            if (target == midVal5) {
                return peakIndex;
            }

            return -1;
    }
};