
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagementSystem {

    static class Task {
        int id;
        String title;
        String priority;
        String status;

        Task(int id, String title, String priority) {
            this.id = id;
            this.title = title;
            this.priority = priority;
            this.status = "PENDING";
        }

        void display() {
            System.out.println(
                "ID: " + id +
                " | Title: " + title +
                " | Priority: " + priority +
                " | Status: " + status
            );
        }
    }

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    static Task findTask(int id) {
        for (Task task : tasks) {
            if (task.id == id) {
                return task;
            }
        }
        return null;
    }

    static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter priority (LOW/MEDIUM/HIGH): ");
        String priority = sc.nextLine().trim().toUpperCase();

        if (!priority.equals("LOW") &&
            !priority.equals("MEDIUM") &&
            !priority.equals("HIGH")) {
            System.out.println("Invalid priority.");
            return;
        }

        tasks.add(new Task(nextId++, title, priority));
        System.out.println("Task added successfully.");
    }

    static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks) {
            task.display();
        }
    }

    static void updateTask() {
        System.out.print("Enter task ID: ");
        int id = readId();

        if (id == -1) return;

        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter new title: ");
        String title = sc.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        task.title = title;
        System.out.println("Task updated successfully.");
    }

    static void completeTask() {
        System.out.print("Enter task ID: ");
        int id = readId();

        if (id == -1) return;

        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        task.status = "COMPLETED";
        System.out.println("Task completed successfully.");
    }

    static void deleteTask() {
        System.out.print("Enter task ID: ");
        int id = readId();

        if (id == -1) return;

        Task task = findTask(id);

        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        tasks.remove(task);
        System.out.println("Task deleted successfully.");
    }

    static void searchByStatus() {
        System.out.print("Enter status (PENDING/COMPLETED): ");
        String status = sc.nextLine().trim().toUpperCase();

        if (!status.equals("PENDING") &&
            !status.equals("COMPLETED")) {
            System.out.println("Invalid status.");
            return;
        }

        boolean found = false;

        for (Task task : tasks) {
            if (task.status.equals(status)) {
                task.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }

    static int readId() {
        try {
            int id = Integer.parseInt(sc.nextLine().trim());

            if (id <= 0) {
                System.out.println("ID must be positive.");
                return -1;
            }

            return id;
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Enter a number.");
            return -1;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Complete Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Search by Status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": addTask(); break;
                case "2": listTasks(); break;
                case "3": updateTask(); break;
                case "4": completeTask(); break;
                case "5": deleteTask(); break;
                case "6": searchByStatus(); break;
                case "7":
                    System.out.println("Exiting application.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
