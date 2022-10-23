package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class AnimalTest {
    @Test
    public void animalTest(){
        String[][] inputs = {{"left", "r", "b"}, {"f", "r", "r"}, {"f", "f", "f", "f"}};
        MoveDirection[][] parserAnswers = {{MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD},
                {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT},
                {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD}};
        String[] finalPosition = {"(2,1) Północ", "(2,3) Południe", "(2,4) Północ"};
        Vector2d[][] currentPosition = {{new Vector2d(2, 2), new Vector2d(2, 2), new Vector2d(2, 1)},
                {new Vector2d(2, 3), new Vector2d(2, 3), new Vector2d(2, 3)},
                {new Vector2d(2, 3), new Vector2d(2, 4), new Vector2d(2, 4), new Vector2d(2, 4)}};
        OptionsParser optionsParser = new OptionsParser();

        for (int i = 0; i<inputs.length; i++ ) {
            MoveDirection[] translatedInput = optionsParser.parse(inputs[i]);
            assertArrayEquals(parserAnswers[i], translatedInput);
            Animal animal = new Animal();
            for (int j=0; j< translatedInput.length; j++){
                animal.move(translatedInput[j]);
                assertTrue(animal.isAt(currentPosition[i][j]));
            }
            assertEquals(finalPosition[i], animal.toString());
        }
    }
}
