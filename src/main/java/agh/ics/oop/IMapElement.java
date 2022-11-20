package agh.ics.oop;
/*
  Użycie iMapElement może potencjalnie uprościć implementacje grassField poprzez zastosowanie jednej listy
  do przechowywania grass i animals uproszczając tym kilka metod.
  Dodanie AbstractWorldMapElement było by sensowne w przypdaku duzej ilości typów elemntów implementujących IMapElement,
  znacznie zmniejszając ilość powtarzanego kodu.
*/

/**
 * The interface responsible for representing objects in the world, assumes that Vector2D is defined.
 *
 */
public interface IMapElement {
    /**
    * Return position in world of the object.
    */
    Vector2d getPosition();
    /**
     * Return true if position of the object in the world is equal to argument position.
     */
    boolean isAt(Vector2d position);

}
