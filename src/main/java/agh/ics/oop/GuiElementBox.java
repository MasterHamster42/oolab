package agh.ics.oop;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GuiElementBox {
    VBox vBox;
    static ArrayList<ImageView> imageViews = new ArrayList<>();
    static ArrayList<String> imageNames = new ArrayList<>();

    public GuiElementBox(IMapElement iMapElement){
        String filePath = iMapElement.getResourcePath();
        String caption = iMapElement.getCaption();
        ImageView imageView;
        if (imageNames.contains(filePath)){
            imageView = imageViews.get(imageNames.indexOf(filePath));
        }
        else{
            Image image = null;
            try {
                image = new Image(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
        }

        Label label = new Label(caption);
        vBox = new VBox(imageView, label);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}
