package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {
    private AbstractWorldMap worldMap;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Zwierzak");
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(createGrid(), 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public GridPane createGrid(){
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(25.0));
        gridPane.getRowConstraints().add(new RowConstraints(25.0));
        Vector2d[] corners = worldMap.mapSize();

        int xOffset = -corners[0].x + 1;
        int yOffset = -corners[0].y + 1;

        gridPane.add(new Label(" y/x "), corners[0].x-1 + xOffset, corners[0].y-1 + yOffset);

        for (int i = corners[0].x; i <= corners[1].x; i++) {
            gridPane.add(new Label("  "+ i +"  "), i+xOffset, corners[0].y-1+yOffset);
        }
        for (int i = corners[0].y; i <= corners[1].y; i++) {
            gridPane.add(new Label("  "+ i), corners[0].x-1+xOffset, i + yOffset);
        }
        for (int i = corners[0].x; i <= corners[1].x; i++) {
            for (int j = corners[0].y; j <= corners[1].y; j++) {
                if (worldMap.isOccupied(new Vector2d(i,j))){
                    Label label = new Label(worldMap.objectAt(new Vector2d(i,j)).toString());
                    gridPane.add(label,i+xOffset,j+yOffset);
                    GridPane.setHalignment(label, HPos.CENTER);
                }

            }
        }
        return gridPane;
    }
    @Override
    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        worldMap = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,2) };
        IEngine engine = new SimulationEngine(directions, worldMap, positions);
        engine.run();
    }
}
