import org.example.mocking.ToDoService;
import org.example.mocking.ToDoServiceImplementation;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class MockingTest {

    @Test
    public void mockingTest() {
        ToDoService toDoService = mock(ToDoService.class);
        List<String> combinedlist = Arrays.asList("Use Core Java", "Use JavaME");
        when(toDoService.getTasksForUser("Jovan")).thenReturn(combinedlist);
        ToDoServiceImplementation serviceImplementation = new ToDoServiceImplementation(toDoService);
        List<String> allTasks = serviceImplementation.getJavaTasks("Jovan");
        String results[] = {"Use Core Java", "Use JavaME"};
        List<String> expectedTasks = Arrays.asList(results);
        assertEquals(expectedTasks, allTasks);
    }

}
