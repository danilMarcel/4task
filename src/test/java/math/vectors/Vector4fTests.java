package math.vectors;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector4f;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector4f.*;


public class Vector4fTests {

    @Test
    public void testAdd() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f v2 = new Vector4f(5, 6, 7, 8);
        Vector4f res = add(v1, v2);
        assertEquals(new Vector4f(6,8,10,12), res);

    }

    @Test
    public void testSub() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f v2 = new Vector4f(5, 6, 7, 8);
        Vector4f res = subtract(v1, v2);
        assertEquals(new Vector4f(-4, -4, -4, -4),res);
    }

    @Test
    public void testMultiply() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        float scalar = 2;
        v1.multiply(scalar);
        Vector4f res = v1;
        assertEquals(new Vector4f(2, 4, 6, 8), res);
    }

    @Test
    public void testDivide() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        float scalar = 2;
        v1.divide(scalar);
        Vector4f res = v1;
        assertEquals(new Vector4f(0.5F, 1, 1.5F, 2), res);
    }

    @Test
    public void testDivideZero() {
        Vector4f v1 = new Vector4f(0, 0, 0, 0);
        float scalar = 0;
        assertThrows(ArithmeticException.class, () -> v1.divide(scalar));
    }


    @Test
    public void testLength() {
        Vector4f v1 = new Vector4f(1, 2, 2, 4);
        float res = v1.length();
        assertEquals(5, res);
    }

    @Test
    public void testNormalize() {
        Vector4f v1 = new Vector4f(1, 2, 2, 4);
        v1.normalize();
        Vector4f res = v1;
        assertEquals(new Vector4f(0.2F, 0.4F, 0.4F, 0.8F), res);
    }

    @Test
    public void testNormalizeZero() {
        Vector4f v1 = new Vector4f(0, 0, 0, 0);
        assertThrows(ArithmeticException.class, () -> v1.normalize());
    }


     @Test
    public void testDotProduct() {
         Vector4f v1 = new Vector4f(1, 2, 3, 4);
         Vector4f v2 = new Vector4f(5, 6, 7, 8);
         float res = dotProduct(v1 ,v2);
         assertEquals(70, res);
     }
}
