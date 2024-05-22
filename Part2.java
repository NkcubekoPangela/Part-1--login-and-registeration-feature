/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part.pkg2;

/**
 *
 * @author RC_Student_lab
 */
public class Part2 {

    /**
     * @param args the command line arguments
     */
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    private String taskID;
    private String name;
    private String status;
    private double number;
    private int taskduration;
    private String description;
    private String developer;
    private static final Scanner scan = new Scanner(System.in);

    // Getters and Setters
    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public int getTaskDuration() {
        return taskduration;
    }

    public void setTaskDuration(int taskduration) {
        this.taskduration = taskduration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    // Constructor
    public Part3(String name, String description, String developer, int taskduration, String status, double number) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.taskduration = taskduration;
        this.status = status;
        this.number = number;
        this.taskID = createTaskID();
    }

    // Method to create Task ID
    public String createTaskID() {
        return name.substring(0, 2).toUpperCase() + ":" + (int) number + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

    // Method to display task details
    public String printTaskDetails() {
        return "Task Status: " + status + "\nDeveloper details: " + developer + "\nTask Number: " + number + "\nTask name: " + name + "\nTask Description: " + description + "\nTask ID: " + taskID + "\nDuration: " + taskduration;
    }

    // Method to check task description length
    public static boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    // Method to return total hours
    public static int returnTotalHours(ArrayList<Part2> tasks) {
        int totalHours = 0;
        for (Part2 task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    public boolean exploreTasks(ArrayList<Part3> tasks) {
        String taskID = JOptionPane.showInputDialog("Enter task id to establish:");
        Part2[] _tasks = new Part3[tasks.size()];
        tasks.toArray(_tasks);

        boolean establish = false;
        if (_tasks.length > 0) {
            for (Part2 _task : _tasks) {
                if (_task.taskID.equalsIgnoreCase(taskID)) {
                    String message = "Task ID: " + _task.taskID + "\nTask name: " + _task.name
                            + "\nTask status: " + _task.status + "\nTask Description: " + _task.description
                            + "\nTask number: " + _task.number + "\nTask duration: " + _task.taskduration
                            + "\nTask developer: " + _task.developer;
                    JOptionPane.showMessageDialog(null, message);
                    establish = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tasks established");
            establish = true;
        }
        return establish;
    }

    public void CaptureTasks() {
        name = JOptionPane.showInputDialog("Enter the Task name:");
        description = JOptionPane.showInputDialog("Enter the Task Description:");
        if (!checkTaskDescription(description)) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return;
        }
        number = Double.parseDouble(JOptionPane.showInputDialog("Enter the task number:"));
        taskduration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration :"));
        developer = JOptionPane.showInputDialog("Enter the developer name:");
        choosestatus();
        taskID = createTaskID();
    }

    public void choosestatus() {
        Object[] options = {"TO DO", "DOING", "DONE"};
        int chosen = JOptionPane.showOptionDialog(null, "Choose the task status:",
                "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch (chosen) {
            case 0:
                status = "TO DO";
                break;
            case 1:
                status = "DOING";
                break;
            case 2:
                status = "DONE";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Chosen incorrectly");
                choosestatus();
                break;
        }
    }

    public void updateProduct(ArrayList<Part3> tasks) {
        String code = JOptionPane.showInputDialog("Enter the task id to update:");
        Part2[] _tasks = new Part3[tasks.size()];
        tasks.toArray(_tasks);

        if (_tasks.length > 0) {
            for (Part2 _task : _tasks) {
                if (_task.taskID.equalsIgnoreCase(code)) {
                    int choice = JOptionPane.showConfirmDialog(null, "Update the task description?", "Update Task", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        String description = JOptionPane.showInputDialog("Enter new task description:");
                        if (!checkTaskDescription(description)) {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                            return;
                        }
                        _task.setDescription(description);
                    }

                    int numberChoice = JOptionPane.showConfirmDialog(null, "Update the number?", "Update task", JOptionPane.YES_NO_OPTION);
                    if (numberChoice == JOptionPane.YES_OPTION) {
                        double number = Double.parseDouble(JOptionPane.showInputDialog("Enter new task number:"));
                        _task.setNumber(number);
                    }

                    int taskdurationChoice = JOptionPane.showConfirmDialog(null, "Update the task duration?", "Update task", JOptionPane.YES_NO_OPTION);
                    if (taskdurationChoice == JOptionPane.YES_OPTION) {
                        int taskduration = Integer.parseInt(JOptionPane.showInputDialog("Enter new task duration:"));
                        _task.setTaskDuration(taskduration);
                    }

                    JOptionPane.showMessageDialog(null, "Task updated successfully.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No TASK to update.");
        }
    }

    public void chooseDescription() {
        int difficulty = JOptionPane.showOptionDialog(
                null,
                "Choose task description:",
                "Description Level",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new String[]{"Easy", "Difficult"},
                "Easy"
        );
        description = difficulty == 0 ? "Easy" : "Difficult";
    }

    public void removeTasks(ArrayList<Part3> tasks) {
        String code = JOptionPane.showInputDialog("Enter the Task ID to be deleted:");
        Part2[] _tasks = new Part2[tasks.size()];
        tasks.toArray(_tasks);

        if (_tasks.length > 0) {
            for (Part3 _task : _tasks) {
                if (_task.taskID.equalsIgnoreCase(code)) {
                    tasks.remove(_task);
                    JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No TASKS to delete.");
        }
    }

    public void updateTasks(ArrayList<Part2> tasks) {
        String _code = JOptionPane.showInputDialog("Enter task ID to update:");
        Part3[] _tasks = new Part3[tasks.size()];
        tasks.toArray(_tasks);

        if (_tasks.length > 0) {
            for (Part3 _task : _tasks) {
                if (_task.taskID.equalsIgnoreCase(_code)) {
                    int _choice = JOptionPane.showConfirmDialog(null, "Update the description?", "Task Update", JOptionPane.YES_NO_OPTION);
                    if (_choice == JOptionPane.YES_OPTION) {
                        String newDescription = JOptionPane.showInputDialog("Enter the new task description:");
                        _task.description = newDescription;
                    }

                    int _numberChoice = JOptionPane.showConfirmDialog(null, "Update the number?", "Task Update", JOptionPane.YES_NO_OPTION);
                    if (_numberChoice == JOptionPane.YES_OPTION) {
                        String newNumber = JOptionPane.showInputDialog("Enter new task number:");
                        _task.number = Double.parseDouble(newNumber);
                    }

                    int _taskDurationChoice = JOptionPane.showConfirmDialog(null, "Update the task duration?", "Task Update", JOptionPane.YES_NO_OPTION);
                    if (_taskDurationChoice == JOptionPane.YES_OPTION) {
                        String newTaskDuration = JOptionPane.showInputDialog("Enter new task duration:");
                        _task.taskduration = Integer.parseInt(newTaskDuration);
                    }

                    JOptionPane.showMessageDialog(null, "Task updated successfully.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,


    }
    
}
