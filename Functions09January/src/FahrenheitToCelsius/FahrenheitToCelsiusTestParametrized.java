//package FahrenheitToCelsius;
//
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import static org.junit.Assert.*;
//
//@RunWith(Parameterized.class)
//public class FahrenheitToCelsiusTestParametrized {
//
//    private FahrenheitToCelsius fc;
//    private float expected;
//    private float fahrenheit;
//
//    public FahrenheitToCelsiusTestParametrized(float expected, float fahrenheit) {
//        this.expected = expected;
//        this.fahrenheit = fahrenheit;
//    }
//
//    @org.junit.Before
//    public void setup() {
//        fc = new FahrenheitToCelsius();
//        System.out.println("Running a test ... ");
//    }
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> testConditions() {
//        return Arrays.asList(new Object[][]{
//                {0, 32},
//                {-13.33, 8},
//                {-23.33, -10},
//                {100, 37.77},
//                {88.88, 31.6}
//        });
//    }
//
//    @org.junit.Test
//    public void fahrenheitToCelsius() {
//        FahrenheitToCelsius fc = new FahrenheitToCelsius();
//        assertEquals(expected, fc.fahrenheitToCelsius(fahrenheit), 0.01);
//    }
//}