package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class EmployeePriority {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> ans = new ArrayList<>();

        access_times.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0).compareTo(b.get(0));
            }

            return Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
        });

        for (int i = 0; i + 2 < access_times.size(); i++) {
            String name = access_times.get(i).get(0);
            if (ans.contains(name))
                continue;

            if (!name.equals(access_times.get(i + 2).get(0))) {
                continue;
            }

            int time1 = Integer.parseInt(access_times.get(i).get(1));
            int time2 = Integer.parseInt(access_times.get(i + 2).get(1));
            if (time2 - time1 < 100) {
                ans.add(name);
            }
        }

        return ans;
    }
}
