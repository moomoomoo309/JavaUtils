import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MultiRange implements IRange {
    ArrayList<Range> ranges = new ArrayList<>();

    public MultiRange() {
        this(new Range());
    }

    public MultiRange(Range... ranges) {
        Arrays.stream(ranges).forEach(this.ranges::add);
    }

    public MultiRange(Collection<Range> ranges) {
        this.ranges.addAll(ranges);
    }

    public ArrayList<Range> getRanges() {
        return ranges;
    }


    public boolean isExclusive(int index) {
        return ranges.get(index).exclusive;
    }

    public void setExclusive(int index, boolean ex) {
        ranges.get(index).exclusive = ex;
    }

    public boolean inRange(double num) {
        return ranges.stream().anyMatch(r -> r.inRange(num));
    }

    public int randIntInRange() {
        return ranges.get((int) (Math.random() * (ranges.size() + 1))).randIntInRange();
    }

    public double randDoubleInRange() {
        return ranges.get((int) (Math.random() * (ranges.size() + 1))).randDoubleInRange();
    }

    @Override
    public int hashCode() {
        return ranges != null ? ranges.hashCode(): 0;
    }

    @Override
    public boolean equals(Object r) {
        return r instanceof Range ? ranges.size() == 1 && ranges.get(0).equals((Range) r): r instanceof MultiRange && ranges.equals(((MultiRange) r).ranges);
    }

    public String toString() {
        StringBuilder str = new StringBuilder("between ");
        ranges.forEach(r -> str.append(r.toString().substring(6)).append(" or "));
        return str.toString().substring(0, str.lastIndexOf(" "));
    }
}
