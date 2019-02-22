package Time;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TimeTest {
    private Time time;
    private boolean expected;
    private int hour;
    private int minutes;

    public TimeTest(boolean expected, int hour, int minutes) {
        this.expected = expected;
        this.hour = hour;
        this.minutes = minutes;
    }
    @Before
    public void setup(){
        time = new Time();
        System.out.println("Running test ... ");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {true, 12, 04},
                {false, 24, 59},
                {false, 24, 15},
                {false, 23, 60},
                {false, 25, 04},
                {false, 30, 75},
                {true, 00, 59},
                {false, 00, 60}
                });
    }

    @Test
    public void verifyTime() {
        assertEquals(expected, time.verifyTime(hour, minutes));
    }
}