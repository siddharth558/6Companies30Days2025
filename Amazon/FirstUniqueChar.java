public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s.indexOf(ch) != -1 && s.lastIndexOf(ch) == s.indexOf(ch)) {
                ans = Math.min(ans, s.indexOf(ch));
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}
