import org.testng.annotations.DataProvider;

public class MyDataProvider {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {6, 5, 30},
                {-10, -30, 300},
                {-8, 6, -48},
                {20, -2, -40}
        };
    }
}
