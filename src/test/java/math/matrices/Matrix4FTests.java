package math.matrices;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector4f;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f.*;

public class Matrix4FTests {

    @Test
    public void testAdd() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Matrix4f m2 = unitMatrix();
        Matrix4f res = add(m1, m2);
        assertEquals(new Matrix4f(new float[]{2, 2, 3, 4, 5, 7, 7, 8, 9, 10, 12, 12, 13, 14, 15, 17}), res);
    }

    @Test
    public void testSub() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Matrix4f m2 = unitMatrix();
        Matrix4f res = subtract(m1, m2);
        assertEquals(new Matrix4f(new float[]{0, 2, 3, 4, 5, 5, 7, 8, 9, 10, 10, 12, 13, 14, 15, 15}), res);
    }

    @Test
    public void testMultiplyVector() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f res = multiply(m1, v1);
        assertEquals(new Vector4f(30, 70, 110, 150), res);
    }

    @Test
    public void testMultiplyMatrix() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Matrix4f m2 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Matrix4f res = multiply(m1, m2);
        assertEquals(new Matrix4f(90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440, 426, 484, 542, 600), res);
    }

    @Test
    public void testTranspoze() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        Matrix4f res = m1.transpose();
        assertEquals(new Matrix4f(new float[]{1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16}), res);
    }

    @Test
    public void testDeterminant() {
        Matrix4f m1 = new Matrix4f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        float res = m1.determinant();
        assertEquals(0f, res);

    }
}