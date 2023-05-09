package pointFour;

public class PointFour {
    public int num = 5;

    public PointFour() {
        System.out.println(toString());
    }

    public int getFactorial() {
        int factorial = 1;
        for (int i = this.num; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public String toString() {
        String result = "Factorial: " + this.num +"! = ";
        for (int i = 1; i <= this.num; i++) {
            result += i + " * ";
        }
        result = result.substring(0, result.length() - 2) + "= " + getFactorial();
        return result;
    }
}
