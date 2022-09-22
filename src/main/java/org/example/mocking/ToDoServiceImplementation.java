package org.example.mocking;

import java.util.ArrayList;
import java.util.List;

public class ToDoServiceImplementation {

    private ToDoService toDoService;

    public ToDoServiceImplementation(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<String> getJavaTasks(String user) {
        List<String> userTasks = toDoService.getTasksForUser(user);
        List<String> javaTasks = new ArrayList<>();
        for(String task : userTasks)
            if(task.contains("Java"))
                javaTasks.add(task);
        return javaTasks;
    }

}
