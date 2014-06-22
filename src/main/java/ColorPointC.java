import java.awt.Color;

/**
 * composition.
 * Created by zhumeng on 2014/6/11.
 */
public class ColorPointC {
    private final Point point;
    private final Color color;

    public ColorPointC(int x, int y, Color color) {
        if (color == null) throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }
    // returns the point-view of this color point
    public Point asPoint() {
        return point;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointC)) return false;
        ColorPointC cp = (ColorPointC) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPointC cp = new ColorPointC(1, 2, Color.RED);
        System.out.println(p.equals(cp.asPoint()) + ";" + cp.asPoint().equals(p));
    }
}
