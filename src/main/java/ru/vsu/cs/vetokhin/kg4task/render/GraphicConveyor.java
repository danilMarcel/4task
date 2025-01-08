package ru.vsu.cs.vetokhin.kg4task.render;

import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;

import static ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f.multiply;
import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f.*;
import static ru.vsu.cs.vetokhin.kg4task.model.modelOperations.Transformation.*;


public class GraphicConveyor {

    public static Matrix4f tRS(Vector3f t, Vector3f r, Vector3f s) {
        return multiply(multiply(translation(t), rotate(r)), scale(s));
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target) {
        return lookAt(eye, target, new Vector3f(0F, 1.0F, 0F));
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target, Vector3f up) {

        Vector3f resultZ = subtract(target, eye);
        Vector3f resultX = crossProduct(up, resultZ);
        Vector3f resultY = crossProduct(resultZ, resultX);

        resultX.normalize();
        resultY.normalize();
        resultZ.normalize();

        float[] matrix = new float[] {
                resultX.getX(), resultX.getY(), resultX.getZ(), -dotProduct(resultX, eye),
                resultY.getX(), resultY.getY(), resultY.getZ(), -dotProduct(resultY, eye),
                resultZ.getX(), resultZ.getY(), resultZ.getZ(), -dotProduct(resultZ, eye),
                0, 0, 0, 1};
        return new Matrix4f(matrix);
    }


        public static Matrix4f perspective(final float fov, final float aspectRatio, final float nearPlane, final float farPlane) {
            float tangentsMinusFov = (float) (1.0F / (Math.tan(fov * 0.5F)));
            float[] matrix = new float[] {
                    tangentsMinusFov, 0, 0, 0,
                    0, tangentsMinusFov / (aspectRatio), 0, 0,
                    0, 0, (farPlane + nearPlane) / (farPlane - nearPlane), (2 * farPlane * nearPlane) / (nearPlane - farPlane),
                    0, 0, 1, 0};
            return new Matrix4f(matrix);
    }

    public static Vector2f vertexToPoint(final  Vector3f vertex, final int width, final int height) {
        return new Vector2f(((float) (width - 1) / 2) * vertex.getX() + ((float) (width - 1) / 2), (((float) (1 - height) / 2) * vertex.getY()) + ((float) (height - 1) / 2));
    }

    public static Vector3f vertexToPoint3(final  Vector3f vertex, final int width, final int height) {
        return new Vector3f(((float) (width - 1) / 2) * vertex.getX() + ((float) (width - 1) / 2), (((float) (1 - height) / 2) * vertex.getY()) + ((float) (height - 1) / 2), vertex.getZ());
    }
}








