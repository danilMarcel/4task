package ru.vsu.cs.vetokhin.kg4task.math.vectors;

import java.util.Objects;

public class Vector2f {
    private float x;
    private float y;
    private final float eps = 1e-7f;


    public Vector2f() {
        this.x = 0;
        this.y = 0;
    }


    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2f vector2f = (Vector2f) o;
        return Math.abs(this.x - vector2f.x) <  eps && Math.abs(this.y - vector2f.y) < eps;
    }

    public static Vector2f add(Vector2f vector1, Vector2f vector2) {
        return new Vector2f(vector1.x + vector2.x, vector1.y + vector2.y);
    }

    public static Vector2f subtract(Vector2f vector1, Vector2f vector2) {
        return new Vector2f(vector1.x - vector2.x, vector1.y - vector2.y);
    }


    public void multiply(float scalar) {
        this.x = x * scalar;
        this.y = y * scalar;
    }

    public void divide(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < eps) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.x = x / scalar;
        this.y = y / scalar;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }


    public void normalize() throws ArithmeticException {
        float length = length();
        if (Math.abs(length) < eps) {
            throw new ArithmeticException("Normalization of a zero vector is not allowed.");
        }
        this.divide(length);
    }

    public static float dotProduct(Vector2f vector1, Vector2f vector2) {
        return vector1.x * vector2.x + vector1.y * vector2.y;
    }

    @Override
    public Vector2f clone() {
        try {
            return (Vector2f) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Vector2f{" + "x=" + x + ", y=" + y + "}";
    }
}
