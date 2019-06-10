package pl.calculator.university.interfacesExtends;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circle1 extends Circle implements CircleColour {

    Circle circle;

    public Circle1() {
        circle = new Circle(150, 150, 40);

    }

    @Override
    public void setCircleColor() {
        circle.setFill(Color.RED);
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
