import com.example.Animal;
import com.example.AnimalKind;
import com.example.Food;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "Herbivore, Grass|VariousPlants",
            "Predator, Animals|Birds|Fish"
    })
    public void testGetFood_ValidAnimalKind(String animalKind, String expectedFood) throws Exception {
        Animal animal = new Animal();

        AnimalKind kind = AnimalKind.valueOf(animalKind);
        List<Food> expectedFoods = Arrays.stream(expectedFood.split("\\|"))
                .map(Food::valueOf)
                .collect(Collectors.toList());

        List<Food> result = animal.getFood(kind);

        assertEquals(expectedFoods, result);
    }

}
