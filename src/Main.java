import service.TodoList;
import util.ConsoleColor;
import util.Messages;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println(ConsoleColor.CYAN + Messages.MENU + ConsoleColor.RESET);
            System.out.print(Messages.INPUT_PROMPT);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 클리어

                switch (choice) {
                    case 1:
                        System.out.print(Messages.ENTER_TASK);
                        String task = scanner.nextLine();
                        todoList.addTask(task);
                        break;

                    case 2:
                        System.out.print(Messages.ENTER_TASK);
                        String taskWithDeadline = scanner.nextLine();
                        System.out.print(Messages.ENTER_DUE_DATE);
                        String dueDate = scanner.nextLine();
                        todoList.addTaskWithDeadline(taskWithDeadline, dueDate);
                        break;

                    case 3:
                        todoList.showTasks();
                        break;

                    case 4:
                        System.out.print(Messages.ENTER_COMPLETE_ID);
                        int doneId = scanner.nextInt();
                        scanner.nextLine();
                        todoList.markTaskDone(doneId);
                        break;

                    case 5:
                        System.out.print(Messages.ENTER_DELETE_ID);
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        todoList.deleteTask(deleteId);
                        break;

                    case 6:
                        System.out.println(ConsoleColor.YELLOW + Messages.EXIT_PROGRAM + ConsoleColor.RESET);
                        scanner.close();
                        return;

                    default:
                        System.out.println(ConsoleColor.RED + Messages.INVALID_INPUT + ConsoleColor.RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColor.RED + Messages.INVALID_INPUT + ConsoleColor.RESET);
                scanner.nextLine(); // 잘못된 입력 버퍼 클리어
            }
        }
    }
}