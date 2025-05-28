import com.example.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class LionTest {
    Feline mockFeline = mock(Feline.class);

    @Test
    public void testConstructor_ThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(null, mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);

        Lion lion = new Lion(Sex.FEMALE, mockFeline);

        assertEquals(3, lion.getKittens());

        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        List<Food> mockFoodList = List.of(Food.Animals, Food.Birds);
        when(mockFeline.getFood(AnimalKind.Predator)).thenReturn(mockFoodList);

        Lion lion = new Lion(Sex.MALE, mockFeline);

        assertEquals(mockFoodList, lion.getFood());

        verify(mockFeline, times(1)).getFood(AnimalKind.Predator);
    }
}
