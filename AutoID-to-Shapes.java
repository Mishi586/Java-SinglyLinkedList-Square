import java.util.Date;

// Shape class (Base class)
class Shape {
    private int shapeID;
    private Date creationTime;

    public Shape() {
        this.shapeID = ShapeIDGenerator.getNextID();
        this.creationTime = new Date();
    }

    public int getShapeID() {
        return shapeID;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();  // Calls the constructor of the base class (Shape)
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}


class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        super();  // Calls the constructor of the base class (Shape)
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}


class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super();  // Calls the constructor of the base class (Shape)
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}

// Node class for the singly linked list
class ShapeNode {
    private Shape shape;
    private ShapeNode next;

    public ShapeNode(Shape shape) {
        this.shape = shape;
        this.next = null;
    }

    public Shape getShape() {
        return shape;
    }

    public ShapeNode getNext() {
        return next;
    }

    public void setNext(ShapeNode next) {
        this.next = next;
    }
}

// Shared variable for auto-incrementing IDs
class ShapeIDGenerator {
    private static int nextID = 1;

    public static int getNextID() {
        return nextID++;
    }
}

// LinkedList to store shapes
class ShapeLinkedList {
    private ShapeNode head;

    public void addShape(Shape shape) {
        ShapeNode newNode = new ShapeNode(shape);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    // Add other methods to manipulate the linked list if needed
}

public class Main {
    public static void main(String[] args) {
        ShapeLinkedList shapeList = new ShapeLinkedList();

        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        shapeList.addShape(rectangle);
        shapeList.addShape(square);
        shapeList.addShape(triangle);

        // Display the IDs and creation times of shapes
        ShapeNode currentNode = shapeList.head;
        while (currentNode != null) {
            Shape currentShape = currentNode.getShape();
            System.out.println("Shape ID: " + currentShape.getShapeID());
            System.out.println("Creation Time: " + currentShape.getCreationTime());
            currentNode = currentNode.getNext();
        }
    }
}
