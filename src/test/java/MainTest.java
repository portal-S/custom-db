import com.crew.main.Main;
import com.crew.model.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MainTest {

    private final Main main = new Main();

    @Test
    @RepeatedTest(10)
    public void testWrite() {


        String wrongInput = "key,value";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            main.write(wrongInput);
        });

        String correctInput = "key-1;value-1";

        main.write(correctInput);
    }

    @Test
    public void testRead() {


        Entry entry = new Entry("Key-1", "Value-1");
        String testData = "Key-1";

        Assertions.assertEquals(entry, main.read(testData));
    }

    @Test
    public void prepareEntryTest() {
        Entry entry = new Entry("Key-1", "Value-1");
        String testData = "Key-1;Value-1";

        Assertions.assertEquals(entry, main.prepareEntry(testData));
    }
}
