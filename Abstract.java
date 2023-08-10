import java.util.Random;

class Shape {
    String type;
    double area;

    public Shape(String type, double area) {
        this.type = type;
        this.area = area;
    }

    @Override
    public String toString() {
        return type + " (Area: " + area + ")";
    }
}

class Node {
    Shape data;
    Node next;

    public Node(Shape shape) {
        this.data = shape;
        this.next = null;
    }
}

class ShapeLinkedList {
    Node head;

    public ShapeLinkedList() {
        this.head = null;
    }

    public void insert(Shape shape) {
        Node newNode = new Node(shape);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeLinkedList shapeList = new ShapeLinkedList();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int shapeType = random.nextInt(3); // 0: Square, 1: Rectangle, 2: Triangle
            double area = random.nextDouble() * 100; // Random area between 0 and 100

            String type;
            if (shapeType == 0) {
                type = "Square";
            } else if (shapeType == 1) {
                type = "Rectangle";
            } else {
                type = "Triangle";
            }

            Shape shape = new Shape(type, area);
            shapeList.insert(shape);
        }

        shapeList.display();
    }
}
interface IShape {
    void draw();
}

class Square implements IShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square with side: " + side);
    }
}

class Rectangle implements IShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with width: " + width + " and height: " + height);
    }
}

class Triangle implements IShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle with base: " + base + " and height: " + height);
    }
}

public class Main {
    public static void main(String[] args) {
        IShape[] shapes = new IShape[3];
        
        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4);
        
        for (IShape shape : shapes) {
            shape.draw();
        }
    }
}
