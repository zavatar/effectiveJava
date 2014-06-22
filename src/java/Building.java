import java.lang.Object;

/**
 * Item 2: Consider a builder when faced with many constructor parameters
 * Created by zhumeng on 2014/6/9.
 */
public class Building extends Object{

    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public static class Builder {
        // Required parameters
        private final int a;
        // Optional parameters - initialized to default values
        private int b = 0;
        private int c = 0;
        private int d = 0;

        public Builder(int a) {
            this.a = a;
        }
        public Builder setB(int b) {
            this.b = b; return this;
        }
        public Builder setC(int c) {
            this.c = c; return this;
        }
        public Builder setD(int d) {
            this.d = d; return this;
        }
        public Building build() {
            return new Building(this);
        }
    }
    private Building(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
    }

    public String toString() {
        return "{" + a + "," + b + "," + c + "," + d + "}";
    }

    public static void main(String[] args) {
        // chaining the new op
        Building building = new Building.Builder(1).setB(2).setC(3).build();
        System.out.println("Building: " + building);
    }

}
