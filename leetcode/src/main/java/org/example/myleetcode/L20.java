package org.example.myleetcode;
import java.util.*;

/**
 * 括号匹配
 */
public class L20 {
    public static void main(String[] args) {
        L20 t = new L20();
        System.out.println(t.isValid("{[}]"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque=new LinkedList<>();

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '{', '[', '(':
                    stack.push(c);
                    break;
                case '}', ']', ')':
                    if (!stack.isEmpty()) {
                        Character peek = stack.peek();
                        boolean match = pairs.get(peek).equals(c);
                        if (match) {
                            stack.pop();
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
