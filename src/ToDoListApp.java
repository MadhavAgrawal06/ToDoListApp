import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Pending";
        return title + "  [" + status + "]";
    }
}

public class ToDoListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int choice;

        System.out.println("====================================");
        System.out.println("        TO-DO LIST APPLICATION      ");
        System.out.println("====================================");

        do {
            System.out.println("\n------------------------------------");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("------------------------------------");

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("Task added successfully!");
                }

                case 2 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available!");
                    } else {
                        System.out.println("\n************ YOUR TASKS ************");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        System.out.println("************************************");
                    }
                }

                case 3 -> {
                    System.out.print("Enter task number to mark completed: ");
                    int num = sc.nextInt();
                    if (num > 0 && num <= tasks.size()) {
                        tasks.get(num - 1).markCompleted();
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                }

                case 4 -> {
                    System.out.print("Enter task number to delete: ");
                    int num = sc.nextInt();
                    if (num > 0 && num <= tasks.size()) {
                        tasks.remove(num - 1);
                        System.out.println("Task deleted successfully!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                }

                case 5 -> {
                    System.out.println("Exiting the program...");
                    System.out.println("====================================");
                    System.out.println("   Thank you for using To-Do List!  ");
                    System.out.println("====================================");
                }

                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}
