package ipbeja.stu.po2.GUI;

import ipbeja.stu.po2.Model.CellPosition;
import ipbeja.stu.po2.Model.World;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class WorldBoard extends Pane {


    private int CELL_SIZE;
    private int nLinesPane;
    private int nColsPane;
    private Rectangle rectangle;

    /**
     * Class Constructor
     */
    public WorldBoard(World world, int worldSize) {
        this.CELL_SIZE = worldSize;
        this.nLinesPane = world.nLines() * CELL_SIZE;//gets the SIZE of lines on the pane
        this.nColsPane = world.nCols() * CELL_SIZE;//gets the SIZE on the columns on the pane
        //Sets the PrefSize to the same number of lines and columns
        this.setPrefSize(this.nLinesPane, this.nColsPane);
        this.rectangle=null;
    }

    /**
     * Method that populates the world
     */
    public void populateWorld(CellPosition position)
    {
        this.rectangle = this.addRectangle(position);
    }

    /**
     * Method that makes the javaFx Thread update the rectangle of this WorldBoard
     * @param dx
     * @param dy
     */
    public void updatePosition(int dx, int dy)
    {
        //Makes a translation of the square on thw WorldBoard
        TranslateTransition tt = new TranslateTransition(Duration.millis(200), this.rectangle);
        tt.setByX(dx * CELL_SIZE);//gives the square new position on the X axis to draw
        tt.setByY(dy * CELL_SIZE);//gives the square new position on the y axis to draw
        tt.play();
    }

    /**
     * Adds the rectangle to the WorldBoard
     * @param position
     * @return
     */
    private Rectangle addRectangle(CellPosition position) {
        int line = position.getLine() * CELL_SIZE;
        int col = position.getCol() * CELL_SIZE;

        Rectangle r = new Rectangle(col, line, CELL_SIZE, CELL_SIZE);

        r.setFill(Color.BLUE);
        //Makes the the next code run on the Thread of javaFx to be able to update it's position
        Platform.runLater( () ->{
            this.getChildren().add(r);
        });
        return r;
    }
}
