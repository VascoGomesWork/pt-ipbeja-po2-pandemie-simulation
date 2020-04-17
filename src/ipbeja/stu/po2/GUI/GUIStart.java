package ipbeja.stu.po2.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIStart extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //calls the contagious board
        ContagiousBoard board = new ContagiousBoard();
        Scene scene = new Scene(board);//Once that GUI Start extends Application, the class ContagiousBoard extends a Vbox
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulador de Pandemia COVID-19");
        //makes the program close when clicked on the cross button
        primaryStage.setOnCloseRequest((e) -> {
            System.exit(0);
        });
        primaryStage.show();
    }
}
