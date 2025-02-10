package service;

import model.DeadlineTodoItem;
import model.TodoItem;
import util.ConsoleColor;
import util.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// 할 일 목록 관리
public class TodoList {
    private final ArrayList<TodoItem> todoItems;
    private int counter;

    public TodoList() {
        this.todoItems = new ArrayList<>();
        this.counter = 1;
    }

    public void addTask(String task) {
        todoItems.add(new TodoItem(counter++, task));
        System.out.println(ConsoleColor.GREEN + Messages.TASK_ADDED + task + ConsoleColor.RESET);
    }

    public void addTaskWithDeadline(String task, String dueDate) {
        if (!isValidDateFormat(dueDate)) {
            System.out.println(ConsoleColor.RED + Messages.INVALID_DATE + ConsoleColor.RESET);
            return;
        }
        todoItems.add(new DeadlineTodoItem(counter++, task, dueDate));
        System.out.println(ConsoleColor.GREEN + Messages.TASK_ADDED_DEADLINE + task + " (마감일: " + dueDate + ")" + ConsoleColor.RESET);
    }

    public void showTasks() {
        if (todoItems.isEmpty()) {
            System.out.println(ConsoleColor.RED + Messages.NO_TASKS + ConsoleColor.RESET);
        } else {
            System.out.println(ConsoleColor.CYAN + Messages.TASK_LIST_HEADER + ConsoleColor.RESET);
            for (TodoItem item : todoItems) {
                System.out.println(item);
            }
            System.out.println(Messages.TASK_LIST_FOOTER);
        }
    }

    public void markTaskDone(int taskId) {
        for (TodoItem item : todoItems) {
            if (item.getId() == taskId) {
                item.markDone();
                System.out.println(ConsoleColor.GREEN + Messages.TASK_COMPLETED + item.getTask() + ConsoleColor.RESET);
                return;
            }
        }
        System.out.println(ConsoleColor.RED + Messages.TASK_NOT_FOUND + ConsoleColor.RESET);
    }

    public void deleteTask(int taskId) {
        if (todoItems.removeIf(item -> item.getId() == taskId)) {
            System.out.println(ConsoleColor.RED + Messages.TASK_DELETED + taskId + ConsoleColor.RESET);
        } else {
            System.out.println(ConsoleColor.RED + Messages.TASK_NOT_FOUND + ConsoleColor.RESET);
        }
    }

    private boolean isValidDateFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
