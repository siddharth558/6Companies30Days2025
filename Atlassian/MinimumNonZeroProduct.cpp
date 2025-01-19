typedef long long ll; 
class Solution {
ll M = 1000000007;
public:
    ll fast(ll a, ll b){
        ll p = 1; 
        a %= M; 

        while(b > 0){
            if(b & 1)   p *= a; 
            a *= a; 
            b = b >> 1; 
            p %= M; 
            a %= M; 
        }

        return p % M; 
    }
    int minNonZeroProduct(int p) {
        ll mx = (1L << p) - 1; 
        return fast(mx - 1, mx/2) % M * (mx % M) % M; 
    }
};