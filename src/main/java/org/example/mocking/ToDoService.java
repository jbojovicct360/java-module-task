package org.example.mocking;

import java.util.List;

public interface ToDoService {

    List<String> getTasksForUser(String user);

}
