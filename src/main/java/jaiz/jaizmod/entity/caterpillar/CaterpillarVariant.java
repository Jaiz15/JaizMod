package jaiz.jaizmod.entity.caterpillar;

import java.util.Arrays;
import java.util.Comparator;

public enum CaterpillarVariant {
    YELLOW(0),
    GREEN_RED(1),
    GREEN(2);


    private static final CaterpillarVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CaterpillarVariant::getId)).toArray(CaterpillarVariant[]::new);
    private final int id;

    CaterpillarVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CaterpillarVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
