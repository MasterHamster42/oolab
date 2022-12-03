package agh.ics.oop;

public class Grass extends AbstractMapObject{

    public Grass(Vector2d position){
        this.position = position;
        this.type = "Grass";
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getResourcePath() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String getCaption() {
        return "grass";
    }
}
