import com.example.AnimalKind;
import com.example.Family;
import com.example.Feline;
import com.example.Food;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = spy(new Feline());

        List<Food> mockFood = List.of(Food.Animals, Food.Birds, Food.Fish);
        doReturn(mockFood).when(feline).getFood(AnimalKind.Predator);

        assertEquals(mockFood, feline.eatMeat());
        verify(feline, times(1)).getFood(AnimalKind.Predator);
    }

    @Test
    public void testGetFamily() {
        assertEquals(Family.Feline, feline.getFamily());
    }

    @Test
    public void testGetKittens_Default() {
        assertEquals(1, feline.getKittens());
    }
}
