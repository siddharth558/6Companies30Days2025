package Atlassian;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndices {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int alen = a.length();
        int blen = b.length();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();

        List<Integer> aIndices = new ArrayList<>();
        for (int i = 0; i <= n - alen; i++) {
            if (s.substring(i, i + alen).equals(a)) {
                aIndices.add(i);
            }
        }

        List<Integer> bIndices = new ArrayList<>();
        for (int i = 0; i <= n - blen; i++) {
            if (s.substring(i, i + blen).equals(b)) {
                bIndices.add(i);
            }
        }

        for (int i : aIndices) {
            for (int j : bIndices) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }
}
