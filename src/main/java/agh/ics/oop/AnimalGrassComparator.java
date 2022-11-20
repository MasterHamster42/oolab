package agh.ics.oop;

import java.util.Comparator;
import java.util.Objects;

public class AnimalGrassComparator implements Comparator<AbstractMapObject> {
    boolean primaryAxisIsX;
    public AnimalGrassComparator(boolean axis){
        primaryAxisIsX = axis;
    }
    @Override
    public int compare(AbstractMapObject o1, AbstractMapObject o2) {
        if (primaryAxisIsX){
            if (o1.position.x != o2.position.x) return o1.position.x - o2.position.x;
            if (o1.position.y != o2.position.y) return o1.position.y - o2.position.y;
        }
        else {
            if (o1.position.y != o2.position.y) return o1.position.y - o2.position.y;
            if (o1.position.x != o2.position.x) return o1.position.x - o2.position.x;
        }
        if (Objects.equals(o1.type, "Grass")) return -1;
        if (Objects.equals(o1.type, "Animal")) return 1;
        return 0;
    }
}
