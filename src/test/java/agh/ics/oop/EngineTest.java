package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EngineTest {
    @Test
    public void engineTest(){
        String[][] moves = {{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"},
                {"f","f","f","f","f","f","f"}};
        Vector2d[][] starting_vectors = {{new Vector2d(2,2), new Vector2d(3,4)},
                {new Vector2d(0,0)}};
        Vector2d[][] final_vectors = {{new Vector2d(2, 0), new Vector2d(3,5)},
                {new Vector2d(0,5)}};

        for(int i = 0; i< moves.length; i++){
            MoveDirection[] directions = new OptionsParser().parse(moves[i]);
            IWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = starting_vectors[i];
            IEngine engine = new SimulationEngine(directions, map, positions, 10);
            engine.run();
            for (int j=0; j< starting_vectors[i].length; j++) {
                assertTrue(map.isOccupied(final_vectors[i][j]));
            }
        }
        String[] moves_wrong = {"f", "g", "g"};
        MoveDirection[] expected = {MoveDirection.FORWARD};
        boolean wasException = false;
        MoveDirection[] moveDirections;
        try {
            moveDirections = new OptionsParser().parse(moves_wrong);
            assertArrayEquals(expected, moveDirections);
        }
        catch (IllegalArgumentException illegalArgumentException){
            wasException = true;
        }
        finally {
            assertTrue(wasException);
        }

    }
}
