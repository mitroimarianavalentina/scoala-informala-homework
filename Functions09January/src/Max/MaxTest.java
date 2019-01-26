package Max;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxTest {

        private Max max;
        private int expected;
        private int firstParameter;
        private int secondParameter;

    public MaxTest(int expected, int firstParameter, int secondParameter) {
        this.expected = expected;
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    @org.junit.Before
        public void setup() {
            max = new Max();
            System.out.println("Running a test ... ");
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {
            return Arrays.asList(new Object[][]{
                    {32, 32, 5},
                    {0, 0, 0},
                    {15, 15, -4},
                    {-1, -15, -1},
                    {22, 1, 22}
            });
        }


    @Test
    public void getMax() {
        Max max = new Max();
        assertEquals(expected, max.getMax(firstParameter, secondParameter));
    }

}