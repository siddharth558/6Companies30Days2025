package Walmart;

import java.util.Arrays;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int requestCount = 0;

        for (int i = 0; i < ages.length; i++) {
            int minIndex = findLowerBound(ages, 0.5 * ages[i] + 7);
            int maxIndex = findLowerBound(ages, ages[i]);

            if (maxIndex > minIndex) {
                requestCount += maxIndex - minIndex - 1;
            }
        }

        return requestCount;
    }

    private int findLowerBound(int[] ages, double threshold) {
        int left = 0, right = ages.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
