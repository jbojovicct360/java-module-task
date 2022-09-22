import org.example.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Before
    public void beforeTest() {
        System.out.println("Execution of Balloon task function started!");
    }

    @After
    public void afterTest() {
        System.out.println("Execution of Ballon task function ended!");
    }

    @Test
    public void balloonTest() {
        assertEquals(1, solution.solution("BAONXXOLL"));
        assertEquals(0, solution.solution("0186031"));
        assertEquals(1, solution.solution("BAONX421XO1LL"));
        assertEquals(2, solution.solution("BAOOLLNNOLOLGBAX"));
    }

    @Test
    public void twoWordSolutionTest() {
        assertEquals(2, solution.twoWordsSolution("cssatllacggt", "cat"));
        assertEquals(0, solution.twoWordsSolution("123411", "abc"));
        assertEquals(2, solution.twoWordsSolution("abcabc", "abc"));
    }

    @Test
    public void twoWordHashMapSolution() {
        assertEquals(2, solution.twoWordsHashMapSolution("cssatllacggt", "cat"));
    }

    @Test
    public void methodPerformanceTest() {
        long startTime = System.nanoTime();
        solution.twoWordsSolution("cssatllacggt", "cat");
        long endTime = System.nanoTime();
        long firstMethodTime = endTime - startTime;
        startTime = System.nanoTime();
        solution.twoWordsHashMapSolution("cssatllacggt", "cat");
        endTime = System.nanoTime();
        long secondMethodTime = endTime - startTime;
        System.out.println("First method execution time (in nano): " + firstMethodTime);
        System.out.println("Second method execution time (in nano): " + secondMethodTime);
    }

}
