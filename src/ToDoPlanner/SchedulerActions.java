package ToDoPlanner;

import java.util.ArrayList;

public interface SchedulerActions {
    ArrayList<Task> getCurrentTasks();

    void clear();

    ArrayList<Task> getOverdueTasks();

    int deleteTaskBySearch(String searchString);

    boolean taskLoad(String filename);

    boolean taskSave(String fileName);

    void addTask(Task task);

    void viewTasks();

    ArrayList<Task> searchTasks(String findRequest);
}