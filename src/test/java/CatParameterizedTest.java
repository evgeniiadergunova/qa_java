import com.example.Cat;
import com.example.Feline;
import com.example.Food;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "Animals, Birds|Fish",
            "Grass, VariousPlants"
    })
    void testGetFood_Parameterized(String foodItems) throws Exception {
        Feline feline = mock(Feline.class);

        List<Food> mockFoodList = Arrays.stream(foodItems.split("\\|"))
                .map(Food::valueOf)
                .collect(Collectors.toList());

        when(feline.eatMeat()).thenReturn(mockFoodList);

        Cat cat = new Cat(feline);

        assertEquals(mockFoodList, cat.getFood());

        verify(feline, times(1)).eatMeat();
    }

}
