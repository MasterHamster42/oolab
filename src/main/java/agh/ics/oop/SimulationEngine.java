package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private ArrayList<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.map = map;
        this.moves = moves;
        for (Vector2d position: positions) {
             Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }
    @Override
    public void run() {
        for (int i=0; i < moves.length; i++){
            animals.get(i%animals.size()).move(moves[i]);
        }
    }
}
