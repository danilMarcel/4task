package math.matrices;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix2f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix2f.*;

public class Matrix2fTests {

    @Test
    public void testAdd() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        Matrix2f m2 = new Matrix2f(new float[]{5, 6, 7, 8});
        Matrix2f res = add(m1,m2);
        assertEquals(new Matrix2f(new float[]{6, 8, 10 ,12}), res);
    }

    @Test
    public void testSub() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        Matrix2f m2 = new Matrix2f(new float[]{5, 6, 7, 8});
        Matrix2f res = subtract(m1, m2);
        assertEquals(new Matrix2f(new float[]{-4, -4, -4, -4}), res);
    }

    @Test
    public void testMultiplyVector() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        Vector2f v1 = new Vector2f(2, 4);
        Vector2f res = multiply(m1, v1);
        assertEquals(new Vector2f(10, 22), res);
    }

    @Test
    public void testMultiplyMatrix() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        Matrix2f m2 = new Matrix2f(new float[]{5, 6, 7, 8});
        Matrix2f res = multiply(m1, m2);
        assertEquals(new Matrix2f(new float[]{19, 22, 43, 50}), res);
    }


    @Test
    public void testTranspose() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        Matrix2f res = m1.transpose();
        assertEquals(new Matrix2f(new float[]{1, 3, 2, 4}), res);
    }

    @Test
    public void testDeterminant() {
        Matrix2f m1 = new Matrix2f(new float[]{1, 2, 3, 4});
        float res = m1.determinant();
        assertEquals(-2f, res);
    }


}
