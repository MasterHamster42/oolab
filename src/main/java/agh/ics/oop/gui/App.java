package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application implements IPositionChangeObserver{
    private AbstractWorldMap worldMap;
    private SimulationEngine simulationEngine;
    private final GridPane gridPane = new GridPane();
    private TextField textField;
    private long sleepDelay = 300;
    private Thread lastThread = new Thread();

    @Override
    public void start(Stage primaryStage) throws Exception {
        createGrid();
        Button button = new Button("Start simulation");
        button.setOnAction(action -> {startSimulation();});
        this.textField = new TextField();
        VBox vbox = new VBox(button, textField);
        HBox hbox = new HBox(gridPane, vbox);
        Scene scene = new Scene(hbox, 550, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void startSimulation(){
        System.out.println(Thread.getAllStackTraces());
        char[] args = this.textField.getCharacters().toString().toCharArray();
        this.textField.clear();
        MoveDirection[] directions = new OptionsParser().parse(args);
        this.simulationEngine.setDirections(directions);
//        this.lastThread.
        this.lastThread = new Thread(this.simulationEngine);
        this.lastThread.start();
        System.out.println(this.lastThread.isAlive());
        System.out.print(Thread.activeCount());
    }
    private void updateScene(){
        Node node = gridPane.getChildren().get(0);
        gridPane.getChildren().clear();
        gridPane.getChildren().add(0,node);
        reCreateGrid();
    }
    private void reCreateGrid(){
        Vector2d[] corners = worldMap.mapSize();
        int xOffset = -corners[0].x + 1;
        int yOffset = -corners[0].y + 1;
        Label xyLabel = new Label("  y/x");
        xyLabel.setAlignment(Pos.CENTER);
        gridPane.add(xyLabel, corners[0].x-1 + xOffset, corners[0].y-1 + yOffset);

        for (int i = corners[0].x; i <= corners[1].x; i++) {
            gridPane.add(new Label("    "+ i), i+xOffset, corners[0].y-1+yOffset);
        }
        for (int i = corners[0].y; i <= corners[1].y; i++) {
            gridPane.add(new Label("    "+ i), corners[0].x-1+xOffset, i + yOffset);
        }
        for (int i = corners[0].x; i <= corners[1].x; i++) {
            for (int j = corners[0].y; j <= corners[1].y; j++) {
                if (worldMap.isOccupied(new Vector2d(i,j))){
                    Label label = new Label(worldMap.objectAt(new Vector2d(i,j)).toString());
                    GuiElementBox guiElementBox = new GuiElementBox(worldMap.objectAt(new Vector2d(i,j)));
                    gridPane.add(guiElementBox.getvBox(),i+xOffset,j+yOffset);
                    GridPane.setHalignment(label, HPos.CENTER);
                }

            }
        }
    }
    public void createGrid(){
        gridPane.setGridLinesVisible(true);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(35);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(35);



        Vector2d[] corners = worldMap.mapSize();
        int xOffset = -corners[0].x + 1;
        int yOffset = -corners[0].y + 1;

        for (int i = 0; i < corners[1].y - corners[0].y+2; i++) {
            gridPane.getRowConstraints().add(rowConstraints);
        }
        for (int i = 0; i < corners[1].x - corners[0].x+2; i++) {
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        Label xyLabel = new Label("  y/x");
        xyLabel.setAlignment(Pos.CENTER);
        gridPane.add(xyLabel, corners[0].x-1 + xOffset, corners[0].y-1 + yOffset);

        for (int i = corners[0].x; i <= corners[1].x; i++) {
            gridPane.add(new Label("    "+ i), i+xOffset, corners[0].y-1+yOffset);
        }
        for (int i = corners[0].y; i <= corners[1].y; i++) {
            gridPane.add(new Label("    "+ i), corners[0].x-1+xOffset, i + yOffset);
        }
        for (int i = corners[0].x; i <= corners[1].x; i++) {
            for (int j = corners[0].y; j <= corners[1].y; j++) {
                if (worldMap.isOccupied(new Vector2d(i,j))){
                    Label label = new Label(worldMap.objectAt(new Vector2d(i,j)).toString());
                    GuiElementBox guiElementBox = new GuiElementBox(worldMap.objectAt(new Vector2d(i,j)));
                    gridPane.add(guiElementBox.getvBox(),i+xOffset,j+yOffset);
                    GridPane.setHalignment(label, HPos.CENTER);
                }

            }
        }
    }
    @Override
    public void init() throws Exception {
//        String[] args = getParameters().getRaw().toArray(new String[0]);
//        MoveDirection[] directions = new OptionsParser().parse(args);
        worldMap = new GrassField(10);
        worldMap.addObserver(this);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,2) };
        this.simulationEngine = new SimulationEngine(worldMap, positions, sleepDelay);
//        engine.setDirections(directions);
//        engineThread = new Thread(engine);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(this::updateScene);
    }
}
