package queue;
import java.util.Stack;
public class queue {
    

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("abebe");
        queue.enqueue("kebede");
        queue.enqueue("fromsis");
        queue.enqueue("feven");
        queue.enqueue("beti");

        System.out.println("First element: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("First element: " + queue.peek());
    }
}

class MyQueue<T> {
    private Stack<T> stackNewestOnTop = new Stack<>();
    private Stack<T> stackOldestOnTop = new Stack<>();

    public void enqueue(T value) {
        stackNewestOnTop.push(value);
    }

    public T dequeue() {
        shiftStacks();
        return stackOldestOnTop.pop();
    }

    public T peek() {
        shiftStacks();
        return stackOldestOnTop.peek();
    }

    private void shiftStacks() {
        if (stackOldestOnTop.isEmpty()) {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }
}

