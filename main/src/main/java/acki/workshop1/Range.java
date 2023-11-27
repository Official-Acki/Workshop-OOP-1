package acki.workshop1;

/**
 * Range
 */
public class Range {
    private double low, high;

    public Range(double low, double high) {
        this.low = low;
        this.high = high;
    }

    /**
     * <p>This method evaluates the input value agains the low and hight.</p>
     * <p>If it's lower than low, it returns 1.</p>
     * <p>If it's higher than high, it returns 2.</p>
     * <p>Otherwise, it returns 0. As it is inside the range.</p>
     * @param input the input value to compare
     * @return <pre>short 0, 1 or 2</pre>
     */
    public short evaluate(double input) {
        if (input < low) {
            return 1;
        } else if (input > high) {
            return 2;
        } else {
            return 0;
        }
    }
}