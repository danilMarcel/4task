package ru.vsu.cs.vetokhin.kg4task.model.modelOperations;

import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector4f;

public class Transformation {
    public static Matrix4f rotate(Vector3f r) {
        return new Matrix4f(new Vector4f((float) (Math.cos(r.getY()) * Math.cos(r.getZ())), (float) (-Math.sin(r.getZ()) * Math.cos(r.getY())), (float) Math.sin(r.getY()), 0),
                new Vector4f((float) (Math.sin(r.getX()) * Math.sin(r.getY()) * Math.cos(r.getZ()) + Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (-Math.sin(r.getX()) * Math.sin(r.getY()) * Math.sin(r.getZ()) + Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (-Math.sin(r.getX()) * Math.cos(r.getY())), 0),
                new Vector4f((float) (Math.sin(r.getX()) * Math.sin(r.getZ()) - Math.sin(r.getY()) * Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (Math.sin(r.getX()) * Math.cos(r.getZ()) + Math.sin(r.getY()) * Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (Math.cos(r.getX()) * Math.cos(r.getY())), 0),
                new Vector4f(0, 0, 0, 1)
        );
    }

    public static Matrix4f scale(Vector3f s) {
        return new Matrix4f(
                new Vector4f(s.getX(), 0, 0 , 0),
                new Vector4f(0, s.getY(), 0, 0),
                new Vector4f(0, 0, s.getZ(), 0),
                new Vector4f(0, 0, 0, 1)
        );
    }

    public static Matrix4f translation(Vector3f t) {
        return new Matrix4f(
                new Vector4f(1, 0, 0, t.getX()),
                new Vector4f(1, 1, 0, t.getY()),
                new Vector4f(1, 0, 1, t.getZ()),
                new Vector4f(1, 0, 0, 1)
        );
    }
}
