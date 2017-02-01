import java.util.List;

public class Range implements IRange {
    double low, high;
    boolean exclusive = false;

    /**
     * Makes a range from 0 to 0.
     */
    public Range() {
        low = 0;
        high = 0;
    }

    /**
     * Makes a range from a to a.
     *
     * @param a The high and low of the range.
     */
    public Range(double a) {
        low = a;
        high = a;
    }

    /**
     * Makes a range between a and b.
     *
     * @param a The high or low
     * @param b The high or low
     */
    public Range(double a, double b) {
        low = a < b ? a: b;
        high = a < b ? b: a;
    }

    /**
     * Makes an inclusive/exclusive range from a to b.
     *
     * @param a  The high or low
     * @param b  The high or low
     * @param ex Whether or not the range is exclusive.
     */
    public Range(double a, double b, boolean ex) {
        this(a, b);
        exclusive = ex;
    }

    /**
     * Makes a range using the array provided.
     *
     * @param a The array provided.
     */
    public Range(double[] a) {
        double num1, num2;
        if (a.length > 1) {
            num1 = a[0];
            num2 = a[1];
            low = num1 < num2 ? num1: num2;
            high = num1 > num2 ? num1: num2;
        } else {
            num1 = a[0];
            low = num1;
            high = num1;
        }
    }

    /**
     * Makes an inclusive/exclusive range using the array provided.
     *
     * @param a  The array provided.
     * @param ex Whether or not the range is exclusive.
     */
    public Range(double[] a, boolean ex) {
        this(a);
        exclusive = ex;
    }

    public Range(Number[] a) {
        double num1, num2;
        if (a.length > 1) {
            num1 = a[0].doubleValue();
            num2 = a[1].doubleValue();
            low = num1 < num2 ? num1: num2;
            high = num1 > num2 ? num1: num2;
        } else {
            num1 = a[0].doubleValue();
            low = num1;
            high = num1;
        }
    }

    public Range(Number[] a, boolean ex) {
        this(a);
        exclusive = ex;
    }

    /**
     * Makes a range given a list.
     *
     * @param a The given list.
     */
    public Range(List<Number> a) {
        double num1, num2;
        switch (a.size()) {
            case 1:
                num1 = a.get(0).doubleValue();
                low = num1;
                high = num1;
                break;
            case 0:
                low = 0;
                high = 0;
                break;
            default:
                num1 = a.get(0).doubleValue();
                num2 = a.get(1).doubleValue();
                low = num1 < num2 ? num1: num2;
                high = low == num2 ? num1: num2;
                break;
        }
    }

    /**
     * Returns the lower bound of the range.
     *
     * @return The lower bound of the range.
     */
    public double getLow() {
        return low;
    }

    /**
     * Sets the lower bound of the range.
     *
     * @param a The new lower bound of the range.
     */
    public void setLow(double a) {
        low = a;
    }

    /**
     * Returns the upper bound of the range.
     *
     * @return The upper bound of the range.
     */
    public double getHigh() {
        return high;
    }

    /**
     * Sets the upper bound of the range.
     *
     * @param a The new upper bound of the range.
     */
    public void setHigh(double a) {
        high = a;
    }

    /**
     * Returns whether or not this range is exclusive.
     *
     * @return Whether or not this range is exclusive.
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets whether or not this range is exclusive.
     *
     * @param ex Whether this range is exclusive.
     */
    public void setExclusive(boolean ex) {
        this.exclusive = ex;
    }

    /**
     * Returns whether num is inside of the range.
     *
     * @param num The number to check
     * @return If the number is in the range.
     */
    public boolean inRange(double num) {
        return exclusive && (num > low && num < high) || (num >= low && num <= high);
    }

    /**
     * Returns a random integer within the range.
     *
     * @return A random integer within the range.
     */
    public int randIntInRange() {
        return (int) low + (int) (Math.random() * (high - low) + 1);
    }

    /**
     * Returns a random double within the range.
     *
     * @return A random double within the range.
     */
    public double randDoubleInRange() {
        return low + (Math.random() * (high - low) + 1);
    }

    /**
     * Converts the range to a string, in the form "between low and high".
     *
     * @return The range as a string.
     */
    public String toString() {
        return "between " + low + " and " + high;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(low);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (exclusive ? 1: 0);
        return result;
    }

    /**
     * Returns whether or not the given range is equivalent to this one.
     *
     * @param r The other range to check for equality
     * @return If they are equal.
     */
    public boolean equals(Range r) {
        return r.getLow() == low && r.getHigh() == high && r.isExclusive() == exclusive;
    }
}
