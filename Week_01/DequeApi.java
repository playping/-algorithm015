package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DequeApi {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addLast("e");
        deque.addLast("f");
        deque.addLast("g");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);


    }
}
