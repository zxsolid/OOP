package ToDoPlanner;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class Scheduler implements SchedulerActions, TaskLoader, TaskSave {
    private ArrayList<Task> taskPool;

    public Scheduler(ArrayList<Task> taskPool) {
        this.taskPool = taskPool;
    }

    public Scheduler() {
        this.taskPool = new ArrayList<>();
    }

    public ArrayList<Task> getTaskPool() {
        return taskPool;
    }

    public int getSize() {
        return taskPool.size();
    }

    @Override
    public ArrayList<Task> getCurrentTasks() {
        return null;
    }

    @Override
    public void clear() {
        taskPool = new ArrayList<>();
    }

    @Override
    public ArrayList<Task> getOverdueTasks() {
        return null;
    }

    @Override
    public void viewTasks() {
        taskPool.sort(new SortByPriority());
        for (Task t : taskPool) {
            System.out.println(t + "\n");
        }
    }

    @Override
    public ArrayList<Task> searchTasks(String findRequest) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : taskPool) {
            if (t.findString(findRequest)) result.add(t);
        }
        if (result.size() > 0) return result;
        return null;
    }

    @Override
    public int deleteTaskBySearch(String searchString) {
        int count = 0;
        Iterator<Task> iteratorTaskPool = taskPool.iterator();
        while (iteratorTaskPool.hasNext()) {
            Task t = iteratorTaskPool.next();
            if (t.findString(searchString)) {
                iteratorTaskPool.remove();
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean taskLoad(String filename) {
        String f;
        Scheduler newSc = new Scheduler();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((f = reader.readLine()) != null) {
                Task task = Task.parse(f);
                newSc.addTask(task);
            }
            this.taskPool = newSc.getTaskPool();
            return true;
        } catch (IOException ex) {
            System.out.println("Ошибка чтения");
        } catch (ParseException e) {
            System.out.println("Ошибка парсинга данных");
        }
        return false;
    }

    @Override
    public boolean taskSave(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Task t : taskPool) {
                String text = t.getCSV() + "\n";
                writer.write(text);
            }
            writer.flush();
            return true;
        } catch (IOException ex) {
            System.out.println("ошибка записи файла " + fileName);
            return false;
        }
    }

    @Override
    public void addTask(Task task) {
        if (task == null) return;
        taskPool.add(task);
    }
}