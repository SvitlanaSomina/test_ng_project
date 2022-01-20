import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void addPositiveNumbersTest() {
        int NumberA = 3;
        int NumberB = 4;
        int expectedResult = 7;
        int actualResult = calculator.add(NumberA, NumberB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void subtractPositiveNumbersTest() {
        int NumberA = 20;
        int NumberB = 5;
        int expectedResult = 15;
        int actualResult = calculator.subtract(NumberA, NumberB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void multiplyPositiveNumbersTest() {
        int NumberA = 10;
        int NumberB = 30;
        int expectedResult = 300;
        int actualResult = calculator.multiply(NumberA, NumberB);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividePositiveNumbersTest() {
        int NumberA = 55;
        int NumberB = 5;
        double expectedResult = 11;
        double actualResult = calculator.divide(NumberA, NumberB);
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroTest() {
        int NumberA = 78;
        int NumberB = 0;
        calculator.divide(NumberA, NumberB);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = MyDataProvider.class)
    public void multiplyTest(int a, int b, int expectedResult) {
        int actualResult = calculator.multiply(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @Test(dataProvider = "excel-data", dataProviderClass = ExcelDataProvider.class)
    public void subtractTest(int a, int b, int expectedResult) {
        int actualResult = calculator.subtract(a, b);
        assertEquals(expectedResult, actualResult);
    }
}
