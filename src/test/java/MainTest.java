import org.example.Main;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void getInputFilesTest() throws IOException {
        String expectedString[] = {"input1.txt", "input2.txt", "input3.txt", "input4.txt", "input5.txt"};
        List<String> expectedList = Arrays.asList(expectedString);
        ArrayList<String> expected = new ArrayList<>(expectedList);
        assertEquals(expected, Main.getInputFiles());
    }

}
