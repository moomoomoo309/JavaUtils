/**
 * An interface outlining all behavior that should be defined for a range.
 */
public interface IRange {
    /**
     * @return A random integer within the range.
     */
    int randIntInRange();

    /**
     * @return A random double within the range.
     */
    double randDoubleInRange();

    /**
     * @param num A number to check
     * @return Whether num is inside the range.
     */
    boolean inRange(double num);
}
