import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // Valid Lisp Code
        String line1 = "((()))";
        String line2 = "({()})";
        String line3 = "({()}[])";
        String line4 = "" +
                "(defclass book ()\n" +
                "  ((title :reader book-title\n" +
                "          :initarg :title)\n" +
                "   (author :reader book-author\n" +
                "           :initarg :author))\n" +
                "  (:documentation \"Describes a book.\"))\n" +
                "\n" +
                "(make-instance 'book\n" +
                "               :title \"ANSI Common Lisp\"\n" +
                "               :author \"Paul Graham\")";

        // Invalid Lisp code
        String line5 = "((())";
        String line6 = "({]}{{}[]}}[}))))";
        String line7 = "" +
                "(defun f ()\n" +
                "  (let ((x 1)\n" +
                "        ((y 2))\n" +
                "    (format t \"X=~A, Y=~A\" x y)\n" +
                "    (terpri)((]}\n" +
                "    t))";
        String line8 = "";
        String line9 = "vnbokuewnz.ewnofi;ewouibxwe";


        // Create a list of all the strings to be checked
        ArrayList<String> lines = new ArrayList<String>();
        lines.addAll(List.of(line1, line2, line3, line4, line5, line6, line7, line8, line9));

        // Check each string and log the errors
        for (String line : lines) {
            if (!isLispValid(line)) {
                LOGGER.severe("Invalid Lisp code: \n" + line);
            }
        }

    }

    public static boolean isLispValid(String input) {
        // Handle edge case where input is null or empty
        if (input == null || input.isEmpty()) {
            LOGGER.info("Input is null or empty");
            return false;
        }

        // Create a stack to store the parentheses
        Stack<Character> stack = new Stack<Character>();

        // Iterate through the input string
        for (Character c : input.toCharArray()) {
            // Use a switch statement to check if the character is a left parenthesis
            switch (c) {
                case '(':
                case '[':
                case '{':
                    // Push the character to the stack
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        LOGGER.info("Stack is empty");
                        return false;
                    }
                    if (c == ')' && stack.peek() != '(') {
                        return false;
                    }
                    if (c == '}' && stack.peek() != '{') {
                        return false;
                    }
                    if (c == ']' && stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();

                default:
                    break;

            }
        }

        return stack.isEmpty();
    }

}