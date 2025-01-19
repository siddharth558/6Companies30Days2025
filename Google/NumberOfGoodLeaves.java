package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfGoodLeaves {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafnodes = new HashSet<>();

        buildGraph(root, null, graph, leafnodes);
        int ans = 0;

        for (TreeNode leaf : leafnodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            queue.add(leaf);
            seen.add(leaf);

            for (int i = 0; i <= distance; i++) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    TreeNode curr = queue.poll();
                    if (leafnodes.contains(curr) && curr != leaf) {
                        ans++;
                    }
                    if (graph.containsKey(curr)) {
                        for (TreeNode neighbor : graph.get(curr)) {
                            if (!seen.contains(neighbor)) {
                                queue.add(neighbor);
                                seen.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return ans / 2;

    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph,
            Set<TreeNode> leafnodes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafnodes.add(node);
        }

        if (parent != null) {
            graph.putIfAbsent(parent, new ArrayList<TreeNode>());
            graph.get(parent).add(node);
            graph.putIfAbsent(node, new ArrayList<TreeNode>());
            graph.get(node).add(parent);
        }

        buildGraph(node.left, node, graph, leafnodes);
        buildGraph(node.right, node, graph, leafnodes);
    }
}
