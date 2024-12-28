package jaiz.jaizmod.entity.bandit;

import java.util.Arrays;
import java.util.Comparator;

public enum BanditVariant {
    ORIGINAL(0),
    RED_MASK(1),
    GLOVES(2),
    BROWN_SHIRT(3),
    HAT(4),
    PAINTED(5),
    HAND_PRINT(6),
    SKI_MASK(7),
    RED(8),
    GREEN(9),
    BLUE(10);


    private static final BanditVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BanditVariant::getId)).toArray(BanditVariant[]::new);
    private final int id;

    BanditVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BanditVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
