package math.matrices;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix2f;
import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix3f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix3f.*;

public class Matrix3fTests {

    @Test
    public void testAdd() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f m2 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f res = add(m1, m2);
        assertEquals(new Matrix3f(new float[]{2, 4, 6, 8, 10, 12, 14, 16, 18}), res);
    }

    @Test
    public void testSub() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f m2 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f res = subtract(m1, m2);
        assertEquals(new Matrix3f(new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0}), res);
    }

    @Test
    public void testMultiplyVector() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Vector3f v1 = new Vector3f(2, 3, 4);
        Vector3f res = multiply(m1, v1);
        assertEquals(new Vector3f(20, 47, 74), res);
    }

    @Test
    public void testMultiplyMatrix() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f m2 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f res = multiply(m1, m2);
        assertEquals(new Matrix3f(new float[]{30, 36, 42, 66, 81, 96, 102, 126 , 150}), res);
    }

    @Test
    public void testTranspose() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Matrix3f res = m1.transpose();
        assertEquals(new Matrix3f(new float[]{1, 4, 7, 2, 5, 8, 3, 6, 9}), res);
    }

    @Test
    public void testDeterminant() {
        Matrix3f m1 = new Matrix3f(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        float res = m1.determinant();
        assertEquals(0F, res);
    }
}
