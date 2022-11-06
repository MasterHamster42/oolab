package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{
    private int AmountOfGrass;
    private ArrayList<Grass> grasses = new ArrayList<Grass>();

    public GrassField(int amountOfGrass){
        AmountOfGrass = amountOfGrass;
        for (int i = 0; i<amountOfGrass; i++){
            this.placeGrass();
        }
    }

    private void placeGrass(){
        Vector2d place_grass_at;
        do {
            int x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(AmountOfGrass*10));
            int y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(AmountOfGrass*10));
            place_grass_at = new Vector2d(x,y);
        }while (isOccupied(place_grass_at));
        grasses.add(new Grass(place_grass_at));
    }

    @Override
    protected boolean coordinateOnMap(Vector2d position) {
        return position.x < Integer.MAX_VALUE && position.x > Integer.MIN_VALUE &&
                position.y < Integer.MAX_VALUE && position.y > Integer.MIN_VALUE;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        checkAnimalOnGrass(position);
        return super.canMoveTo(position);
    }

    private void checkAnimalOnGrass(Vector2d position){
        for (Grass grass: grasses) {
            if (grass.isAt(position)) {
                for (Animal animal: animals) {
                    if (animal.isAt(position)) {
                        grasses.remove(grass);
                        this.placeGrass();
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.isAt(position)) return animal;
        }
        for (Grass grass: grasses) {
            if (grass.getPosition().equals(position)) return grass;
        }
        return null;
    }

    protected Vector2d[] mapSize(){
        Vector2d right_corner = grasses.get(0).getPosition();
        Vector2d left_corner = grasses.get(0).getPosition();
        for (Animal animal: animals) {
            right_corner = right_corner.upperRight(animal.getPosition());
            left_corner = left_corner.lowerLeft(animal.getPosition());
        }
        for (Grass grass: grasses) {
            right_corner = right_corner.upperRight(grass.getPosition());
            left_corner = left_corner.lowerLeft(grass.getPosition());
        }
        return new Vector2d[]{left_corner, right_corner};
    }
}
