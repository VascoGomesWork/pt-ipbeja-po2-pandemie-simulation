package ipbeja.stu.po2.Model;

import ipbeja.stu.po2.GUI.ContagiousBoard;

public class World {

    private final ContagiousBoard contagiousBoard;
    private final int line;
    private final int column
            ;
    //Grid from the Cell type
    private Cell cell;
    private View view;

    /**
     * Class constructor World
     * @param contagiousBoard
     * @param line
     * @param column
     */
    public World(ContagiousBoard contagiousBoard, int line, int column) {
        this.contagiousBoard = contagiousBoard;
        this.line = line;
        this.column = column;
        System.out.println("Hello from the World Classe");
    }

    /**
     * Method start that makes a new Tread and executes 2 other methods from the class in a new Tread
     * Executes the next function on a new Thread to make javaFx Thread available for updating the WorldBoard
     */
    public void start() {
        new Thread( () -> {
            this.populate();
            this.simulate(200);
        }).start();
    }

    /**
     * Method that simulates the square moving around according to the number off iterations from the variable nIter
     * @param nIter
     */
    private void simulate(int nIter) {
        for (int i = 0; i < nIter; i++) {
            try {
                //Puts the current Thread to sleep for about 200 miliseconds
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //if the cell moves the view updates the position
            if(cell.randomMove()) {
                this.view.updatePosition(cell.dx(), cell.dy(), i);
            }
        }
    }

    /**
     * Method for populating the World , it's passed it's work to the WorldBoard to the method populateWorld
     */
    private void populate() {
        view.populateWorld(cell.cellPosition());
    }

    public int nLines() {
        return this.line;
    }

    public int nCols() {
        return this.column;
    }
}
