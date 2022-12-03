package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] directions;
    private long sleepDelay;
    private ArrayList<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, long sleepDelay){
        this.directions = moves;
        this.sleepDelay = sleepDelay;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }
    public SimulationEngine(IWorldMap map, Vector2d[] positions, long sleepDelay){
        this.directions = new MoveDirection[]{};
        this.sleepDelay = sleepDelay;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }

    @Override
    public void run() {
//        System.out.println("run running");
//        Runnable updater = new Runnable() {
//
//            @Override
//            public void run() {
//                if (animals.size() > currentIteration){
//                    System.out.print(currentIteration);
//                    System.out.println(" trying to move animal");
//                    animals.get(currentIteration%animals.size()).move(moves[currentIteration]);
//                }
//            }
//        };
//        Runnable task = () -> {
//            Platform.runLater(() -> {
                for (int currentIteration=0; currentIteration < directions.length; currentIteration++){
                    try {
                        Thread.sleep(sleepDelay);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    animals.get(currentIteration%animals.size()).move(directions[currentIteration]);
                }
//
//            });
//        };
//            Thread thread = new Thread(task);
//            thread.setDaemon(true);
//            thread.start();
    }
}
