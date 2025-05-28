import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class CatTest {
    @Test
    public void testGetSound() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_ThrowsException() throws Exception {
        Feline feline = mock(Feline.class);

        when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        Cat cat = new Cat(feline);
        Exception exception = assertThrows(Exception.class, cat::getFood);

        assertEquals("Ошибка получения еды", exception.getMessage());
        verify(feline, times(1)).eatMeat();
    }
}
