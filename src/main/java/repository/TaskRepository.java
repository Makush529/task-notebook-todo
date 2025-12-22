package repository;

import java.util.*;

public class TaskRepository {
    private static TaskRepository instance;
    private final Map<String, Set<String>>taskList;


    public TaskRepository() {
        this.taskList = new HashMap<>();
        HashSet<String>set = new HashSet<>();
        set.add("one");//test
        set.add("two");//test
        set.add("three");//test
        taskList.put("admin",set);//test
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public Set<String> getTaskListByUsername(String username) {
        return taskList.get(username);
    }
    public boolean updateTaskListByUsername(String username, Set<String> taskList) {
        try {
            this.taskList.put(username, taskList);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
