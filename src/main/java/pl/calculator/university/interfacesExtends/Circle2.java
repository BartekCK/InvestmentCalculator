package pl.calculator.university.interfacesExtends;

import javafx.scene.shape.Circle;

public class Circle2 extends Circle implements CircleSize {

    Circle circle;

    public Circle2() {
        circle = new Circle(300, 300, 40);
    }

    @Override
    public void setCircleSize(double radious) {
        circle.setRadius(radious);
    }

    @Override
    public Circle getCircle() {
        return circle;
    }
}
