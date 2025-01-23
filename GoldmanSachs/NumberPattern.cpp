
class Solution {
public:
    string printMinNumberForPattern(string S) {
        string result;
        stack<int> st;

        int num = 1; // Start with 1
        for (char ch : S) {
            st.push(num++); // Push the current number into the stack
            if (ch == 'I') {
                // Pop all elements from the stack and add them to the result
                while (!st.empty()) {
                    result += to_string(st.top());
                    st.pop();
                }
            }
        }

        // Push the last number and process remaining elements
        st.push(num);
        while (!st.empty()) {
            result += to_string(st.top());
            st.pop();
        }

        return result;
    }
};