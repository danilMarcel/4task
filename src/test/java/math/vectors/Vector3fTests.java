package math.vectors;


import org.junit.jupiter.api.Test;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f.*;

public class Vector3fTests {
    @Test
    public void testAdd() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f res = add(v1, v2);
        assertEquals(new Vector3f(5, 7, 9), res);
    }

    @Test
    public void testSub() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f res = subtract(v1, v2);
        assertEquals(new Vector3f(-3, -3, -3), res);
    }

    @Test
    public void testMultiply() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        float scalar = 2F;
        v1.multiply(scalar);
        Vector3f res = v1;
        assertEquals(new Vector3f(2, 4, 6), res);
    }

    @Test
    public void testDivide() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        float scalar = 2;
        v1.divide(scalar);
        Vector3f res = v1;
        assertEquals(new Vector3f(0.5F, 1, 1.5F), res);
    }

    @Test
    public void testDivideZero() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        float scalar = 0;
        assertThrows(ArithmeticException.class, () -> v1.divide(scalar));
    }

    @Test
    public void testLength() {
        Vector3f v1 = new Vector3f(1, 2, 2);
        float res = v1.length();
        assertEquals(3F, res);
    }

    @Test
    public void testNormalize() {
        Vector3f v1 = new Vector3f(1, 2, 2);
        v1.normalize();
        Vector3f res = v1;
        assertEquals(new Vector3f((float) 1/3, (float) 2/3, (float) 2/3), res);
    }

    @Test
    public void testNormalizeZero() {
        Vector3f v1 = new Vector3f(0, 0, 0);
        assertThrows(ArithmeticException.class, () -> v1.normalize());
    }

    @Test
    public void testDotProduct() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        float res = dotProduct(v1, v2);
        assertEquals(32F, res);
    }

    @Test
    public void testCrossProduct() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f res = crossProduct(v1, v2);
        assertEquals(new Vector3f(-3, -3, 6), res);
    }
}
