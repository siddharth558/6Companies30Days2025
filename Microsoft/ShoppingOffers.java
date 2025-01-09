import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    public int solve(int i, List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<String, Integer> memo) {

        StringBuilder sb = new StringBuilder();
        sb.append(i).append("-");
        for (int e : needs)
            sb.append(e).append(",");
        String key = sb.toString();

        if (memo.containsKey(key))
            return memo.get(key);

        if (i == special.size()) {
            int cost = 0;
            for (int j = 0; j < needs.size(); j++) {
                cost += price.get(j) * needs.get(j);
            }
            memo.put(key, cost);
            return cost;
        }

        int skip = solve(i + 1, price, special, needs, memo);
        boolean canTake = true;
        int take = Integer.MAX_VALUE;

        for (int j = 0; j < needs.size(); j++) {
            if (needs.get(j) < special.get(i).get(j)) {
                canTake = false;
                break;
            }
        }

        if (canTake) {
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) - special.get(i).get(j));
            }
            take = special.get(i).get(needs.size()) + solve(i, price, special, needs, memo);
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + special.get(i).get(j));
            }
        }

        int result = Math.min(take, skip);
        memo.put(key, result);
        return result;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(0, price, special, needs, memo);
    }
}
