class EvenThread extends Thread {
    private int limit;

    public EvenThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 2; i <= limit; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for a while to simulate slower execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddThread extends Thread {
    private int limit;

    public OddThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for a while to simulate slower execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int evenLimit = 10; // Print even numbers up to 10
        int oddLimit = 15;  // Print odd numbers up to 15

        EvenThread evenThread = new EvenThread(evenLimit);
        OddThread oddThread = new OddThread(oddLimit);

        evenThread.start();
        oddThread.start();
    }
}
