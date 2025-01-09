import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPoint {
    private List<int[]> rects;
    private List<Integer> v;

    public Solution(int[][] rects) {
        this.rects = new ArrayList<>(); 
        this.v = new ArrayList<>();   

        int points = 0; 
        for(int r[] : rects){
            points += countPoints(r);
            this.rects.add(r);  
            v.add(points); 
        }  
    }

    public int countPoints(int r[]) {
        return (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
    }

    public int binarySearch(int point) {
        int l = 0, h = v.size() - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (v.get(mid) <= point) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return l;
    }

    public int[] pick() {
        int point = new Random().nextInt(v.get(v.size() - 1));
        int idx = binarySearch(point);
        int r[] = rects.get(idx);

        int x = new Random().nextInt(r[2] - r[0] + 1) + r[0];
        int y = new Random().nextInt(r[3] - r[1] + 1) + r[1];

        return new int[] { x, y };
    }
}
