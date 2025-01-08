package math.vectors;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f.*;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2fTests {

    @Test
    public void testAdd() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        Vector2f res = add(v1,v2);
        assertEquals(new Vector2f(4, 6), res);
    }

    @Test
    public void testSub() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        Vector2f res = subtract(v1, v2);
        assertEquals(new Vector2f(-2, -2), res);
    }

    @Test
    public void testMultiply() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        float scalar = 2F;
        v1.multiply(scalar);
        Vector2f res = v1;
        v2.multiply(scalar);
        Vector2f res2 = v2;
        assertEquals(new Vector2f(2, 4), res);
        assertEquals(new Vector2f(6, 8), res2);
    }

    @Test
    public void testDivide() {
        Vector2f v1 = new Vector2f(1, 2);
        float scalar = 2F;
        v1.divide(scalar);
        Vector2f res = v1;
        assertEquals(new Vector2f(0.5F, 1), res);
    }

    @Test
    public void testDivideZero() {
        Vector2f v1 = new Vector2f(1, 2);
        float scalar = 0;
        assertThrows(ArithmeticException.class, () -> v1.divide(scalar));
    }

    @Test
    public void testLength() {
        Vector2f v1 = new Vector2f(3, 4);
        float res = v1.length();
        assertEquals(5F, res);
    }


    @Test
    public void testNormalize() {
        Vector2f v1 = new Vector2f(3, 4);
        v1.normalize();
        Vector2f res = v1;
        assertEquals(new Vector2f(0.6f, 0.8f), res);
    }

    @Test
    public void testNormalizeZero() {
        Vector2f v1 = new Vector2f(0, 0);
        assertThrows(ArithmeticException.class, () -> v1.normalize());

    }

    @Test
    public void testDotProduct() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        float res = dotProduct(v1, v2);
        assertEquals(11F, res);
    }



}
