import java.time.LocalDateTime;

class Square {
    private int side;
    private LocalDateTime creationDateTime;

    // Non-parameterized constructor
    public Square() {
        this.side = 0;
        this.creationDateTime = LocalDateTime.now();
    }

    // Parameterized constructor
    public Square(int side) {
        this.side = side;
        this.creationDateTime = LocalDateTime.now();
    }

    // Getter for side
    public int getSide() {
        return side;
    }

    // Setter for side
    public void setSide(int side) {
        this.side = side;
    }

    // Getter for creationDateTime
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public int getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square (Side: " + side + ", Area: " + getArea() + ", Created: " + creationDateTime + ")";
    }
}
class Node {
    Square data;
    Node next;

    public Node(Square square) {
        this.data = square;
        this.next = null;
    }
}

class SquareLinkedList {
    Node head;

    public SquareLinkedList() {
        this.head = null;
    }

    public void insert(Square square) {
        Node newNode = new Node(square);
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
        SquareLinkedList squareList = new SquareLinkedList();

        Square square1 = new Square(5);
        Square square2 = new Square(7);
        Square square3 = new Square(3);

        squareList.insert(square1);
        squareList.insert(square2);
        squareList.insert(square3);

        squareList.display();
    }
}
