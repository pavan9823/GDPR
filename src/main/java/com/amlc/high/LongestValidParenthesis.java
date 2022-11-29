package com.amlc.high;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.empty()) {
                    st.push(i);
                } else {
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((()()"));
    }
}
