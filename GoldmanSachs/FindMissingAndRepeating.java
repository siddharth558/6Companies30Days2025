package GoldmanSachs;

import java.util.ArrayList;

class FindMissingAndRepeating {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        int rep = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (freq[i] >= 2)
                rep = i;
            else if (freq[i] == 0)
                missing = i;
        }

        res.add(rep);
        res.add(missing);
        return res;
    }
}