/**
 * Created by zhumeng on 2014/6/11.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point A = new Point(1, 2);
        Point B = new Point(1, 2);
        Point C = new Point(1, 3);
        System.out.println("A==B?" + A.equals(B) + "; A==C?" + A.equals(C));
    }
}
