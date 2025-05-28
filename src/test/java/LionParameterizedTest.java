import com.example.Feline;
import com.example.Lion;
import com.example.Sex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LionParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "MALE, true",
            "FEMALE, false"
    })
    public void testConstructor_WithValidSex(Sex sex, boolean expectedHasMane) throws Exception {
        Feline mockFeline = mock(Feline.class);
        
        Lion lion = new Lion(sex, mockFeline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
