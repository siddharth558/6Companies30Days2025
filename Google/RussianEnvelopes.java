package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianEnvelopes {
    public static boolean comp(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return a[1] > b[1];
        } else {
            return a[0] < b[0];
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return comp(a, b) ? -1 : 1;
            }
        });
        List<Integer> temp = new ArrayList<>();
        temp.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            if (temp.get(temp.size() - 1) < envelopes[i][1]) {
                temp.add(envelopes[i][1]);
            } else {
                int ind = Collections.binarySearch(temp, envelopes[i][1]);
                if (ind < 0)
                    ind = -(ind + 1);
                temp.set(ind, envelopes[i][1]);
            }
        }
        return temp.size();
    }
}
