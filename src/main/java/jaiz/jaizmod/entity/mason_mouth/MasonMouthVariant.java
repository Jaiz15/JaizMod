package jaiz.jaizmod.entity.mason_mouth;

import java.util.Arrays;
import java.util.Comparator;

public enum MasonMouthVariant {
    ORIGINAL(0),
    ANGLER(1),
    ARCHER(2),
    ARMS_UP(3),
    BLADE(4),
    BREWER(5),
    BURN(6),
    DANGER(7),
    EXPLORER(8),
    FLOW(9),
    FRIEND(10),
    GUSTER(11),
    HEART(12),
    HEARTBREAK(13),
    HOWL(14),
    MINER(15),
    MOURNER(16),
    PLENTY(17),
    PRIZE(18),
    SCRAPE(19),
    SHEAF(20),
    SHELTER(21),
    SKULL(22),
    SNORT(23),
    GILDED(24),
    CLAY(25);


    private static final MasonMouthVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(MasonMouthVariant::getId)).toArray(MasonMouthVariant[]::new);
    private final int id;

    MasonMouthVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static MasonMouthVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
