package Walmart;

import java.util.Stack;

public class VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack();
        String[] arr = preorder.split(",");
        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i];
            if (stk.isEmpty() || !curr.equals("#")) {
                stk.push(curr);
            } else {
                while (!stk.isEmpty() && stk.peek().equals("#")) {
                    stk.pop();
                    if (!stk.isEmpty())
                        stk.pop();
                    else
                        return false;
                }
                stk.push("#");
            }
        }

        return stk.size() == 1 && stk.peek().equals("#");
    }
}
