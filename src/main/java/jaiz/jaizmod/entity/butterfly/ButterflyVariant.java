package jaiz.jaizmod.entity.butterfly;

import java.util.Arrays;
import java.util.Comparator;

public enum ButterflyVariant {
    MONARCH(0),
    WHITE_MONARCH(1),
    YELLOW_MONARCH(2),
    ATLAS_MOTH(3),
    CABBAGE_MOTH(4),
    ULYSSES(5),
    CARINS_BIRDWING(6),
    LUNA_MOTH(7),
    JAMPOTT(8);

    private static final ButterflyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ButterflyVariant::getId)).toArray(ButterflyVariant[]::new);
    private final int id;

    ButterflyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ButterflyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
