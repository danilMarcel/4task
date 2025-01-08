package ru.vsu.cs.vetokhin.kg4task.math.vectors;

import java.util.Objects;

public class Vector4f {
    private float x;
    private float y;
    private float z;
    private float w;
    private final float eps = 1e-7f;

    public Vector4f() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }


    public Vector4f(float x,  float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public float getW() {
        return w;
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

    public void setW(float w) {
        this.w = w;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector4f vector4f = (Vector4f) o;
        return Math.abs(this.x - vector4f.x) < eps && Math.abs(this.y - vector4f.y) < eps && Math.abs(this.z - vector4f.z) < eps && Math.abs(this.w - vector4f.w) < eps;
    }


    public Vector3f toVector3f() {
        return new Vector3f(this.x, this.y, this.z);
    }

    public static Vector4f add(Vector4f vector1, Vector4f vector2) {
        return new Vector4f(vector1.x + vector2.x,  vector1.y + vector2.y, vector1.z + vector2.z, vector1.w + vector2.w);
    }

    public static Vector4f subtract(Vector4f vector1, Vector4f vector2) {
        return new Vector4f(vector1.x - vector2.x, vector1.y - vector2.y, vector1.z - vector2.z, vector1.w - vector2.w);
    }

    public void multiply(float scalar) {
        this.x = x * scalar;
        this.y = y * scalar;
        this.z = z * scalar;
        this.w = w * scalar;
    }


    public void divide(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.x = x / scalar;
        this.y = y / scalar;
        this.z = z / scalar;
        this.w = w / scalar;
    }


    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    public void normalize() throws ArithmeticException {
        float length = length();
        if (Math.abs(length) < eps) {
            throw new ArithmeticException("Cannot normalize a vector with zero length.");
        }
        this.divide(length);
    }

    public static float dotProduct(Vector4f vector1, Vector4f vector2) {
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z + vector1.w * vector2.w;
    }



    @Override
    public String toString() {
        return "Vector4f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }
}
