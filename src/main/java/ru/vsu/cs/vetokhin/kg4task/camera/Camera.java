package ru.vsu.cs.vetokhin.kg4task.camera;


import ru.vsu.cs.vetokhin.kg4task.math.matrices.Matrix4f;
import ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f;
import ru.vsu.cs.vetokhin.kg4task.render.GraphicConveyor;

import static ru.vsu.cs.vetokhin.kg4task.math.vectors.Vector3f.add;

public class Camera {

    private Vector3f position;
    private Vector3f target;
    private float fov;
    private float aspectRatio;
    private float nearPlane;
    private float farPlane;

    public Camera(Vector3f position, Vector3f target, float fov, float aspectRatio, float nearPlane, float farPlane) {
        this.farPlane = farPlane;
        this.nearPlane = nearPlane;
        this.target = target;
        this.aspectRatio = aspectRatio;
        this.position = position;
        this.fov = fov;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getTarget() {
        return target;
    }

    public float getFov() {
        return fov;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public float getFarPlane() {
        return farPlane;
    }

    public float getNearPlane() {
        return nearPlane;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setTarget(Vector3f target) {
        this.target = target;
    }

    public void setFov(float fov) {
        this.fov = fov;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public void setNearPlane(float nearPlane) {
        this.nearPlane = nearPlane;
    }

    public void setFarPlane(float farPlane) {
        this.farPlane = farPlane;
    }

    public void movePosition(final Vector3f tanslation) {
        this.position = add(this.position, tanslation);
    }

    public void moveTarget(final Vector3f target) {
        this.target = add(this.target, target);
    }

    public Matrix4f getViesMatrix() {
        return GraphicConveyor.lookAt(position, target);
    }

    public Matrix4f getProjectrionMatrix() {
        return GraphicConveyor.perspective(fov, aspectRatio, nearPlane, farPlane);
    }

}
