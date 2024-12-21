package jaiz.jaizmod.entity.dragonfly;

import java.util.Arrays;
import java.util.Comparator;

public enum DragonflyVariant {
    BLUE(0),
    AQUA_YELLOW(1),
    RED_GREEN(2),
    RED(3),
    GRAY(4),
    AQUA(5),
    ORANGE(6);


    private static final DragonflyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DragonflyVariant::getId)).toArray(DragonflyVariant[]::new);
    private final int id;

    DragonflyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DragonflyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
