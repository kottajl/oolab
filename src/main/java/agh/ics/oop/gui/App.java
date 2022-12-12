package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.List;

public class App extends Application {

    private String[] doStringArray (List<String> input) {
        int n= input.size();
        String[] output= new String[n];

        int i= 0;
        for (String s: input) {
            output[i]= s;
        }

        return output;
    }

    private String drawObject (Vector2d currentPosition, IWorldMap map) {
        String result = null;
        if (map.isOccupied(currentPosition)) {
            Object object = map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            } else {
                result = "";
            }
        } else {
            result = "";
        }
        return result;
    }

    @Override
    public void start (Stage primaryStage) /*throws Exception*/ {
        //String[] input= doStringArray(getParameters().getRaw());     // <--- ?
        String[] input= getParameters().getRaw().toArray(new String[0]);
        System.out.println(Arrays.toString(input));
        String[] temp= {"f", "r", "l", "f", "f", "f"};
        //String[] temp= {"l", "l", "f", "f", "f", "f", "f", "f"};

        IWorldMap map = null;
        try {
            MoveDirection[] directions = new OptionsParser().parse(temp);       // tu zamiast 'temp' winno być 'input', ale mi to nie działa i nie rozumiem błędu :c
            map = new GrassField(8);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
            return;
        }

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        int width= map.defineMaxCorner().x - map.defineMinCorner().x + 1;
        int height= map.defineMaxCorner().y - map.defineMinCorner().y + 1;

        gridPane.add(new Label("y/x"), 0, 0);
        for (int i=1; i<=width; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            Label label= new Label(Integer.toString(map.defineMinCorner().x + i - 1));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, i, 0);
        }
        for (int j=1; j<=height; j++) {
            gridPane.getRowConstraints().add(new RowConstraints(30));
            Label label= new Label(Integer.toString(map.defineMaxCorner().y - j + 1));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, 0, j);
        }

        for (int i=1; i<=width; i++) {
            for (int j=height; j>=1; j--) {
                Label label= new Label(drawObject(new Vector2d(map.defineMinCorner().x + i - 1, map.defineMinCorner().y + map.defineMaxCorner().y - j - 1), map));
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, i, j);
            }
        }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
