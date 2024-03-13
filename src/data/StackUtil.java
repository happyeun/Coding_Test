package data;
import java.util.Stack;

public class StackUtil {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(1);
        System.out.println(stack.toString());
        stack.push(2);
        System.out.println(stack.toString());
        stack.push(3);
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }
}