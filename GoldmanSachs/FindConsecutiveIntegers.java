package GoldmanSachs;

public class FindConsecutiveIntegers {
    class DataStream {
        int count;
        int value;
        int k;

        public DataStream(int value, int k) {
            this.k = k;
            this.value = value;
            this.count = 0;
        }

        public boolean consec(int num) {
            count = (num == value) ? count + 1 : 0;
            return count >= k;
        }
    }

    /**
     * Your DataStream object will be instantiated and called as such:
     * DataStream obj = new DataStream(value, k);
     * boolean param_1 = obj.consec(num);
     */
}
