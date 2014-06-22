import java.awt.Color;

/**
 * inheritance
 * Created by zhumeng on 2014/6/11.
 */
public class ColorPointI extends Point {
    private final Color color;

    public ColorPointI(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    // violates Liskov substitution principle
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        Point p = (Point) o;
        return p.equals(this);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPointI cp = new ColorPointI(1, 2, Color.RED);
        System.out.println(p.equals(cp) + ";" + cp.equals(p));
    }
}
