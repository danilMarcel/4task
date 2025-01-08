package ru.vsu.cs.vetokhin.kg4task.math.vectors;

import java.nio.file.Path;
import java.util.Objects;

public class Vector3f {
    private float x;

    private float y;
    private float z;
    private final float eps = 1e-7f;

    public Vector3f() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3f vector3f = (Vector3f) o;
        return Math.abs(this.x - vector3f.x) < eps && Math.abs(this.y - vector3f.y) < eps && Math.abs(this.z - vector3f.z) < eps;
    }

    public static Vector3f add(Vector3f vector1, Vector3f vector2) {
        return new Vector3f(vector1.x + vector2.x, vector1.y + vector2.y, vector1.z + vector2.z);
    }

    public static Vector3f subtract(Vector3f vector1, Vector3f vector2) {
        return new Vector3f(vector1.x - vector2.x, vector1.y - vector2.y, vector1.z - vector2.z);
    }

    public void multiply(float scalar) {
        this.x = x * scalar;
        this.y = y * scalar;
        this.z = z * scalar;
    }

    public void divide(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.x = x / scalar;
        this.y = y / scalar;
        this.z = z / scalar;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public void normalize() throws ArithmeticException {
        float length = length();
        if (Math.abs(length) < eps) {
            throw new ArithmeticException("Cannot normalize a vector with zero length.");
        }
        this.divide(length);
    }

    public Vector4f toVector4f() {
        return new Vector4f(this.x, this.y, this.z, 1);
    }

    public static float dotProduct(Vector3f vector1, Vector3f vector2) {
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
    }

    public static Vector3f crossProduct(Vector3f vector1, Vector3f vector2) {
        return new Vector3f(vector1.x * vector2.y - vector1.y * vector2.x, vector1.y * vector2.z - vector1.z * vector2.y, vector1.z * vector2.x - vector1.x * vector2.z);
    }

    @Override
    public Vector3f clone() {
        try {
            return (Vector3f) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Vector3f{" + "x=" + x + ", y=" + y + ", z=" + z + "}";

    }

}
