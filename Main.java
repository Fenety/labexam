import java.util.Scanner;

class ToDoTask {
    private String title;
    private String description;
    private boolean completed;

    public ToDoTask(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    private ToDoTask task;
    private Node next;

    public Node(ToDoTask task) {
        this.task = task;
        this.next = null;
    }

    public ToDoTask getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(ToDoTask task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext()!= null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markTaskAsCompleted(String title) {
        Node current = head;
        while (current!= null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                break;
            }
            current = current.getNext();
        }
    }

    public void viewToDoList() {
        if (head == null) {
            System.out.println("No tasks in the to-do list.");
            return;
        }
        System.out.println("To-Do List:");
        System.out.println("Task No. | Title | Description | Completed");
        int taskNo = 1;
        Node current = head;
        while (current!= null) {
            System.out.printf("%d | %s | %s | %s%n", taskNo, current.getTask().getTitle(), current.getTask().getDescription(), current.getTask().isCompleted()? "Yes" : "No");
            current = current.getNext();
            taskNo++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a task");
            System.out.println("2. View to-do list");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    ToDoTask task = new ToDoTask(title, description);
                    todoList.addTask(task);
                    break;
                case 2:
                    todoList.viewToDoList();
                    break;
                case 3:
                    System.out.print("Enter task title to mark as completed: ");
                    String markTitle = scanner.nextLine();
                    todoList.markTaskAsCompleted(markTitle);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}