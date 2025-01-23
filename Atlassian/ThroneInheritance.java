package Atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Boolean> alive = new HashMap<>();
    String kingName;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, k -> new ArrayList<>());
        map.get(parentName).add(childName);
    }

    public void death(String name) {
        alive.put(name, false);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = getList(kingName);
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (alive.getOrDefault(s, true))
                res.add(s);
        }
        return res;
    }

    private List<String> getList(String p) {
        List<String> res = new ArrayList<>();
        res.add(p);
        List<String> cs = map.getOrDefault(p, new ArrayList<>());
        for (String c : cs) {
            List<String> tmp = getList(c);
            for (String cc : tmp)
                res.add(cc);
        }
        return res;
    }
}
