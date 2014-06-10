/**
 * Created by zhumeng on 2014/6/8.
 */
// Enum singleton - the preferred approach
public enum Singleton {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Leaving the building");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.leaveTheBuilding();
    }
}

