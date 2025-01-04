class MincostToConvertStr {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] mat = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(mat[i], Long.MAX_VALUE);
            mat[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            mat[original[i] - 'a'][changed[i] - 'a'] = Math.min(mat[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (mat[i][via] == Long.MAX_VALUE || mat[via][j] == Long.MAX_VALUE)
                        continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        long total = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (mat[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Long.MAX_VALUE)
                    return -1;
                total += mat[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return total;
    }
}
/**
 * O(n)
 */