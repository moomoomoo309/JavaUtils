public class MiscUtils {
    /**
     * Returns a random array of ints with the given length whose values are within the given range.
     *
     * @param length The length of the array
     * @param range The range of the values allowed
     *
     * @return The created array
     */
    public int[] randIntArray(int length, IRange range) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = range.randIntInRange();
        return arr;
    }

    /**
     * Returns a random 2D int array with size [length][length2] whose values are within the given range.
     *
     * @param length The length of the outer array
     * @param length2 The length of the inner array
     * @param range The range of the values allowed
     *
     * @return The created 2D array
     */
    public int[][] rand2DIntArray(int length, int length2, IRange range) {
        int[][] arr = new int[length][length2];
        for (int i = 0; i < arr.length; i++)
            arr[i] = randIntArray(length2, range);
        return arr;
    }

    /**
     * Returns a random array of doubles with the given length whose values are within the given range.
     *
     * @param length The length of the array
     * @param range The range of the values allowed
     *
     * @return The created array
     */
    public double[] randDoubleArray(int length, IRange range) {
        double[] arr = new double[length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = range.randDoubleInRange();
        return arr;
    }

    /**
     * Returns a random 2D double array with size [length][length2] whose values are within the given range.
     *
     * @param length The length of the outer array
     * @param length2 The length of the inner array
     * @param range The range of the values allowed
     *
     * @return The created 2D array
     */
    public double[][] rand2DDoubleArray(int length, int length2, IRange range) {
        double[][] arr = new double[length][length2];
        for (int i = 0; i < arr.length; i++)
            arr[i] = randDoubleArray(length2, range);
        return arr;
    }

    /**
     * Returns a random array of chars with the given length whose values are within the given range.
     *
     * @param length The length of the array
     * @param range The range of the values allowed
     *
     * @return The created array
     */
    public char[] randCharArray(int length, IRange range) {
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (char) range.randIntInRange();
        return arr;
    }

    /**
     * Returns a random 2D char array with size [length][length2] whose values are within the given range.
     *
     * @param length The length of the outer array
     * @param length2 The length of the inner array
     * @param range The range of the values allowed
     *
     * @return The created 2D array
     */
    public char[][] rand2DCharArray(int length, int length2, IRange range) {
        char[][] arr = new char[length][length2];
        for (int i = 0; i < arr.length; i++)
            arr[i] = randCharArray(length2, range);
        return arr;
    }

    /**
     * Returns a new string of the given length with characters within the given range.
     *
     * @param length The length of the string
     * @param range The range of allowed characters
     *
     * @return The new random string
     */
    public String randString(int length, IRange range) {
        return new String(randCharArray(length, range));
    }

    /**
     * Creates an array of length size of length2 long random strings whose characters are within the given range.
     *
     * @param length The length of the array
     * @param length2 The length of the strings
     * @param range The range of allowed characters
     *
     * @return The new random string array
     */
    public String[] randStringArray(int length, int length2, IRange range) {
        String[] arr = new String[length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = randString(length2, range);
        return arr;
    }

    /**
     * Creates a 2D array of size [length][length2] of length3 long random strings whose characters are within the given range.
     *
     * @param length The length of the outer array
     * @param length2 The length of the inner array
     * @param length3 The length of the strings
     * @param range The range of allowed characters
     *
     * @return The new random 2D string array
     */
    public String[][] rand2DStringArray(int length, int length2, int length3, IRange range) {
        String[][] arr = new String[length][length2];
        for (int i = 0; i < arr.length; i++)
            arr[i] = randStringArray(length2, length3, range);
        return arr;
    }

    /**
     * Returns if the difference between a and b is less than acc.
     *
     * @param a The first number
     * @param b The second number
     * @param acc The range they're within
     *
     * @return If they are within that range
     */
    public boolean doubleEqual(double a, double b, double acc) {
        return Math.abs(a - b) < acc;
    }

    /**
     * Returns if all of the objects in the given array are equal.
     *
     * @param objs The objects to compare
     *
     * @return If they are all equal.
     */
    public boolean allEqual(Object[] objs) {
        for (int i = 1; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (!objs[j].equals(objs[i]))
                    return false;
        return true;
    }

    /**
     * Returns if all of the doubles in the given array are equal.
     *
     * @param objs The doubles to compare
     *
     * @return If they are all equal.
     */
    public boolean allEqual(double[] objs) {
        for (int i = 1; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (!this.doubleEqual(objs[j], objs[i], .000001))
                    return false;
        return true;
    }

    /**
     * Returns if at least two objects in the array are equal. (if any "duplicates" exist)
     *
     * @param objs The objects to compare
     *
     * @return If any of them are equal
     */
    public boolean someEqual(Object[] objs) {
        for (int i = 0; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (objs[i].equals(objs[j]))
                    return true;
        return false;
    }

    /**
     * Returns if at least two doubles in the array are equal. (if any "duplicates" exist)
     *
     * @param objs The doubles to compare
     *
     * @return If any of them are equal
     */
    public boolean someEqual(double[] objs) {
        for (int i = 0; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (this.doubleEqual(objs[i], objs[j], .000001))
                    return true;
        return false;
    }

    /**
     * Returns the indices of two equal objects in the given array, or null if no objects in the array are equal.
     *
     * @param objs The objects to compare
     *
     * @return The indices of the equal objects.
     */
    public int[] twoEqual(Object[] objs) {
        for (int i = 0; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (objs[i].equals(objs[j]))
                    return new int[] {i, j};
        return null;
    }

    /**
     * Returns the indices of two equal doubles in the given array, or null if no doubles in the array are equal.
     *
     * @param objs The doubles to compare
     *
     * @return The indices of the equal doubles.
     */
    public int[] twoEqual(double[] objs) {
        for (int i = 0; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (this.doubleEqual(objs[i], objs[j], .000001))
                    return new int[] {i, j};
        return null;
    }

    /**
     * Returns the indices of two equal ints in the given array, or null if no doubles in the array are equal.
     *
     * @param objs The doubles to compare
     *
     * @return The indices of the equal doubles.
     */
    public int[] twoEqual(int[] objs) {
        for (int i = 0; i < objs.length; i++)
            for (int j = i + 1; j < objs.length; j++)
                if (this.doubleEqual(objs[i], objs[j], .000001))
                    return new int[] {i, j};
        return null;
    }
}
