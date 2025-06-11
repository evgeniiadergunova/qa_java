import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class FelineParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void testGetKittens_WithParameter(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
