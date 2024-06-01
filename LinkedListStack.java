class LinkedListStack {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public void insertAtPos(int data, int pos) {
            Node newNode = new Node(data);
            if (pos == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = head;
                for (int i = 1; i < pos && temp!= null; i++) {
                    temp = temp.next;
                }
                if (temp!= null) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
            }
        }


        public void deleteAtPosition(int pos) {
            if (head == null) return;
            if (pos == 0) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 1; temp!= null && i < pos; i++) {
                temp = temp.next;
            }
            if (temp!= null && temp.next!= null) {
                temp.next = temp.next.next;
            }
        }
        public void deleteAfterNode(Node node) {
            if (node == null || node.next == null) return;
            node.next = node.next.next;
        }
        public Node searchNode(int value) {
            Node temp = head;
            while (temp!= null) {
                if (temp.data == value) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }


        public void display() {
            Node temp = head;
            while (temp!= null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }


    static class Stack {
        LinkedList list = new LinkedList();


        public void push(int data) {
            list.insertAtPos(data, 0);
        }
        public int pop() {
            if (!isEmpty()) {
                int data = list.head.data;
                list.deleteAtPosition(0);
                return data;
            }
            return Integer.MIN_VALUE;
        }

        public int peek() {
            if (!isEmpty()) {
                return list.head.data;
            }
            return Integer.MIN_VALUE;
        }

        public boolean isEmpty() {
            return list.head == null;
        }
    }

    public static void main(String[] args) {
        Stack stack = new LinkedListStack.Stack();

        // Example usage
        stack.push( 1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Popped Item: " + stack.pop());
        System.out.println("Stack Peek: " + stack.peek());

    }
}
