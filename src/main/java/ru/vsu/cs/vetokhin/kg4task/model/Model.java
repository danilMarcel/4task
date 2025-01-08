package ru.vsu.cs.vetokhin.kg4task.model;

import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector2f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;

import java.util.ArrayList;

public class Model {
    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();


    public Model() {
        this.vertices = new ArrayList<>();
        this.textureVertices = new ArrayList<>();
        this.normals = new ArrayList<>();
        this.polygons = new ArrayList<>();
    }


    public ArrayList<Vector2f> cloneTextureVertices() {
        ArrayList<Vector2f> clonedTextureVertices = new ArrayList<>();
        for (Vector2f textureVertex : this.textureVertices) {
            clonedTextureVertices.add(textureVertex.clone());
        }
        return clonedTextureVertices;
    }


    public ArrayList<Vector3f> cloneNormals() {
        ArrayList<Vector3f> clonesNormals = new ArrayList<>();
        for (Vector3f normal : this.normals) {
            clonesNormals.add(normal.clone());
        }
        return clonesNormals;
    }


}
