import com.example.Animal;
import com.example.AnimalKind;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {
    private final Animal animal = new Animal();

    @Test
    public void testGetFood_ThrowsExceptionForUnknownAnimalKind() {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(AnimalKind.Unknown));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testGetFamily_ThrowsUnsupportedOperationException() {
        // Проверяем, что метод выбрасывает исключение
        UnsupportedOperationException exception = assertThrows(
                UnsupportedOperationException.class,
                animal::getFamily
        );

        assertEquals("Необходимо возвращать семейство", exception.getMessage());
    }
}
