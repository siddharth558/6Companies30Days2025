public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SerializeBT {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] index = { 0 };
        return deserializeHelper(vals, index);
    }

    private TreeNode deserializeHelper(String[] vals, int[] index) {
        if (vals[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[index[0]++]));
        node.left = deserializeHelper(vals, index);
        node.right = deserializeHelper(vals, index);
        return node;
    }
}
