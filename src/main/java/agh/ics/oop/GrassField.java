package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{
    private int AmountOfGrass;
//    private ArrayList<Grass> grasses = new ArrayList<Grass>();

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
        Grass grass = new Grass(place_grass_at);
        mapObjects.put(place_grass_at ,grass);
        mapBoundary.addObject(grass);
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
        if(!isOccupied(position)){
            return;
        }
        if(Objects.equals(mapObjects.get(position).type, "Grass")){
            mapObjects.remove(position);
            this.placeGrass();
        }
    }
    

    public Vector2d[] mapSize(){
        mapBoundary.updateCorners();
        return mapBoundary.getCorners();
    }
}
