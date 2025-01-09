package ru.vsu.cs.vetokhin.kg4task.model;

import java.util.ArrayList;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        assert vertexIndices.size() >= 3;
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        assert textureVertexIndices.size() >= 3;
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        assert normalIndices.size() >= 3;
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }

//    @Override
//    public Polygon clone() {
//        try {
//            Polygon clonedPolygon = (Polygon) super.clone();
//
//            // Глубокое копирование списков
//            clonedPolygon.vertexIndices = new ArrayList<>(this.vertexIndices);
//            clonedPolygon.textureVertexIndices = new ArrayList<>(this.textureVertexIndices);
//            clonedPolygon.normalIndices = new ArrayList<>(this.normalIndices);
//
//            return clonedPolygon;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError(); // Этот код никогда не должен выполняться
//        }

}
