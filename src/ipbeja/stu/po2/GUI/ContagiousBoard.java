package ipbeja.stu.po2.GUI;

import ipbeja.stu.po2.Model.Cell;
import ipbeja.stu.po2.Model.View;
import ipbeja.stu.po2.Model.World;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class ContagiousBoard extends VBox implements View {

    private World world;
    private WorldBoard pane;
    private int worldSize = 10;

    public ContagiousBoard()
    {
        Button startButton = new Button("Start Simulation");
        startButton.setPrefWidth(300);
        startButton.setPrefHeight(300);

        //Adds new stuff to the pane
        this.getChildren().add(startButton);

        //When button startButton is clicked runs the code that is on mouce clicked
        startButton.setOnMouseClicked((e) ->{
            world = new World(this, 10, 10);
            //calls the WorldBoard class
            this.pane = new WorldBoard(this.world, worldSize);
            //After the Start Simulation Button has been clicked the Button desapears and
            this.getChildren().remove(startButton);
            //Because we are passing pane to the WorldBoard class we have to extends Pane so it won't give any error
            this.getChildren().addAll(this.pane);
            this.getScene().getWindow().sizeToScene();

            world.start();
        });

    }

    @Override
    public void populateWorld(Cell position) {

    }

    @Override
    public void updatePosition(int dx, int dy, int i) {

    }
}
