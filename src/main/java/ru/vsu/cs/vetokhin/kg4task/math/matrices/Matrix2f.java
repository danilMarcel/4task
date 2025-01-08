package ru.vsu.cs.vetokhin.kg4task.math.matrices;


import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;

import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f.dotProduct;

public class Matrix2f {
    private Vector2f v1;
    private Vector2f v2;

    public Matrix2f() {
        this.v1 = new Vector2f();
        this.v2 = new Vector2f();
    }

    public Matrix2f(Vector2f v1, Vector2f v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vector2f getV1() {
        return v1;
    }

    public Vector2f getV2() {
        return v2;
    }

    public void setV1(Vector2f v1) {
        this.v1 = v1;
    }

    public void setV2(Vector2f v2) {
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix2f matrix2f = (Matrix2f) o;
        return this.v1.equals(matrix2f.getV1()) && this.v2.equals(matrix2f.getV2());
    }

    public Matrix2f(float[] matrix) throws IllegalArgumentException {
        if (matrix.length != 4) {
            throw new IllegalArgumentException("Length must be 4");
        }
        this.v1 = new Vector2f(matrix[0], matrix[1]);
        this.v2 = new Vector2f(matrix[2], matrix[3]);
    }

    public static Matrix2f unitMatrix() {
        return new Matrix2f(new Vector2f(1, 0), new Vector2f(0, 1));
    }

    public static Matrix2f zeroMAtrix() {
        return new Matrix2f(new Vector2f(), new Vector2f());
    }

    public  static Matrix2f add(Matrix2f matrix1, Matrix2f matrix2) {
        Matrix2f result = new Matrix2f();
        result.setV1(Vector2f.add(matrix1.v1, matrix2.v1));
        result.setV2(Vector2f.add(matrix1.v2, matrix2.v2));
        return result;
    }

    public static Matrix2f subtract(Matrix2f matrix1, Matrix2f matrix2) {
        Matrix2f result = new Matrix2f();
        result.setV1(Vector2f.subtract(matrix1.v1, matrix2.v1));
        result.setV2(Vector2f.subtract(matrix1.v2, matrix2.v2));
        return result;
    }

    public static Vector2f multiply(Matrix2f matrix2f, Vector2f vector2f) {
        return new Vector2f(dotProduct(matrix2f.v1, vector2f), dotProduct(matrix2f.v2, vector2f));
    }


    public static Matrix2f multiply(Matrix2f matrix1, Matrix2f matrix2) {
        Vector2f v1Result = new Vector2f();
        v1Result.setX(Vector2f.dotProduct(matrix1.v1, new Vector2f(matrix2.v1.getX(), matrix2.v2.getX())));
        v1Result.setY(Vector2f.dotProduct(matrix1.v1, new Vector2f(matrix2.v1.getY(), matrix2.v2.getY())));

        Vector2f v2RElust = new Vector2f();
        v2RElust.setX(Vector2f.dotProduct(matrix1.v2, new Vector2f(matrix2.v1.getX(), matrix2.v2.getX())));
        v2RElust.setY(Vector2f.dotProduct(matrix1.v2, new Vector2f(matrix2.v1.getY(), matrix2.v2.getY())));

        return new Matrix2f(v1Result, v2RElust);
    }

    public Matrix2f transpose() {
        Vector2f v1Result = new Vector2f();
        v1Result.setX(this.v1.getX());
        v1Result.setY(this.v2.getX());

        Vector2f v2Result = new Vector2f();
        v2Result.setX(this.v1.getY());
        v2Result.setY(this.v2.getY());

        return new Matrix2f(v1Result, v2Result);
    }

    public float determinant() {
        return this.v1.getX() * this.v2.getY() - this.v1.getY() * this.v2.getX();
    }



    @Override
    public String toString() {
        return "Matrix2f{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }

}
