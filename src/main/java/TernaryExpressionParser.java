import java.util.ArrayDeque;
import java.util.Deque;

public class TernaryExpressionParser {

    public static void main(String[] args) {
        System.out.println(ternaryExpressionParser("T?2:3"));
        System.out.println(ternaryExpressionParser("F?1:T?4:5"));
        System.out.println(ternaryExpressionParser("T?T?F:5:3"));
        System.out.println(ternaryExpressionParser("T?T?T?T?T?F:5:5:T?F:T?2:5:5:3"));
    }

    private static char ternaryExpressionParser(String expression) {
        return iterative(expression);
        // return recursive(expression, new Iterator());
    }

    private static char iterative(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = expression.length() - 1; 0 <= i; i--) {
            if (!stack.isEmpty() && stack.peek() == '?') {
                char condition = expression.charAt(i);

                // skip ?
                stack.pop();

                char left = stack.pop();

                // skip :
                stack.pop();

                char right = stack.pop();

                if (condition == 'T') stack.push(left);
                else stack.push(right);
            } else stack.push(expression.charAt(i));
        }

        return stack.pop();
    }

    private static char recursive(String expression, Iterator iterator) {
        char condition = expression.charAt(iterator.get());

        // increment ?
        iterator.increment(2);

        char branch1 = expression.charAt(iterator.get());

        // check if branch 1 is an expression
        if (expression.charAt(iterator.get() + 1) == '?') {
            branch1 = recursive(expression, iterator);
        }

        // increment :
        iterator.increment(2);

        char branch2 = expression.charAt(iterator.get());

        // check if branch 2 is an expression
        if (iterator.get() + 1 < expression.length() && expression.charAt(iterator.get() + 1) == '?') {
            branch2 = recursive(expression, iterator);
        }

        return (condition == 'T') ? branch1 : branch2;
    }

    static class Iterator {

        int index;

        void increment(int step) {
            index += step;
        }

        int get() {
            return index;
        }
    }
}
