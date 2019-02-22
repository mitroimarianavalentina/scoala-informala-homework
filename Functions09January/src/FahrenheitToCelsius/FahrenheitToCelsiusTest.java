package FahrenheitToCelsius;

import static org.junit.Assert.*;

public class FahrenheitToCelsiusTest {

    @org.junit.Test
    public void fahrenheitToCelsius() {
        FahrenheitToCelsius fc = new FahrenheitToCelsius();
        assertEquals(-23.33, fc.fahrenheitToCelsius(-10), 0.01);
    }
}