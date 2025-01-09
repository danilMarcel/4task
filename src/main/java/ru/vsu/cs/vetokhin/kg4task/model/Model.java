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


//    public void findNormals() {
//        normals = (ArrayList<Vector3f>) Normals.normale(vertices, polygons);
//    }
//    public void triangulate() {
//        polygons = (ArrayList<Polygon>) Triangulation.triangulate(polygons);
//    }

}



















































/*

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    public String name;
    public boolean verticesVisible = false;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isVerticesVisible() {
        return verticesVisible;
    }
    public void setVerticesVisible(boolean verticesVisible) {
        this.verticesVisible = verticesVisible;
    }


    // https://github.com/SysoevaSvetlana/CGtask3/blob/main/ObjReaderInitial/src/com/cgvsu/model/Model.java
    public void computeNormals() {

        Map<Integer, Vector3f> vertexNormals = new HashMap<>();
        Map<Integer, Integer> vertexNormalsCount = new HashMap<>();


        for (Polygon polygon : polygons) {
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            if (vertexIndices.size() < 3) {
                continue;
            }

            Vector3f v0 = vertices.get(vertexIndices.get(0));
            Vector3f v1 = vertices.get(vertexIndices.get(1));
            Vector3f v2 = vertices.get(vertexIndices.get(2));

            Vector3f edge1 = v1.sub(v0);
            Vector3f edge2 = v2.sub(v0);
            Vector3f faceNormal = edge1.cross(edge2).normalize();

            for (int index : vertexIndices) {
                vertexNormals.compute(index, (k, v) -> {
                    if (v == null) {
                        return faceNormal.copy();
                    } else {
                        return v.add(faceNormal);
                    }
                });
            }

            for (int index : vertexIndices) {

                if (vertexNormalsCount.containsKey(index)) {
                    vertexNormalsCount.put(index, vertexNormalsCount.get(index) + 1);
                } else {
                    vertexNormalsCount.put(index,1);
                }

            }
        }

        for (Integer index : vertexNormals.keySet()) {
            vertexNormals.put(index, vertexNormals.get(index).div(vertexNormalsCount.get(index)));
        }

        normals = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            normals.add(vertexNormals.getOrDefault(i, new Vector3f(0, 0, 0)));
        }
    }
}
 */