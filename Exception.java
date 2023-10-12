class MySpecialNumberException extends Exception {
    public MySpecialNumberException(String message) {
        super(message);
    }
}
class Main {
    public static void myfunc(int x) throws MySpecialNumberException {
        if (x == 10) {
            throw new MySpecialNumberException("Input cannot be 10.");
        } else if (x == 20) {
            throw new MySpecialNumberException("Input cannot be 20.");
        } else if (x == 30) {
            throw new MySpecialNumberException("Input cannot be 30.");
        }
        
    }

    public static void main(String[] args) {
        int input = 30; 

        try {
            myfunc(input);
        } catch (MySpecialNumberException e) {
            System.out.println("Caught MySpecialNumberException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");}
        
    }
}
