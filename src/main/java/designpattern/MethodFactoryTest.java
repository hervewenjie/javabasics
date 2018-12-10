package designpattern;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class MethodFactoryTest {
}

interface Factory {
    Shape createShape();
}

class Shape {}

class Circle extends Shape {}

class Rectangle extends Shape {}

class CircleFactory implements Factory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements Factory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}