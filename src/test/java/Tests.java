import org.example.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class Tests {

    private Solution solution;

    @Before
    public void beforeTest() {
        solution = new Solution();
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

}
