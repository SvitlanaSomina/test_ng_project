import org.testng.annotations.BeforeSuite;

public class InitOneTime {
    @BeforeSuite
    public void init() {
        System.out.println("I'm running only one before the suite");
    }
}
